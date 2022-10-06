package apps.streams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Oleg Rudoi
 * @version 1.0 06 Oct 2022
 */

class Product {
    public String type;
    public double price;
    public boolean isDiscounted;
    public double discount;
    public LocalDateTime date;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean isDiscounted) {
        this(type, price);
        this.isDiscounted = isDiscounted;
    }

    public Product(String type, double price, boolean isDiscounted, boolean isDate) {
        this(type, price, isDiscounted);
        if (isDate) {
            this.date = LocalDateTime.now();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        if (isDiscounted) {
            return price * (discount / 100);
        }
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDate(boolean isFormatted) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }
}