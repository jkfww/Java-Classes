import java.util.Random;

public class Bee extends Hive implements Runnable {
    private final int id;
    private final Random random;

    private int entryExitCount; //laczna liczba wszystkich wejsc i wyjsc

    private double totalWaitingTime; //laczny czas oczekiwania na dziure
    private long startWaitingTime, endWaitingTime;

    //private double BEE_LIFE_TIME = 10; //czas w ktorym pszczola lata
    private final int beeLifeTimeInSec;

    public Bee(int id, int beeLifeTimeInSec) {
        this.id = id;
        this.random = new Random();
        this.totalWaitingTime = 0.0;
        this.entryExitCount = 0;
        this.beeLifeTimeInSec = beeLifeTimeInSec;
    }

    private void addWaitingTime(double time) {
        this.entryExitCount++;
        this.totalWaitingTime += time;
    }

    public int getId()
    {
        return this.id;
    }

    public int getEntryExitCount()
    {
        return entryExitCount;
    }

    public double getAvgTotalWaitingTime()
    {
        if(entryExitCount==0) return 0.0;

        return totalWaitingTime/entryExitCount;
    }




    public void run()
    {

        long startProgramTime = System.currentTimeMillis();

        while (System.currentTimeMillis()<startProgramTime + (beeLifeTimeInSec* 1000L))
        {

            // Losowanie czasu spędzonego na zewnątrz ula
            int waitTimeOutside = random.nextInt(MAX_WAIT_TIME_OUTSIDE - MIN_WAIT_TIME_OUTSIDE + 1) + MIN_WAIT_TIME_OUTSIDE;

            System.out.println("Pszczola " + id + " lata przy ulu ");

            try {
                Thread.sleep(waitTimeOutside * 1000); //czekaj na zewnatz
            } catch (InterruptedException e) {
                // ignorowanie wyjątku
            }

            // wejście


            System.out.println("Pszczola " + id + " probuje wleciec dziura " + hole1.getNumber());

            if(hole1.available)
            {
                hole1.available = false;
                System.out.println("Pszczola " + id + " bedzie wlatywac do dziury " + hole1.getNumber());

                synchronized (hole1) {
                    System.out.println("Pszczola " + id + " wlatuje do dziury " + hole1.getNumber());

                    hole1.addEntry();
                    try {
                        Thread.sleep(ENTRY_EXIT_TIME * 1000);
                    } catch (InterruptedException e) {
                        //ignore
                    }
                    hole1.available = true;
                }


            } else {
                System.out.println("Dziura " + hole1.getNumber() + " jest zajeta, Pszczola " + id + " bedzie wlatywac do dziury " + hole2.getNumber());
                startWaitingTime = System.currentTimeMillis(); //ile czasu pszczola bedzie czekac na wejscie
                synchronized (hole2) {
                     endWaitingTime = System.currentTimeMillis(); //ile czekala
                    System.out.println("Pszczola " + id + " wlatuje do dziury " + hole2.getNumber());
                    hole2.available = false;
                    hole2.addEntry();

                    try {
                        Thread.sleep(ENTRY_EXIT_TIME * 1000);
                    } catch (InterruptedException e) {
                    // ignorowanie wyjątku
                        System.out.println("interrupted");
                    }

                    hole2.available = true;
                    //continue;
                }
            }


            System.out.println("Pszczola " + id + " czeka w ulu");

            addWaitingTime((endWaitingTime - startWaitingTime) / 1000.0);

            // Losowanie czasu spędzonego w ulu
            int waitTimeInside = random.nextInt(MAX_WAIT_TIME_INSIDE - MIN_WAIT_TIME_INSIDE + 1) + MIN_WAIT_TIME_INSIDE;
            try {
                Thread.sleep(waitTimeInside * 1000);
            } catch (InterruptedException e) {
                // ignorowanie wyjątku
            }

            // Przelot przez jedno z wyjść

            System.out.println("Pszczola " + id + " probuje wyleciec dziura " + hole1.getNumber());
            if (hole1.available) {
                System.out.println("Pszczola " + id + " bedzie wylatywac dziura " + hole1.getNumber());
                synchronized (hole1) {
                    System.out.println("Pszczola " + id + " wylatuje dziura " + hole1.getNumber());
                    hole1.available = false;
                    hole1.addExit();


                    try {
                        Thread.sleep(ENTRY_EXIT_TIME * 1000);

                    } catch (InterruptedException e) {
                        // ignorowanie wyjątku
                    }
                    hole1.available = true;
                }
            } else {

                System.out.println("Dziura " + hole1.getNumber() + " jest zajeta, Pszczola " + id + " bedzie wlatywac do dziury " + hole2.getNumber());
                startWaitingTime = System.currentTimeMillis();
                synchronized (hole2) {
                    endWaitingTime = System.currentTimeMillis();
                    hole2.available = false;
                    hole2.addExit();
                    System.out.println("Pszczola " + id + " wlatuje do dziury " + hole2.getNumber());

                    try {
                        Thread.sleep(ENTRY_EXIT_TIME * 1000);

                    } catch (InterruptedException e) {
                        // ignorowanie wyjątku
                    }
                    hole2.available = true;
                }
            }


            addWaitingTime((endWaitingTime - startWaitingTime) / 1000.0);

        }
    }
}
