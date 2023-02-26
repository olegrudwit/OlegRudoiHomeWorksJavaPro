package apps.polymorphism.geometry;

/**
 * A class for a geometric figure that declares a base variable
 * for the size of the figure, implements the Area interface,
 * contains a validator for the size
 * and validity of all sides of the figure
 *
 *  @author Oleg Rudoi
 *  @version 1.1  25 Feb 2023
 */
public interface Shape {
    double calcArea();
    boolean isSizeValid(double size);
    boolean isShapeReal();
}