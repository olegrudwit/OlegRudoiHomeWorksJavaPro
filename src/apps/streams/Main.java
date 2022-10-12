package apps.streams;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Oleg Rudoi
 * @version 1.0 12 Oct 2022
 */
public class Main {
    public static void main(String[] args) {
        initValues();

        System.out.println("Task 1:");
        methodTask1();
        System.out.println("\nTask 2:");
        methodTask2();
        System.out.println("\nTask 3:");
        methodTask3();
        System.out.println("\nTask 4:");
        methodTask4();
        System.out.println("\nTask 5:");
        methodTask5();
        System.out.println("\nTask 6**:");
        methodTask6();
    }

    /**
     * init values for performing test tasks
     */
    @SuppressWarnings("unused")
    private static void initValues() {
        // for task 1
        Product a1 = new Product("a1","Book", 200);
        Product a2 = new Product("a2","Book", 250);
        Product a3 = new Product("a3","Book", 300);
        Product a4 = new Product("a4","Toy", 300);
        Product a5 = new Product("a5","Book", 50);
        a5.setPrice(450);
        Product a6 = new Product("a6","Toy", 200);
        Product a7 = new Product("a7","Book", 500);

        // for task 2, 3
        Product b1 = new Product("b1","Book", 200, true);
        Product b2 = new Product("b2","Book", 250, true);
        b2.setIsDiscounted(false);
        Product b3 = new Product("b3","Book", 300, true);
        Product b4 = new Product("b4","Toy", 300, true);
        b4.setType("Book");
        Product b5 = new Product("b5","Book", 50, true);
        Product b6 = new Product("b6","Toy", 200, false);
        Product b7 = new Product("b7","Book", 500, false);

        // for task 4, 5
        try {
            Product c1 = new Product("c1", "Book", 75, true, true);
            Thread.sleep(2000);
            Product c3 = new Product("c3", "Book", 300, true, false);
            Thread.sleep(2000);
            Product c7 = new Product("c7", "Book", 500, false, true);
            Thread.sleep(2000);
            Product c5 = new Product("c5", "Book", 50, true, true);
            Thread.sleep(2000);
            Product c4 = new Product("c4", "Toy", 300, true, true);
            Thread.sleep(2000);
            Product c6 = new Product("c6", "Toy", 200, false, false);
            Thread.sleep(2000);
            Product c2 = new Product("c2", "Book", 250, true, true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // for task 6
        Product d1 = new Product(true, "d1","Book", 200, true, true);
        Product d2 = new Product(false, "d2","Book", 250, true, true);
        Product d3 = new Product(true, "d3","Book", 300, true, true);
        Product d4 = new Product(true, "d4","Toy", 300, true, true);
        Product d5 = new Product(true, "d5","Book", 50, true, true);
        Product d6 = new Product(false, "d6","Toy", 200, false, true);
        Product d7 = new Product(true, "d7","Book", 500, false, true);
    }

    /**
     * 1.2 Implement the method of obtaining all products in the form of a list,
     * the category of which is equivalent to "Book" and the price is more than 250.
     */
    private static void methodTask1() {
        List<Product> listSelected = getListTypePriceMore(
                Product.products1,"Book", 250);

        listSelected.stream()
                .peek(p -> System.out.print("name " + p.getName()))
                .peek(p -> System.out.print(", type " + p.getType()))
                .forEach(p -> System.out.println(", price " + p.getPrice()));
    }

    /**
     * The method by the stream filters products according
     * to the given type and the price is more expensive
     *
     * @param listProducts the given list of products from which to search
     * @param type required type
     * @param priceMoreThan required price
     * @return a list of products that satisfy the parameters
     */
    @SuppressWarnings("SameParameterValue")
    private static List<Product> getListTypePriceMore(
            List<Product> listProducts,
            String type, double priceMoreThan) {
        Stream<Product> stream = listProducts.stream();
        List<Product> list = stream
                .filter(p -> p.getType().equals(type))
                .filter(p -> p.getPrice() >= priceMoreThan)
                .toList();
        return list;
    }

    /**
     * 2.2 Implement the method of obtaining all products in the form of a list, the category
     * of which is equivalent to "Book" and with the possibility of applying a discount.
     * The final list must contain products with an already applied 10% discount.
     */
    private static void methodTask2() {
        List<Product> listSelected = getListTypeDiscounted(
                Product.products2,"Book", true, 10);

        listSelected.stream()
                .peek(p -> System.out.print("name " + p.getName()))
                .peek(p -> System.out.print(", type " + p.getType()))
                .forEach(p -> System.out.println(", price " + p.getPrice()));
    }

    /**
     * The method by the stream filters products according
     * to the given type and which ones are discounted
     *
     * @param listProducts the given list of products from which to search
     * @param type required type
     * @param isDiscounted a discount is applied to the product
     * @param discount amount of discount
     * @return a list of products that satisfy the parameters
     */
    @SuppressWarnings("SameParameterValue")
    private static List<Product> getListTypeDiscounted(
            List<Product> listProducts,
            String type, boolean isDiscounted, double discount) {
        Stream<Product> stream = listProducts.stream();
        List<Product> list = stream
                .filter(p -> p.getType().equals(type))
                .filter(p -> p.isDiscounted() == isDiscounted)
                .peek(p -> p.setPrice(p.getPrice() * (100 - discount) / 100))
                .toList();
        return list;
    }

    /**
     * 3.2 Implement the method of obtaining the cheapest product from the “Book” category
     */
    private static void methodTask3() {
        Product cheapestProduct = getProductMinPrice(Product.products2, "Book");

        System.out.println(
                "name " + cheapestProduct.getName() +
                ", type " + cheapestProduct.getType() +
                ", price " + cheapestProduct.getPrice());
    }

    /**
     * The method by the stream filters product with
     * the lowest price of to the necessary type
     *
     * @param listProducts the given list of products from which to search
     * @param type required type
     * @return product with the lowest price
     */
    @SuppressWarnings("SameParameterValue")
    private static Product getProductMinPrice(
            List<Product> listProducts, String type) {
        try {
            return listProducts.stream()
                    .filter(p -> p.getType().equals(type))
                    .min(Comparator.comparing(Product::getPrice))
                    .get();
        } catch (Exception e) {
            throw new RuntimeException("Product [Category: " + type + "] not found");
        }
    }

    /**
     * 4.2 Implement the method of obtaining the three last added products
     */
    private static void methodTask4() {
        List<Product> listSelected = getListLastAdded(
                Product.products3,3);

        listSelected.stream()
                .peek(p -> System.out.print("name " + p.getName()))
                .peek(p -> System.out.print(", type " + p.getType()))
                .forEach(p -> System.out.println(", date " + p.getDate(true)));
    }

    /**
     * The method by the stream filters the required quantity with last
     * products added according to the given type.
     * Куегкт only the required number of items in the sorted list, skip the others.
     *
     * @param listProducts the given list of products from which to search
     * @param qnty required quantity of products
     * @return a list with the required number of the last added products of a certain type
     */
    @SuppressWarnings("SameParameterValue")
    private static List<Product> getListLastAdded(List<Product> listProducts, int qnty) {
        List<Product> listNotNull = listProducts.stream()
                .filter(p -> p.getDate() != null)
                .toList();

        // If the size of the list is smaller than the required number of elements,
        // then it is not necessary to skip the elements
        int skipQnty = listNotNull.size() <= qnty ? 0 : listNotNull.size() - qnty;

        return listNotNull.stream()
                .sorted(Comparator.comparing(Product::getDate))
                .skip(skipQnty)
                .toList();
    }

    /**
     * 5.2 Implement the method of calculating the total cost of products,
     * which meet the following criteria:
     * - the product was added during the current year
     * - the product has the type "Book"
     * - the price of the product does not exceed 75
     *
     */
    private static void methodTask5() {
        double totalPrice = getSumPriceAddedThisYearTypePriceLess(
                Product.products3, LocalDateTime.now().getYear(),"Book", 75);

        System.out.println(totalPrice);
    }

    /**
     * The method by the stream filters sum the price of products
     * with the required year, type and price
     *
     * @param listProducts the given list of products from which to search
     * @param year required year
     * @param type required type
     * @param priceLessThan required price
     * @return the total price of products with the required year, type and price
     */
    @SuppressWarnings("SameParameterValue")
    //private static List<Product> getSumPriceAddedThisYearTypePriceLess(
    private static double getSumPriceAddedThisYearTypePriceLess(
            List<Product> listProducts, int year, String type, double priceLessThan) {
        List<Product> listNotNull = listProducts.stream()
                .filter(p -> p.getDate() != null)
                .toList();

        return listNotNull.stream()
                .filter(p -> p.getDate().getYear() == year)
                .filter(p -> p.getType().equals(type))
                .filter(p -> p.getPrice() <= priceLessThan)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    /**
     * ** 6.2 Implement the method of grouping objects by product type.
     * Thus, the result of the execution of the method will be the data type "Dictionary"
     * storing key-value pair: {type: product_list}
     */
    private static void methodTask6() {
        Map<String, List<Product>> listSelected = getListGroupedType(Product.products4);

        System.out.println(listSelected);
    }

    /**
     * The method in the stream groups objects in a map by type of products
     * @param listProducts the given list of products from which to search
     * @return map with groups of products by type
     */
    private static Map<String, List<Product>> getListGroupedType(List<Product> listProducts) {
        return listProducts.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}