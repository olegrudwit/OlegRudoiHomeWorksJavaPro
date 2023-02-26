package apps.polymorphism.geometry;

/**
 * Class for a figure, with size of 3 sides, area calculation method
 * and validity all sides of the figure have real size
 *
 *  @author Oleg Rudoi
 *  @version 1.0  27 Aug 2022
 */
public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = isSizeValid(sideA) ? sideA : 0;
        this.sideB = isSizeValid(sideB) ? sideB : 0;
        this.sideC = isSizeValid(sideC) ? sideC : 0;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = isSizeValid(sideA) ? sideA : 0;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = isSizeValid(sideB) ? sideB : 0;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = isSizeValid(sideC) ? sideC : 0;
    }

    /*if the figure is invalid, then it prints a warning and returns 0 */
    @Override
    public double calcArea() {
        if (!isShapeReal()) {
            System.out.println("Cannot be calculated. Set a valid value for the side.");
            return 0;
        }

        double halfp = (sideA + sideB + sideC) / 2;
        return Math.sqrt(
                halfp * (halfp - sideA) * (halfp - sideB) * (halfp - sideC) );
    }

    @Override
    public boolean isSizeValid(double size) {
        return size > 0;
    }

    /* return false if at least one side is invalid */
    @Override
    public boolean isShapeReal() {
        return isSizeValid(sideA) && isSizeValid(sideB) && isSizeValid(sideC);
    }
}