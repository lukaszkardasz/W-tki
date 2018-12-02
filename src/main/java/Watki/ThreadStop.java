package Watki;

public class ThreadStop {

    private static boolean stopRequested = false;

    private static synchronized void requestStop() {
        stopRequested = true;
    }
    private static boolean isStopRequested() {
        return stopRequested;
    }

    public static synchronized void main(String[] args) throws Exception {
        System.out.println("Hello world!!");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Rozpoczyna się wątek t");
                int i = 0;
                while (!stopRequested){
                    System.out.println(i);
                    i++;
                }
                System.out.println("Kończy się wątek t");
            }
        });
        System.out.println("Rozpoczyna się wątek główny");
        t.start();
        Thread.sleep(1000);
        requestStop();
        System.out.println("Kończy się wątek główny");
    }


}
