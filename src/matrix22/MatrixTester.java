package matrix22;

import java.util.Arrays;

public class MatrixTester {
    public static void main(String[] args) {
        Matrix22 m1 = new Matrix22(1, 2, 3, 4);
        m1.printMatrix();

        Matrix22 m2 = new Matrix22(new int[][]{{1, 2}, {3, 4}});
        m2.printMatrix();

        System.out.println(m1.trace());
        System.out.println(m2.discriminant());

        System.out.println(m2.getMatrix());

        System.out.println(m1.toString());

        Matrix22 m3 = new Matrix22(1000, 5, 40, 20000);
        m3.printMatrixAligned();

    }


}
