public class IntroTaskSameDigits {
    public static void main(String[] args) {
        System.out.println(isSame(2333));
        System.out.println(isSame(2323));
    }

    public static boolean isSame(int x) {
        return x%10 == (x%100)/10;
    }
}
