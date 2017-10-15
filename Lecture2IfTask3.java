public class Lecture2IfTask3 {
    public static void main(String[] args) {
        float a, b, c, D, root1, root2;
        a = 4.1f;
        b = 10.56f;
        c = 1.1f;
        D = b * b - 4 * a * c;
        if (D < 0) {
            System.out.println("No roots");
        } else if (D == 0) {
            System.out.println("One root: ");
            root1 = (-b + D) / (2 * a);
            System.out.println(root1);
        } else {
            System.out.println("Two roots: ");
            root1 = (-b + D) / (2 * a);
            root2 = (-b - D) / (2 * a);
            System.out.println(root1);
            System.out.println(root2);
        }

    }
}
