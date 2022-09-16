package apps.logger;

/*
 * @author Oleg Rudoi
 * @version 1.0 16 Sept 2022
 */
public class FileMaxSizeReachedException extends RuntimeException {

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
