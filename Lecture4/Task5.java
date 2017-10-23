package Lecture4;

public class Task5 {
    public static void main(String[] args) {


        Circle circle = new Circle(100, 100, 150, 150);
        System.out.println("Square of circle: " + circle.getSquare());
        System.out.println("Perimeter of circle: " + circle.getPerimeter());
        Rectangle rect= new Rectangle(100, 100, 150, 150);
        System.out.println("Square of rect: " + rect.getSquare());
        System.out.println("Perimeter of rect: " + rect.getPerimeter());
        Triangle triangle=new Triangle(100,100,200,100,150,50);
        System.out.println("Square of triangle: " + triangle.getSquare());
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
    }
}
