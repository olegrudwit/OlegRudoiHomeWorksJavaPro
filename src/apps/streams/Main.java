package apps.streams;

public class Main {
    public static void main(String[] args) {
        Product a1 = new Product("Book", 200);
        Product a2 = new Product("Book", 250);
        Product a3 = new Product("Book", 300);
        Product a4 = new Product("Toy", 300);
        Product a5 = new Product("Book", 50);
        Product a6 = new Product("Toy", 200);
        Product a7 = new Product("Book", 500);

        Product b1 = new Product("Book", 200, true);
        Product b2 = new Product("Book", 250, true);
        Product b3 = new Product("Book", 300, true);
        Product b4 = new Product("Toy", 300, true);
        Product b5 = new Product("Book", 50, true);
        Product b6 = new Product("Toy", 200, false);
        Product b7 = new Product("Book", 500, false);
    }
}
