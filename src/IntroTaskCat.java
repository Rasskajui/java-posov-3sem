public class IntroTaskCat {
    public static void main(String[] args) {
        System.out.println(Cat(0));
        System.out.println(Cat(21));
        System.out.println(Cat(11));
        System.out.println(Cat(33));
    }

    public static String Cat(int x) {
        String cats;
        int LastTwo = x % 100;
        int LastOne = x % 10;
        if (LastTwo <= 20 && LastTwo >= 10) {
            cats = "котов";
        } else if (LastOne >= 5 && LastOne <= 9 || LastOne == 0) {
            cats = "котов";
        } else if (LastOne == 1) {
            cats = "кот";
        } else {
            cats = "кота";
        }
        return x + " " + cats;
    }
}
