package cn.yy.test2;

public class SaleTicket {
    public static void main(String[] args) {
        window window1=new window();
        window window2=new window();
        window window3=new window();

        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();

        StringBuffer sb=new StringBuffer();
        String s=new String();

    }

}
class window extends Thread{
    public static int count=100;
    @Override
    public void run() {
        while(count>0){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"售出了第"+count+"票");
            count--;
        }
        System.out.println("票卖完了！");
    }
}
