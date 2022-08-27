package apps.polymorphism.geometry;

/*
 * @author Oleg Rudoi
 * @version 1.0  27 Aug 2022
 */

/**
 * Class for a figure, with size for sides of square, area calculation method
 */
public class Square extends Shape implements Area {
    private double side;

    public Square(double side) {
        this.side = validateSize(side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = validateSize(side);
    }

    // if the figure is invalid, then it prints a warning and returns 0
    @Override
    public double calcArea() {
        if (!isShapeValid()) {
            System.out.println("Cannot be calculated. Set a valid value for the side.");
            return 0;
        }

        return side * side;
    }
}