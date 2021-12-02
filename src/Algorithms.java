import java.util.ArrayList;
import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(20)));
        System.out.println(Arrays.toString(primes(73)));
        printDivider(divider(1));
        printDivider(divider(5));
        printDivider(divider(56));
        printDivider(divider(600));
        System.out.println();

        int[] a = {1, 4, 5, 10, 20, 100};
        test(a, 5, 2);
        test(a, 1, 0);
        test(a, 100, 5);
        test(a, 42, -1);
        test(a, 120, -1);
        test(a, 0, -1);

        int[] b = {1, 4, 6, 65, 100};
        test(b, 0, -1);
        test(b, 1, 0);
        test(b, 2, -1);
        test(b, 4, 1);
        test(b, 5, -1);
        test(b, 6, 2);
        test(b, 10, -1);
        test(b, 65, 3);
        test(b, 70, -1);
        test(b, 100, 4);
        test(b, 200, -1);

        int[] c = {1, 4, 6, 65, 100, 110};
        test(c, 0, -1);
        test(c, 1, 0);
        test(c, 2, -1);
        test(c, 4, 1);
        test(c, 5, -1);
        test(c, 6, 2);
        test(c, 10, -1);
        test(c, 65, 3);
        test(c, 70, -1);
        test(c, 100, 4);
        test(c, 105, -1);
        test(c, 110, 5);
        test(c, 200, -1);

        test(new int[]{}, 42, -1);
        test(new int[]{42}, 0, -1);
        test(new int[]{42}, 42, 0);
        test(new int[]{42}, 100, -1);

        test(new int[]{10, 20}, 0, -1);
        test(new int[]{10, 20}, 10, 0);
        test(new int[]{10, 20}, 15, -1);
        test(new int[]{10, 20}, 20, 1);
        test(new int[]{10, 20}, 25, -1);
    }

    public static boolean[] sieveOfEratosthenes(int n){
        boolean[] prime = new boolean[n + 1];
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i < n + 1; i++){
            prime[i] = true;
        }
        int p = 2;
        while(p < n){
            for (int j = p + 1; j < n + 1; j++){
                if (prime[j] & j % p == 0){
                        prime[j] = false;
                }
            }
            p++;
            while (prime[p] == false & p < n){
                p++;
            }
        }
        return prime;
    }

    public static int[] primes(int n){
        boolean[] primeCheck = sieveOfEratosthenes(n);
        int primesLength = 0;
        for (int i = 0; i < n; i++){
            if (primeCheck[i]){
                primesLength++;
            }
        }
        int[] primes = new int[primesLength];
        int k = 0;
        for (int i = 0; i < n; i++){
            if (primeCheck[i]){
                primes[k] = i;
                k++;
            }
        }
        return primes;
    }

    public static ArrayList<int[]> divider(int n) {
        int[] primes = primes((int) Math.pow(n, 0.5));
        ArrayList<int[]> divList = new ArrayList();

        if (n == 1){
            divList.add(new int[]{1, 1});
            return divList;
        }

        for (int d : primes) {
            int s = 0;
            while (n % d == 0) {
                n = n /= d;
                s += 1;
            }
            if (s != 0) {
                divList.add(new int[]{d, s});
            }
        }

        if (n != 1){
            divList.add(new int[]{n, 1});
        }

        return divList;
    }

    public static void printDivider(ArrayList<int[]> divider){
        for (int[] x : divider){
            System.out.print(Arrays.toString(x) + " ");
        }
        System.out.println();
    }

    public static int binarySearch(int[] a, int value) {
        //ищем значение от индекса l до индекса r
        // -----------------------
        //      l      m      r
        //      --------
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2; //середина диапазона
            if (value == a[m]){
                return m;
            } else if (value > a[m]){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void test(int[] a, int value, int correctAnswer) {
        // Looking for 'value' in 'a'
        int actualAnswer = binarySearch(a, value);
        if (actualAnswer == correctAnswer)
            System.out.println("ok");
        else
            System.out.println(
                    "Got " + actualAnswer + " instead of " + correctAnswer
            );
    }

}
