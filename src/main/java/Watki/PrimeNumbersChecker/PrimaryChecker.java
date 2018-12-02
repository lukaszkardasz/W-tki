package Watki.PrimeNumbersChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimaryChecker {

    public static String path = "primes-to-1000k.txt";

    public static boolean isPrime(long value) {

        if (value < 2) return false;
        if (value == 2) return true;
        for (long i = 2; i < Math.sqrt(value);i++){
            if(value % i == 0) return false;
        }
        return true;
    }

    static void checkPrimesFromFile() throws FileNotFoundException {
        Scanner skaner = new Scanner (new File (path));


            Long primeCounter = 0L;
            while (skaner.hasNextLong()) {
                long numberFromFile = skaner.nextLong();
                boolean result = isPrime(numberFromFile);
                if (result){
                    primeCounter++;
                    System.out.println(numberFromFile);
                }
            }
        System.out.println("Liczb pierwszysch jest: " + primeCounter);
            skaner.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        checkPrimesFromFile();
    }




}
