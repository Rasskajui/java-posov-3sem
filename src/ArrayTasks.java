import java.util.Arrays;

public class ArrayTasks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(even(4)));
        System.out.println(Arrays.toString(even(1)));
        System.out.println(Arrays.toString(even(0)));

        System.out.println(allSimilar(new int[]{0, 0, 1}));
        System.out.println(allSimilar(new int[]{0, 0}));
        System.out.println(allSimilar(new int[]{}));
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



}
