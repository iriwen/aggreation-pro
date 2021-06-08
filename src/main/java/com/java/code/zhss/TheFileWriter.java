package com.java.code.zhss;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by iriwen on 2020/10/10.
 */
public class TheFileWriter {

    public static void main(String[] args) throws Exception {

        File file = new File("/home/worker/test1.txt");
        if (!file.exists()) {

            file.createNewFile();
        }
        List<String> strs = Stream.of("blue", "red", "yellow").collect(Collectors.toList());

        Writer writer = new FileWriter(file);

        strs.forEach(item -> {

            //String str = "我是中国人-FileWriter";
            // 把内容转换成字符数组
            char[] data = (item + System.getProperty("line.separator")).toCharArray();
            // 向文件写入内容
            try {
                writer.write(data);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();

        InputStream is = new FileInputStream(file);
        is.available();
    }

    public void download(String fileName , String localFileName){

        HttpClient httpclient = new HttpClient();
        GetMethod get = null;
        FileOutputStream output = null ;

        try {
            get = new GetMethod("url");
            get.setRequestHeader("Content-type", "attach");

            int i = httpclient.executeMethod(get);

            File file = new File(localFileName);
            output = new FileOutputStream(file);

            //得到网络资源的字节数组，并写入到本地文件，可以选择写入到response对象返回给前端
            output.write(get.getResponseBody());
        }catch (Exception e){

        } finally{
            httpclient.getHttpConnectionManager().closeIdleConnections(0);
        }

    }

    @RequestMapping("/testHttpMessageDown")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        File file = new File("~/123.jpg");

        GetMethod get = null;
        byte[] body = get.getResponseBody();

        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);

        byte[] responseBody = get.getResponseBody();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());

        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(responseBody, headers, statusCode);
        return entity;
    }


}
