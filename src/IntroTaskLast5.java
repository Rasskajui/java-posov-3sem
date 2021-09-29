public class IntroTaskLast5 {
    public static void main(String[] args) {
        System.out.println(is_Last5(125));
        System.out.println(is_Last5(24));
    }

    public static boolean is_Last5(int x){
        return (x%10) == 5;
    }
}
