package Lecture4;
import static java.lang.Math.*;

public class Circle {
    int rad;
    Circle(int x1, int y1,int x2,int y2) {
        rad = (int) sqrt(pow(abs(x2 - x1), 2) + pow(abs(y2 - y1), 2));
    }
    public int getSquare() {
        double temp=rad*rad*PI;
        return (int)temp;
    }
    public int getPerimeter(){
        double temp=2*rad*PI;
        return (int)temp;
    }
}
