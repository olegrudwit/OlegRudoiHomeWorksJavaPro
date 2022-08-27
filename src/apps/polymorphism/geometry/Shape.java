package apps.polymorphism.geometry;

/*
 * @author Oleg Rudoi
 * @version 1.0  27 Aug 2022
 */

/**
 * A class for a geometric figure that declares a base variable
 * for the size of the figure, implements the Area interface,
 * contains a validator for the size
 * and validity of all sides of the figure
 */
public class Shape implements Area {
    protected double size;
    protected boolean isSideValid;

    public Shape() {
    }

    public Shape(double size) {
        this.size = validateSize(size);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    protected double validateSize(double size) {
        if (size <= 0) {
            return 0;
        }

        isSideValid = true;
        return size;
    }

    // return false if side of figure is invalid
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected boolean isShapeValid() {
        return isSideValid;
    }

    @Override
    public double calcArea() {
        return 0;
    }
}