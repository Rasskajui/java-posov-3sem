package intro;

public class IntroTaskQuadraticEquation {
    public static void main(String[] args) {
        System.out.println(quadraticEquation(1, 2, 1));
        System.out.println(quadraticEquation(1, -14, 45));
        System.out.println(quadraticEquation(1, 1, 1));
        System.out.println(quadraticEquation(0,0, 0));
        System.out.println(quadraticEquation(0,2, 1));
        System.out.println(quadraticEquation(4,4, 1));
    }

    public static String quadraticEquation(int a, int b, int c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return "бесконечно много решений";
                } else {
                    return "решений нет";
                }
            } else {
                double x = - (double) c / b;
                return "Единственное решение x = " + String.format("%.2f", x);
            }
        } else {
            int D = b * b - 4 * a * c;
            if (D < 0) {
                return "решений нет";
            } else if (D == 0) {
                double x = - (double) b / (2 * a);
                return "Единственное решение x = " + String.format("%.2f", x);
            } else {
                double x1 = - (b + Math.sqrt(D)) / (2 * a);
                double x2 = - (b - Math.sqrt(D)) / (2 * a);
                return "Два решения x1 = " + String.format("%.2f", Math.min(x1, x2)) + " и x2 = " + String.format("%.2f", Math.max(x1, x2));
            }
        }
    }
}
