package arrays;

import java.util.Arrays;

public class ArrayTasks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(even(4)));
        System.out.println(Arrays.toString(even(1)));
        System.out.println(Arrays.toString(even(0)));

        System.out.println(allSimilar(new int[]{0, 0, 1}));
        System.out.println(allSimilar(new int[]{0, 0}));
        System.out.println(allSimilar(new int[]{}));

        System.out.println(hasSimilar(new int[]{0, 1, 2, 3, 2}));
        System.out.println(hasSimilar(new int[]{0, 1, 2, 3, 4}));
        System.out.println(hasSimilar(new int[]{0}));
        System.out.println(hasSimilar(new int[]{-10, -20, -30}));
        System.out.println(hasSimilar(new int[]{-10, -20, -30, -20}));

        System.out.println(mean(new int[]{1, 2, 3}));
        System.out.println(mean(new int[]{1, 2}));

        int[] a = {10, 20, 30, 40};
        shift(a);
        System.out.println(Arrays.toString(a));

        int[] x = {10, 20, 30, 40};
        System.out.println(Arrays.toString(copyShift(x)));
        System.out.println(Arrays.toString(x));

        printTable(new int[][]{{10, 20, 30}, {1, 2}, {0, 1, 2, 30, 400}});
        System.out.println();
        printTableAligned(new int[][]{{10, 2000, 30}, {1, 2}, {0, 1, 2, 30, 400}});

        char[][] c = createTable(20, '.');
        printTable2(c);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable2(c);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable2(c);
    }

    public static int[] even(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = 2*(i + 1);
        }
        return a;
    }

    public static boolean allSimilar(int[] a) {
        if (a.length > 1) {
            int x = a[0];
            for (int i : a) {
                if (i != x) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasSimilar(int[] a){
        if( a.length > 1) {
            for (int i = 0; i < a.length - 1; i++){
                for (int j = i + 1; j < a.length; j++){
                    if (a[j] == a[i]) return true;
                }
            }
        }
        return false;
    }

    public static double mean(int[] a) {
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        return (double) sum / a.length;
    }

    public static void shift(int[] a) {
        if (a.length > 0) {
            int x = a[0];
            a[0] = a[a.length - 1];
            for (int i = 1; i < a.length; i++){
                int temp = a[i];
                a[i] = x;
                x = temp;
            }
        }
    }

    public static int[] copyShift(int[] a) {
        int[] b = new int[a.length];
        b[0] = a[a.length - 1];
        for (int i = 1; i < b.length; i++){
            b[i] = a[i - 1];
        }
        return b;
    }

    public static void printTable(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printTableAligned(int[][] a){
        int max = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i].length > max){
               max = a[i].length;
            }
        }

        int[] l = new int[max];
        int[][] all_l = new int[a.length][max];

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++) {
                all_l[i][j] = Integer.toString(a[i][j]).length();
                if (all_l[i][j] > l[j]) {
                    l[j] = all_l[i][j];
                }
            }

        }

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                String box = " ".repeat(l[j] - Integer.toString(a[i][j]).length()) + Integer.toString(a[i][j]);
                System.out.print(box + "  ");
            }
            System.out.println();
        }
    }

    public static char[][] createTable(int n, char c){
        char[][] a = new char[n][n];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                a[i][j] = c;
            }
        }
        return a;
    }

    public static void printTable2(char[][] a){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillFirstAndLastLines(char[][] a, char x){
        for (int j = 0; j < a[0].length; j++){
            a[0][j] = x;
        }
        for (int j = 0; j < a[a.length - 1].length; j++){
            a[a.length - 1][j] = x;
        }
    }

    public static void fillFirstAndLastColumns(char[][] a, char x){
        for (int i = 0; i < a.length; i++){
            a[i][0] = x;
            a[i][a[i].length - 1] = x;
        }
    }



}


