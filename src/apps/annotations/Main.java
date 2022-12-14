package apps.annotations;

public class Main {
    public static void main(String[] args) {
        BookReader reader = new BookReader();
        TestRunner.start(reader.getClass());
    }
}
