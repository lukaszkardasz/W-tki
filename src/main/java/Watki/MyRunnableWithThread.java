package Watki;

public class MyRunnableWithThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello, I'm thread!");
    }

    public static void main(String[] args) {
        Thread t = new MyRunnableWithThread();
        t.start();
        System.out.println("Hello world!!");
    }

}
