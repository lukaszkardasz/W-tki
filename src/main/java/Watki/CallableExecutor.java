package Watki;

import java.util.concurrent.*;

public class CallableExecutor  implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Hello thread!");
        return "test";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Od tego sie zaczyna!");

        //Wywoluje nowy watek z góry w mainie + tworzymy eecutora, ktory wywoluje obiekty callable
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //metoda submit uruchamia metode call, ktora odpala watek z call
        Future<String> threadResult = executorService.submit(new CallableExecutor());


        System.out.println("Wynik: " + threadResult.get());
        executorService.shutdown();
    }

}
