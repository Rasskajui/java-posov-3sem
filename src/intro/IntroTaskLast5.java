package intro;

public class IntroTaskLast5 {
    public static void main(String[] args) {
        System.out.println(isLast5(125));
        System.out.println(isLast5(24));
    }

    public static boolean isLast5(int x){
        return (x%10) == 5;
    }
}
