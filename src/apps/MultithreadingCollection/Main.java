package apps.MultithreadingCollection;

/**
 *  @author Oleg Rudoi
 *  @version 1.0 02 Nov 2022
 */
public class Main {
    public static void main(String[] args) {
        ThreadSafeList<String> list = new ThreadSafeList<>();

        int iterationsQnty = 10000;

        // adding values in collection by 3 threads
        Thread thread1 = getThreadForCalc(list, iterationsQnty, "1");
        Thread thread2 = getThreadForCalc(list, iterationsQnty, "2");
        Thread thread3 = getThreadForCalc(list, iterationsQnty, "3");
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

        // check result. Iterate over each element of the collection,
        int counter = 0;
        for (int i = 0; i < ((iterationsQnty * 3) + 1); i++) {
            System.out.print(list.get(i) + " ");

            // increase the counter if the value is not null
            if (list.get(i) != null) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    /**
     * Initialize runbl to create thread.
     * Add a value to the collection a certain number of times
     *
     * @param list general collection
     * @param qnty quantity of operations
     * @param value adding value
     * @return new Thread based on Runnable
     */
    private static Thread getThreadForCalc(ThreadSafeList<String> list, int qnty, String value) {
        Runnable runnable = () -> {
            for (int i = 0; i < qnty; i++) {
                list.add(value);
            }
        };
        return new Thread(runnable);
    }
}