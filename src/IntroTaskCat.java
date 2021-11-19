public class IntroTaskCat {
    public static void main(String[] args) {
        System.out.println(Cat(0));
        System.out.println(Cat(21));
        System.out.println(Cat(11));
        System.out.println(Cat(33));
    }

    public static String Cat(int x) {
        String cats;
        int lastTwo = x % 100;
        int lastOne = x % 10;
        if (lastTwo <= 20 && lastTwo >= 10) {
            cats = "котов";
        } else if (lastOne >= 5 && lastOne <= 9 || lastOne == 0) {
            cats = "котов";
        } else if (lastOne == 1) {
            cats = "кот";
        } else {
            cats = "кота";
        }
        return x + " " + cats;
    }
}
