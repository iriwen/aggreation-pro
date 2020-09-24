package com.java.code.zhss;

/**
 * created by yuxiaodong01 on 2020/09/24.
 */
public class Interupt01 extends Thread{

    private boolean notExist = true;

    public void run(){

        while (notExist) {
            System.out.println("thread running ......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void exitOperate() {
        this.notExist = false;
    }

    public static void main(String[] args) throws InterruptedException {

        Interupt01 thread = new Interupt01();
        thread.start();
        Thread.sleep(2000);

        thread.exitOperate();
        //interrupt 会打断sleep
        thread.interrupt();
    }

}
