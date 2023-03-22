import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
    Analiza wynikow:
    Przy czasie zycia pszczoly rownym 10 sekund, maksymalna liczba pszczol jaka ul moze obsluzyc,
    aby sredni czas oczekiwania pszczoly na wejscie do ula nie przekraczal 5 sekund, to 15.
*/

public class Main {
    private static final int MAX_BEES = 10; //liczba pszczol jakie zostana wypuszczone
    private static final int BEE_LIFE_TIME = 10; //czas zycia jednej pszczoly (w sekundach)
    private static final String OUTPUT_FILE_NAME = "bees.data.txt";

    public static void main(String[] args) throws InterruptedException, IOException {
        // Ustawienie maksymalnej liczby pszczół
        int maxBees = MAX_BEES;
        if (args.length > 0) {
            try {
                maxBees = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa wartość maksymalnej liczby pszczół. Użyto domyślnej wartości: " + MAX_BEES);
            }
        }

        System.out.println("Ilosc pszczol w symulacji ula: " + maxBees);

        // Utworzenie i uruchomienie wątków pszczół
        Bee[] bees = new Bee[maxBees];
        Thread[] beesThreads = new Thread[maxBees];

        for (int i = 0; i < maxBees; i++) {
            bees[i] = new Bee(i, BEE_LIFE_TIME);
            beesThreads[i] = new Thread(bees[i]);
            beesThreads[i].start();
        }


        for (int i = 0; i < maxBees; i++) {
            beesThreads[i].join();
        }

        System.out.println("\nSymulacja ula zakonczona");

        File beesDataFile = new File(OUTPUT_FILE_NAME);
        FileWriter saveDataToFile = new FileWriter(beesDataFile);

        double average = 0.0;


        saveDataToFile.write("id, liczba wejsc, sredni czas czekania\n");
        for (int i = 0; i < maxBees; i++) {

            saveDataToFile.write(bees[i].getId()+", "+ bees[i].getEntryExitCount()+", "+ bees[i].getAvgTotalWaitingTime() + "\n");
            average += bees[i].getAvgTotalWaitingTime();
        }

        average /= maxBees;

        saveDataToFile.write("Sredni czas czekania: " + average + "\n");



        saveDataToFile.close();
        System.out.println("Dane zostaly zapisane w pliku " + OUTPUT_FILE_NAME);
        }
    }
