package apps.annotations;

public class BookReader {
    @BeforeSuite
    public void startReading() {
        System.out.println("Open the book to start reading");
    }

    @AfterSuite
    public void finishReading() {
        System.out.println("Stop reading and close the book");
    }

    @Test(priority = 10)
    public void reading1Chapter() {
        System.out.println("Read the chapter number 1");
    }

    @Test(priority = 7)
    public void reading9Chapter() {
        System.out.println("Read the chapter number 1");
    }

    @Test(priority = 9)
    public void reading2Chapter() {
        System.out.println("Read the chapter number 1");
    }

    @Test(priority = 8)
    public void reading3Chapter() {
        System.out.println("Read the chapter number 1");
    }
}
