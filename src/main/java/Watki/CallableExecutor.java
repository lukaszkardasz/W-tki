package Watki;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExecutor  implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Hello thread: ");
        return Thread.currentThread().getName();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Od tego sie zaczyna!");

        //runSingleThread();
        runMultipleThreads();

    }

    private static void runMultipleThreads() throws InterruptedException {
        ExecutorService executeMultipleService = Executors.newFixedThreadPool(8);
        //definiujemy liste zadan wykonania przez watki
        List<Callable<String>> tasks = new ArrayList<>();
        //dodaje zadania petla for - on tworzy 10 obiektów callable wykonywane przez 8 watkow
        for (int i = 0 ; i < 10; i++){
            tasks.add(new CallableExecutor());
        }
        executeMultipleService.invokeAll(tasks);
        Thread.sleep(1000);

    }

    private static void runSingleThread() throws InterruptedException, ExecutionException {
        //Wywoluje nowy watek z góry w mainie + tworzymy eecutora, ktory wywoluje obiekty callable - Executory sa rozne, odpalajace jeden watek lub wiecej
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //Executor metoda submit uruchamia metode call, ktora odpala watek z call
        Future<String> threadResult = executorService.submit(new CallableExecutor());

        System.out.println("Wynik: " + threadResult.get());
        executorService.shutdown();
    }

}
