package Watki;

public class ThreatRunnerExample {

    private static final long MAX_VALUE = 100_000_000_000L;

    public static void main(String[] args) {
        //execute(MAX_VALUE);
        lambdaRunnable(MAX_VALUE);
    }

    private static void lambdaRunnable(long value) {
        Runnable myRunnable = () -> {
            Thread currentThread = Thread.currentThread();
            System.out.println("Nazwa wątku: " + currentThread.getName() + " robi robote:");
            execute(MAX_VALUE);
        };

        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        Thread mainThread = Thread.currentThread();
        System.out.println("Wątek główny: " + mainThread.getName());


    }

    private static void execute(long value) {
        //narzedzie do pomiarow czasu - nanotime
        long startTime = System.nanoTime();
        for (long l = 0; l < MAX_VALUE; l++) ;
        long endTime = System.nanoTime();
        System.out.println("Runtime: " + (endTime - startTime) / 1_000_000_000 + " sek"); //dzielimy przez miliard bo to nanosekundy
    }




}
