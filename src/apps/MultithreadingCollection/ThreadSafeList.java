package apps.MultithreadingCollection;

/**
 * The class implements a thread-safe collection
 *
 * @author Oleg Rudoi
 * @version 1.0 30 Oct 2022
 */
public class ThreadSafeList {
    private static final int INITIAL_SIZE = 16;
    private static final int STEP_INCREASE = INITIAL_SIZE / 2;
    private String[] arr;
    private int indexCounter;

    /**
     * calls the initialization method of the new array
     */
    public ThreadSafeList() {
        initArray();
    }

    /**
     * initializes the array from the constructor with constant values
     */
    private void initArray() {
        arr = new String[INITIAL_SIZE];
        indexCounter = 0;
    }

    /**
     * adds a new element after the initialized values
     *
     * @param value element value
     * @return true after a successful operation
     */
    public boolean add(String value) {
        synchronized (this) {
            /* to call the array length expand method, If the array is completely filled */
            if (indexCounter == arr.length) {
                expandArray();
            }
            arr[indexCounter] = value;
            indexCounter++;
        }
        return true;
    }

    /**
     * removes an element from the array by index.
     * Creates a new array, copies elements from the old to the new
     * from 0 to the required index, then skipping the second part
     * to the required index. This array's reference is then assigned to the general array.
     *
     * @param index required element index
     * @return true after a successful operation
     */
    public boolean remove(int index) {
        synchronized (this) {
            String[] arrNew = new String[arr.length - 1];
            System.arraycopy(arr, 0, arrNew, 0, index);
            System.arraycopy(arr, (index + 1), arrNew, index, (arr.length - index - 1));
            arr = arrNew;
        }
        return true;
    }

    /**
     * returns the element from the array by index.
     *
     * @param index required index of element
     * @return value of required element
     */
    public String get(int index) {
        String value;
        synchronized (this) {
            value = arr[index];
        }
        return value;
    }

    /**
     * Expanded the length of the array by the value in a constant.
     * Creates a new array, the length of the current plus the coefficient.
     * Copies elements from old to new. The reference to this array is
     * then assigned to the general array.
     */
    private void expandArray() {
        String[] arrNew = new String[arr.length + STEP_INCREASE];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        arr = arrNew;
    }
}