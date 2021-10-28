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

        System.out.println(mean(new int[]{1, 2, 3}));
        System.out.println(mean(new int[]{1, 2}));

        int[] a = {10, 20, 30, 40};
        shift(a);
        System.out.println(Arrays.toString(a));
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
                for (int j = a[i + 1]; j < a.length; j++){
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
        return;
    }
}
