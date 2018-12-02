package Watki;

/*najlepsze rozwiazanie zatrzymania watku*/

public class ThreadStopWithInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!Thread.interrupted()){
                    System.out.println(i);
                    i++;
                }

            }
        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
