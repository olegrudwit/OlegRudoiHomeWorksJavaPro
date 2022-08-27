package apps.polymorphism.geometry;

/*
 * @author Oleg Rudoi
 * @version 1.0  27 Aug 2022
 */

/**
 * Class for a figure, with size of 3 sides, area calculation method
 * and validity all sides of the figure have real size
 */
public class Triangle extends Shape implements Area {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = validateSize(sideA);
        this.sideB = validateSize(sideB);
        this.sideC = validateSize(sideC);
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = validateSize(sideA);
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = validateSize(sideB);
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = validateSize(sideC);
    }

    // if the figure is invalid, then it prints a warning and returns 0
    @Override
    public double calcArea() {
        if (!isShapeValid()) {
            System.out.println("Cannot be calculated. Set a valid value for the side.");
            return 0;
        }

        double halfp = (sideA + sideB + sideC) / 2;
        return Math.sqrt(
                halfp * (halfp - sideA) * (halfp - sideB) * (halfp - sideC) );
    }

    // return false if at least one side is invalid
    @Override
    protected boolean isShapeValid() {
        return !(sideA <= 0) && !(sideB <= 0) && !(sideC <= 0);
    }
}