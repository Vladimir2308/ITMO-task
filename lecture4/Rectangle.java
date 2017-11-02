package lecture4;

import static java.lang.Math.*;

public class Rectangle {
    int length;
    int width;

    Rectangle(int x1, int y1, int x2, int y2) {
        length = abs(x2 - x1);
        width = abs(y2 - y1);
    }

    public int getSquare() {

        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }
}