package apps.MultithreadingCollection;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  @author Oleg Rudoi
 *  @version 1.1 08 Dec 2022
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Task 0:");
        extractedTask0();

        System.out.println("\n------------\nTask 1:");
        extractedTask1();
    }

    private static void extractedTask0() {
        ThreadSafeList<String> list = new ThreadSafeList<>();

        addValueToListSynchronized(list);
        printListElements(list);
        System.out.println("list.length() = " + list.length());

        removeValueFromListSynchronized(list);
        printListElements(list);
        System.out.println("list.length() = " + list.length());
    }

    private static void addValueToListSynchronized(ThreadSafeList<String> list) {
        int iterationsQnty = 10000;

        // adding values in collection by 3 threads
        Thread thread1 = getThreadForAdd(list, iterationsQnty, "1");
        Thread thread2 = getThreadForAdd(list, iterationsQnty, "2");
        Thread thread3 = getThreadForAdd(list, iterationsQnty, "3");
        thread1.start();
        thread2.start();
        thread3.start();

        // wait to complete all calculations in threads
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void removeValueFromListSynchronized(ThreadSafeList<String> list) {
        // adding values in collection by 3 threads
        Thread thread1 = getThreadToRemove(list, "1");
        Thread thread2 = getThreadToRemove(list, "2");
        Thread thread3 = getThreadToRemove(list, "3");
        thread1.start();
        thread2.start();
        thread3.start();

        // wait to complete all calculations in threads
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printListElements(ThreadSafeList<String> list) {
        // check result. Iterate over each element of the collection,
        int counter = 0;
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");

            // increase the counter if the value is not null
            if (list.get(i) != null) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    /**
     * Initialize runnable to create thread.
     * Add a value to the collection a certain number of times
     *
     * @param list general collection
     * @param qnty quantity of operations
     * @param value adding value
     * @return new Thread based on Runnable
     */
    private static Thread getThreadForAdd(ThreadSafeList<String> list, int qnty, String value) {
        Runnable runnable = () -> {
            // for (int i = 0; i < qnty; i++) {
            for (int i = 0; i < 10000; i++) {
                list.add(value);
            }
        };
        return new Thread(runnable);
    }

    private static Thread getThreadToRemove(ThreadSafeList<String> list, String value) {
        Runnable runnable = () -> {
            for (int i = 0; i < 9500; i++) {
                list.remove(value);
            }
        };
        return new Thread(runnable);
    }

    private static void extractedTask1() {
        PetrolStation petrolStation = new PetrolStation(100000);

        // make 30 refueling requests
        for (int i = 8; i > 0; i--) {
            petrolStation.doRefuel(ThreadLocalRandom.current().nextInt(50, 250));
        }

        petrolStation.close();
    }
}