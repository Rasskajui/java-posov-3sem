public class IntroTaskLeap {
    public static void main(String[] args) {
        System.out.println(IsLeap(2020));
        System.out.println(IsLeap(2021));
        System.out.println(IsLeap(1600));
        System.out.println(IsLeap(2000));
    }

    public static boolean IsLeap(int x) {
        return (x % 400 == 0) || (x % 100 != 0 && x % 4 == 0);
    }
}
