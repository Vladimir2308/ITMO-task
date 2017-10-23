package Lecture4;

import static java.lang.Math.*;

public class Triangle {

    int a;
    int b;
    int c;
    int perimeter;
    int halfPer;

    Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        a = (int) sqrt(pow(abs(x2 - x1), 2) + pow(abs(y2 - y1), 2));
        b = (int) sqrt(pow(abs(x3 - x2), 2) + pow(abs(y3 - y2), 2));
        c = (int) sqrt(pow(abs(x3 - x1), 2) + pow(abs(y3 - y1), 2));
        perimeter = a + b + c;
        halfPer = perimeter / 2;
    }

    public int getSquare() {

        return (int) sqrt(halfPer * (halfPer - a) * (halfPer - b) * (halfPer - c));
    }

    public int getPerimeter() {
        return perimeter;
    }
}