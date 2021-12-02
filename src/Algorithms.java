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

}
