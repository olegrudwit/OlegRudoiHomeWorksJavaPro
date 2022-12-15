package apps.annotations;

/**
 *  @author Oleg Rudoi
 *  @version 1.0 15 Dec 2022
 */
public class AnnotationNotUniqueException extends Exception {
    public AnnotationNotUniqueException(String message) {
        super(message);
    }
}
