package apps.polymorphism.geometry;

/*
 * @author Oleg Rudoi
 * @version 1.0  27 Aug 2022
 */
public class Main {
    public static Shape[] figures;
    public static double sumArea;

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println("The Circle with diameter "
                + circle.getDiameter()
                + " has area "
                + String.format("%.3f\n", circle.calcArea()) );

        Circle circle1 = new Circle(-5);
        System.out.println("The Circle with diameter "
                + circle1.getDiameter()
                + " has area "
                + String.format("%.3f\n", circle1.calcArea()) );

        Square square = new Square(5);
        System.out.println("The Square with side "
                + square.getSide()
                + " has area "
                + String.format("%.3f\n", square.calcArea()) );

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("The Triangle with sides "
                + triangle.getSideA() + ", "
                + triangle.getSideB() + ", "
                + triangle.getSideC()
                + " has area "
                + String.format("%.3f\n", triangle.calcArea()) );

        Triangle triangle1 = new Triangle(0, 4, -5);
        System.out.println("The Triangle with sides "
                + triangle1.getSideA() + ", "
                + triangle1.getSideB() + ", "
                + triangle1.getSideC()
                + " has area "
                + String.format("%.3f\n", triangle1.calcArea()) );

        figures = new Shape[] {circle, circle1, square, triangle, triangle1};

        sumArea = calcShapesSumArea(figures);

        System.out.println("The sum of the areas of all figures is "
                + String.format("%.3f\n", sumArea) );
    }

    /**
     * The method accepts an array of Shape figures.
     * Calculates the area of each figure.
     * Returns the sum of the areas of these figures.
     */
    private static double calcShapesSumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape: shapes) {
            sum += shape.calcArea();
        }

        return sum;
    }
}