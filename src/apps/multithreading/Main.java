package apps.multithreading;

/**
 * @author Oleg Rudoi
 * @version 1.0 18 Oct 2022
 */
public class Main {

    public static void main(String[] args) {
        // init and call calculations
        ValueCalculator valueCalculator = new ValueCalculator(1500000);
        try {
            valueCalculator.doCalc();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // checking the values in the array
        int length = valueCalculator.getLength();
        int lengthHalf = length / 2;
        double[] array = valueCalculator.getArray();
        System.out.println(array[0] + " " + array[lengthHalf - 1] + "\n" +
                array[lengthHalf] + " " + array[length - 1]);
    }
}