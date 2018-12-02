package Watki;

public class MyRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println("Hello, I'm thread!");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyRunnable());
        t.start();
        Thread.sleep(1);
        System.out.println("Hello world!!");
    }
}
