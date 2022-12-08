package apps.MultithreadingCollection;

/**
 * The class implements a thread-safe collection
 * Has methods add, get and remove.
 *
 * @author Oleg Rudoi
 * @version 1.2 08 Dec 2022
 */
public class ThreadSafeList<E> {
    private static final int DEFAULT_SIZE = 16;
    private static final double STEP_INCREASE = 1.5;
    private Object[] arr;
    private int indexCounter;

    /**
     * calls the initialization method of the new array
     */
    public ThreadSafeList() {
        initInternalArray();
    }

    /**
     * initializes the array from the constructor with constant values
     */
    private void initInternalArray() {
        arr = new Object[DEFAULT_SIZE];
        indexCounter = 0;
    }

    /**
     * adds a new element after the initialized values
     *
     * @param value element value
     * @return true after a successful operation
     */
    public boolean add(E value) {
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
            Object[] arrNew = new Object[arr.length - 1];
            System.arraycopy(arr, 0, arrNew, 0, index);
            System.arraycopy(arr, (index + 1), arrNew, index, (arr.length - index - 1));
            arr = arrNew;
        }
        return true;
    }

    /**
     * removes an element from the array by value.
     * If value found, calls method remove an element by index.
     *
     * @param value required element
     * @return true after a successful operation
     */
    public synchronized boolean remove(E value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return remove(i);
            }
        }
        return false;
    }

    /**
     * returns the element from the array by index.
     *
     * @param index required index of element
     * @return value of required element
     */
    public synchronized E get(int index) {
        return (E) arr[index];
    }

    /**
     * Expanded the length of the array by the value in a constant.
     * Creates a new array, the length of the current plus the coefficient.
     * Copies elements from old to new. The reference to this array is
     * then assigned to the general array.
     */
    private void expandArray() {
        int newLength = (int) (arr.length * STEP_INCREASE);
        Object[] arrNew = new Object[newLength];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        arr = arrNew;
    }

    public synchronized int length() {
        return arr.length;
    }
}