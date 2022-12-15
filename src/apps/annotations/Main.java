package apps.annotations;

/**
 *  @author Oleg Rudoi
 *  @version 1.0 15 Dec 2022
 */
public class Main {
    public static void main(String[] args) {
        BookReader reader = new BookReader();
        TestRunner.start(reader);
    }
}
