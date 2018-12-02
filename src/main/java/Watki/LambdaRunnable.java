package Watki;

public class LambdaRunnable {
    public static void main(String[] args) {
        System.out.println("Hello, im main thread!");

        //od tego momentu lambda tworzy nowy watek i odpala w srodku run
        Runnable myRunnable = () -> {
            System.out.println("Hello, im thread!!!");
            Thread currentThread = Thread.currentThread();
            System.out.println("Nazwa wątku: " + currentThread.getName());
        };

        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        Thread mainThread = Thread.currentThread();
        System.out.println("Wątek główny: " + mainThread.getName());


    }
}
