package apps.MultithreadingCollection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

/**
 *  @author Oleg Rudoi
 *  @version 1.1 08 Dec 2022
 */
public class PetrolStation {
    private double amount;
    private ExecutorService stationExecutor;

    /* the number of requests that can be processed at the same time */
    private static final int QNTY_REFUELING_STATIONS = 3;
    private static final int FASTEST_REFUELING_TIME = 3000;
    private static final int SLOWEST_REFUELING_TIME = 10000;

    public PetrolStation(double amount) {
        this.amount = amount;
        initStationExecutor();
    }

    /**
     * creates an executor to handle all incoming refill requests
     */
    private void initStationExecutor() {
        stationExecutor = Executors.newFixedThreadPool(QNTY_REFUELING_STATIONS);
    }

    public double getAmount() {
        return amount;
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * performs fuel sales from a petrol station
     * The method performs the waiting time for refueling and
     * subtracts the required quantity of fuel from the amount supply at station
     *
     * @param qnty required quantity of fuel in the request
     */
    public void doRefuel(double qnty) {
        // create a runnable to perform the requests in multithreaded mode
        Runnable runnable = () -> {
            // output the necessary operations
            System.out.println("The client at station " +
                    Thread.currentThread().getName() +
                    " ordered " + qnty + ".");

            waitingForRefueling();

            // sell fuel
            double sold;
            synchronized (this) {
                sold = checkAmountValue(qnty);
                setAmount(amount - sold);
            }

            // output the operation result
            System.out.println("Refuel confirmed at station " +
                    Thread.currentThread().getName() +
                    " for " + sold + ". Amount of fuel remaining: " + amount);
        };
        // perform fuel sales
        stationExecutor.submit(runnable);
    }

    /**
     * make a waiting time for refueling
     */
    private static void waitingForRefueling() {
        try {
            sleep(ThreadLocalRandom.current().nextInt(FASTEST_REFUELING_TIME, SLOWEST_REFUELING_TIME));
        } catch (InterruptedException e) {
            System.out.println("Sorry, petrol station is closed");
            throw new RuntimeException(e);
        }
    }

    /**
     * check the remaining fuel at the fuel station
     * The method stops sales if there is not enough fuel amount.
     * Sells less if balance is greater than 0
     *
     * @param qnty required quantity of fuel in the request
     * @return checked quantity of fuel
     */
    private double checkAmountValue(double qnty) {
        double value = qnty;
        if (this.amount <= 0) {
            System.out.println("Sorry, all fuel is sold out");
            stationExecutor.shutdownNow();
        } else if (this.amount < value) {
            value = this.amount;
            System.out.println("Hey, we can sell you only " + value + ".");
            stationExecutor.shutdownNow();
        }
        return value;
    }

    public void close() {
        if (!stationExecutor.isShutdown()) {
            stationExecutor.shutdown();
        }
    }
}