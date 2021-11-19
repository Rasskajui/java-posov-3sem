public class IntroTaskLeap {
    public static void main(String[] args) {
        System.out.println(isLeap(2020));
        System.out.println(isLeap(2021));
        System.out.println(isLeap(1600));
        System.out.println(isLeap(2000));
    }

    public static boolean isLeap(int x) {
        return (x % 400 == 0) || (x % 100 != 0 && x % 4 == 0);
    }
}
