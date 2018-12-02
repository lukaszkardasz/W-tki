package Watki;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreatRunnerExample {

    private static final long MAX_VALUE = 100_000_000_000L;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //execute(MAX_VALUE);
        //lambdaRunnable(MAX_VALUE);
        ExampleWith8Threads(MAX_VALUE);
    }

    private static void ExampleWith8Threads(long maxValue) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            //dodać runnable do listy zadań
            tasks.add(new Callable<String>() {
                @Override
                public String call () throws Exception {
                    for (long l = 0; l < MAX_VALUE / 4; l++);
                    return null;
                }
            });
        }
        long startTime = System.nanoTime();
        List<Future<String>> futures = executorService.invokeAll(tasks);
        for (Future<String> result : futures) result.get();
        long endtTime = System.nanoTime();
        System.out.println("Nazwa wątku: " + Thread.currentThread().getName() + " time: "
                + (double) (endtTime - startTime) / 1_000_000_000);
        executorService.shutdown();

    }

    private static void lambdaRunnable(long value) {
        Runnable myRunnable = () -> {
            Thread currentThread = Thread.currentThread();
            System.out.println("Nazwa wątku: " + currentThread.getName() + " robi robote...");
            execute(MAX_VALUE);
        };

        Thread thread1 = new Thread(myRunnable);
        thread1.start();
        Thread mainThread = Thread.currentThread();
        System.out.println("Nazwa watku: " + mainThread.getName() + " robi robote...");
        execute(MAX_VALUE);

    }

    private static void execute(long value) {
        //narzedzie do pomiarow czasu - nanotime
        long startTime = System.nanoTime();
        for (long l = 0; l < MAX_VALUE; l++) ;
        long endTime = System.nanoTime();
        System.out.println("Runtime: " + (endTime - startTime) / 1_000_000_000 + " sek"); //dzielimy przez miliard bo to nanosekundy
    }




}
