package Watki;

public class JasIMalgosia {


    public static void main(String[] args) throws InterruptedException {


        Thread jas = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doWork("Jas je sniadanie...", 5000);
                    doWork("Jas konczy sniadanie", 0);
                    doWork("Jas bierze prysznic...", 3000);
                    doWork("Jas konczy prysznic", 0);
                    doWork("Jas ubiera sie...", 1000);
                    doWork("Jas konczy sie ubierac", 0);
                    doWork("Jas idzie na zakupy...", 15000);
                    doWork("Jas wrocil z zakupow", 0);
                    doWork("Jas gra na konsoli...", 5000);
                    doWork("Jas skonczyl grac na konsoli", 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread malgosia = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    doWork("Malgosia idzie biegac...", 6000);
                    doWork("Malgosia konczy Biegac", 0);
                    doWork("Malgosia bierze prysznic...", 2000);
                    doWork("Malgosia konczy prysznic", 0);
                    doWork("Malgosia je sniadanie...", 1000);
                    doWork("Malgosia konczy sniadanie", 0);
                    doWork("Malgosia ubiera sie...", 1000);
                    doWork("Malgosia skonczyla sie ubierac", 0);
                    doWork("Malgosia spotyka sie z kolezanka...", 25000);
                    doWork("Malgosia zakonczyla spotkanie z kolezanka", 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

        jas.start();
        malgosia.start();
        jas.join();
        malgosia.join();
        System.out.println("_____Koniec dnia!________");
    }

    private static void doWork(String message, int time) throws InterruptedException {
        System.out.println(message);
        Thread.sleep(time);
    }

}
