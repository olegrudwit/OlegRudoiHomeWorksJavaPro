package apps.streams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

/**
 * @author Oleg Rudoi
 * @version 1.0 12 Oct 2022
 */
class Product {
    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /* collection of products for task 1 */
    public static List<Product> products1 = new ArrayList<>();

    /* collection of products for task 2, 3 */
    public static List<Product> products2 = new ArrayList<>();

    /* collection of products for task 4, 5 */
    public static List<Product> products3 = new ArrayList<>();

    /* collection of products for task 6 */
    public static List<Product> products4 = new ArrayList<>();

    /* product properties */
    private int id;
    private String name;
    private String type;
    private double price;
    private boolean isDiscounted;
    private LocalDateTime date;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, String type, double price) {
        this(name);
        this.type = type;
        this.price = price;
        products1.add(this);
    }

    public Product(String name, String type, double price, boolean isDiscounted) {
        this(name);
        this.type = type;
        this.price = price;
        this.isDiscounted = isDiscounted;
        products2.add(this);
    }

    public Product(String name, String type, double price,
                   boolean isDiscounted, boolean isDate) {
        this(name);
        this.type = type;
        this.price = price;
        this.isDiscounted = isDiscounted;
        if (isDate) {
            this.date = LocalDateTime.now();
        }
        products3.add(this);
    }

    public Product(boolean isID, String name, String type,
                   double price, boolean isDiscounted, boolean isDate) {
        this(name);
        // ID number generation
        if (isID) {
            RandomGenerator rgen = RandomGenerator.getDefault();
            this.id = rgen.nextInt(1, 999999);
        }
        this.type = type;
        this.price = price;
        this.isDiscounted = isDiscounted;
        // current time generation
        if (isDate) {
            this.date = LocalDateTime.now();
        }
        products4.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setIsDiscounted(boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    /**
     * get the time when the product was added
     * @return machine formatted time
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * overloaded method
     * get the time formatted time when
     * the product was added for easy reading
     *
     * @param isFormatted "true" if you need formatted time
     * @return human formatted time
     */
    public String getDate(boolean isFormatted) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_PATTERN);
        if (date == null) {
            return "not set";
        }
        return date.format(formatter);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}