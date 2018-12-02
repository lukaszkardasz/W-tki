package Watki;

public class Main {



    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
        System.out.println("Hello world!!");
    }
}
