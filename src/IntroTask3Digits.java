public class IntroTask3Digits {
    public static void main(String[] args) {
        System.out.println(is3Digets(10));
        System.out.println(is3Digets(100));
        System.out.println(is3Digets(1000));
    }

    public static boolean is3Digets(int x) {
        return x >= 100 && x <= 999;
    }
}
