package cn.yy.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadTest {
    public static void main(String[] args) {

        List<String> strings=new LinkedList<>();
        String s=new String();
        Thread1 thread1=new Thread1();
        thread1.setName("线程一");
        thread1.start();
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"_"+i);
            }

            if(i%20==0){
                thread1.yield();

            }
        }

    }
}
class Thread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+"_"+i);
            }
        }
    }
}
