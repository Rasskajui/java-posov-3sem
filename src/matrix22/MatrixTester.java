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
        m3.add(m2).printMatrixAligned();
        m3.mul(m2).printMatrixAligned();
        System.out.println();

        Matrix22 x = new Matrix22(1, 2, 3, 4);
        x.pow(2).printMatrixAligned();
        System.out.println();

        System.out.println(fib(8));



    }

    public static int fib(int n){
        Matrix22 m = new Matrix22(1, 1, 1, 0);
        m = m.pow(n);
        int[][] f = m.getMatrix();
        return f[0][1];
    }


}
