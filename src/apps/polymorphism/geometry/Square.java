package apps.polymorphism.geometry;

/**
 * Class for a figure, with size for sides of square, area calculation method
 *
 *  @author Oleg Rudoi
 *  @version 1.0  27 Aug 2022
 */
public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = isSizeValid(side) ? side : 0;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = isSizeValid(side) ? side : 0;
    }

    /* if the figure is invalid, then it prints a warning and returns 0 */
    @Override
    public double calcArea() {
        if (!isShapeReal()) {
            System.out.println("Cannot be calculated. Set a valid value for the side.");
            return 0;
        }

        return side * side;
    }

    @Override
    public boolean isSizeValid(double size) {
        return size > 0;
    }

    @Override
    public boolean isShapeReal() {
        return isSizeValid(side);
    }
}