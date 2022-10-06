package apps.streams.a;
/**
 * @author Oleg Rudoi
 * @version 1.0 06 Oct 2022
 */

class Product {
    public String type;
    public double price;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
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
}

