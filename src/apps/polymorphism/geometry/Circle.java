package apps.polymorphism.geometry;

/**
 * Class for a figure, with size for diameter, area calculation method
 *
 *  @author Oleg Rudoi
 *  @version 1.1  26 Feb 2023
 */
public class Circle implements Shape {
    private double diameter;

    public Circle(double diameter) {
        this.diameter = isSizeValid(diameter) ? diameter : 0;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = isSizeValid(diameter) ? diameter : 0;
    }

    /* if the figure is invalid, then it prints a warning and returns 0 */
    @Override
    public double calcArea() {
        if (!isShapeReal()) {
            System.out.println("Cannot be calculated. Set a valid value for the diameter.");
            return 0;
        }

        return Math.PI * (diameter * diameter) / 4;
    }

    @Override
    public boolean isSizeValid(double size) {
        return size > 0;
    }

    @Override
    public boolean isShapeReal() {
        return isSizeValid(diameter);
    }
}