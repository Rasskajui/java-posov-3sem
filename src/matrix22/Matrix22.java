package matrix22;

import java.util.Arrays;

public class Matrix22 {
    int[][] matrix = new int[2][2];

    public Matrix22(int a, int b, int c, int d){
        this.matrix[0][0] = a;
        this.matrix[0][1] = b;
        this.matrix[1][0] = c;
        this.matrix[1][1] = d;
    }

    public Matrix22(int[][] m){
        this.matrix = m;
    }

    public void printMatrix(){
        for (int[] x : this.matrix){
            System.out.println(Arrays.toString(x));
        }
    }

    public int trace(){
        return this.matrix[0][0] + this.matrix[1][1];
    }

    public int discriminant(){
        return matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    public String toString(){
        String s = "";
        for (int[] x : this.matrix){
            s += Arrays.toString(x) + "\n";
        }
        return s;
    }

    public void printMatrixAligned(){
        int[] l = new int[2];
        int[][] all_l = new int[2][2];

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++) {
                all_l[i][j] = Integer.toString(matrix[i][j]).length();
                if (all_l[i][j] > l[j]) {
                    l[j] = all_l[i][j];
                }
            }

        }

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                String box = " ".repeat(l[j] - Integer.toString(matrix[i][j]).length()) + Integer.toString(matrix[i][j]);
                System.out.print(box + "  ");
            }
            System.out.println();
        }
    }
    

}
