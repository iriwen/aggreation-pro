package com.java.code.lambda;

import java.io.IOException;

/**
 * created by yuxiaodong01 on 2020/04/23.
 */
public class TryWithResource {

    public static void main(String[] args){

       try(MyCloseAble closeAble = new MyCloseAble()){
           closeAble.sendData();
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}

class MyCloseAble implements AutoCloseable{

    public void sendData(){
        System.out.println("is sending data");
    }

    @Override
    public void close() throws IOException {
        System.out.println("is closing connection !");
    }
}

