package apps.polymorphism.geometry;

/*
 * @author Oleg Rudoi
 * @version 1.0  27 Aug 2022
 */

/**
 * Class for a figure, with size for diameter, area calculation method
 */
public class Circle extends Shape {
    private double diameter;

    public Circle(double diameter) {
        this.diameter = validateSize(diameter);
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = validateSize(diameter);
    }

    // if the figure is invalid, then it prints a warning and returns 0
    @Override
    public double calcArea() {
        if (!isShapeValid()) {
            System.out.println("Cannot be calculated. Set a valid value for the diameter.");
            return 0;
        }

        return Math.PI * (diameter * diameter) / 4;
    }
}