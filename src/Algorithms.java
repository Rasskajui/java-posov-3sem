import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(20)));
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
}
