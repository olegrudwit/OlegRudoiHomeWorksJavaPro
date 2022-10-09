package apps.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Product a1 = new Product("a1","Book", 200);
        Product a2 = new Product("a2","Book", 250);
        Product a3 = new Product("a3","Book", 300);
        Product a4 = new Product("a4","Toy", 300);
        Product a5 = new Product("a5","Book", 50);
        a5.setPrice(450);
        Product a6 = new Product("a6","Toy", 200);
        Product a7 = new Product("a7","Book", 500);

//        1.2 Реализовать метод получения всех продуктов в виде списка,
//        категория которых эквивалентна “Book” и цена более чем 250.
        Stream<Product> stream = Product.products.stream();
        List<Product> book250 = stream
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() > 250)
                .toList();
        book250.stream()
                .peek(p -> System.out.print(p.getName()))
                .peek(p -> System.out.print(", " + p.getType()))
                .forEach(p -> System.out.println(", " + p.getPrice()));
        //stream.forEach(System.out::println);
        //System.out.println(Product.products);

        Product b1 = new Product("b1","Book", 200, true);
        Product b2 = new Product("b2","Book", 250, true);
        Product b3 = new Product("b3","Book", 300, true);
        Product b4 = new Product("b4","Toy", 300, true);
        Product b5 = new Product("b5","Book", 50, true);
        Product b6 = new Product("b6","Toy", 200, false);
        Product b7 = new Product("b7","Book", 500, false);
    }
}
