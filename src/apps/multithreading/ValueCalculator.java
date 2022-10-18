package apps.multithreading;

import java.util.Arrays;

/**
 * @author Oleg Rudoi
 * @version 1.0 18 Oct 2022
 */
public class ValueCalculator {
    private double[] array;
    private int length;
    private int lengthHalf;

    public ValueCalculator(int length) {
        this.length = length;
    }

    public double[] getArray() {
        return array;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Fills the array with the same value.
     * Divides the array into 2 halves, performs arithmetic operations according to the formula.
     * Combine arrays into an initial array.
     * Measures the duration of these operations and outputs the value to the console.
     */
    public void doCalc() throws InterruptedException {
        // start of time measurement and init values
        long start = System.currentTimeMillis();
        array = new double[length];
        lengthHalf = array.length / 2;
        // init array with the same value
        Arrays.fill(array, 5);

        double[] a1 = new double[lengthHalf];
        double[] a2 = new double[lengthHalf];

        // split into 2 arrays
        System.arraycopy(array, 0, a1, 0, lengthHalf);
        System.arraycopy(array, lengthHalf - 1, a2, 0, lengthHalf);

        // calculations in first array
        Runnable runnable1 = () -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        // calculations in second array
        Runnable runnable2 = () -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        // wait to complete all calculations in threads
        thread1.join();
        thread2.join();

        // copying values to initial array
        System.arraycopy(a1, 0, array, 0, lengthHalf);
        System.arraycopy(a2, 0, array, lengthHalf, lengthHalf);

        // calc and output time durations
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);
    }
}