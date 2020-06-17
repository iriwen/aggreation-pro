package com.java.code.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * created by yuxiaodong01 on 2020/06/17.
 */
public class NIOExample {

    public static void main(String[] args) throws Exception {

        //1创建socket   2bind文件描述符到相应的端口  3 执行listen 监听端口
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.configureBlocking(false);
        serverSocket.socket().bind(new InetSocketAddress("localhost", 9090));

        System.out.println("Server listen : " + 9090);
        //在epoll模型下,相当于执行的是epoll_create操作--->fd3（根据操作系统的不同可能是select、pol和epoll）,内核会开辟一个空间
        Selector selector = Selector.open();

        //相当于将listen的文件描述符放到刚才selector open时候所开辟的空间
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        for (; ; ) {

            while (selector.select(50) > 0) {
                //获得有状态的文件描述符(fd)集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (!key.isValid()) {
                        return;
                    }
                    //fd的状态是可接收连接的
                    if (key.isAcceptable()) {
                        acceptHandler(key, selector);
                        iterator.remove();
                    } else if (key.isReadable()) {
                        readHandler(key);
                        iterator.remove();
                    } else if (key.isWritable()) {

                    }
                }
                SocketChannel socketChannel = serverSocket.accept();
                if (socketChannel != null) {
                    System.out.println("client connected");
                }
            }
        }
    }

    private static void acceptHandler(SelectionKey eventKey, Selector selector) throws Exception {

        ServerSocketChannel serverChannel = (ServerSocketChannel) eventKey.channel();

        SocketChannel clientChannel = serverChannel.accept();

        clientChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        clientChannel.register(selector, SelectionKey.OP_READ, buffer);

        System.out.println("客户端：" + clientChannel.getRemoteAddress());
    }

    private static void readHandler(SelectionKey key) throws IOException {

        SocketChannel channel = (SocketChannel) key.channel();
        int byteReads = 0;
        while (true) {

            ByteBuffer buffer = ByteBuffer.allocate(512);
            buffer.clear();
            int readNum = channel.read(buffer);
            if (readNum <= 0) {
                break;
            } else {
                byteReads += readNum;
            }
            buffer.flip();
            String result = new Date(System.currentTimeMillis()).toString() + "ok !";
            byte[] bytes = result.getBytes();

            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
        System.out.println("read " + byteReads + " bytes  from " + channel);
    }
}
