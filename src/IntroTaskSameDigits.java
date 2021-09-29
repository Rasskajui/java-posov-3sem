public class IntroTaskSameDigits {
    public static void main(String[] args) {
        System.out.println(IsSame(2333));
        System.out.println(IsSame(2323));
    }

    public static boolean IsSame(int x) {
        return x%10 == (x%100)/10;
    }
}
