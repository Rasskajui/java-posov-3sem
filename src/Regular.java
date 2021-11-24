import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
        System.out.println(isEmail("nana@mail.ru"));
        System.out.println(isEmail("nana73_05@mail.ru"));
        System.out.println(isEmailComplex("nana73_05@mail.ru"));
        System.out.println(isEmailComplex("nana7305@mail.@ru"));
        System.out.println();

        allTimes("Это текст про 22:15 или про 54:26, а может может быть 15:90 сможет 03:24");
        System.out.println();

        System.out.println(replaceWhiteSpaces("Это строка , у которой зачем-то написаны два , пробела перед запятой."));
        System.out.println();

        System.out.println(switchWords("Какая-то сине-зеленовая трава"));
    }

    public static boolean isEmail(String email){
        Pattern emailPattern = Pattern.compile("[a-z]+@[a-z]+\\.[a-z]{2,4}");
        Matcher m = emailPattern.matcher(email);
        return m.matches();
    }

    public static boolean isEmailComplex(String email){
        Pattern emailPattern = Pattern.compile("[a-z-_\\d]+@[a-z-_\\d]+\\.[a-z]{2,4}");
        Matcher m = emailPattern.matcher(email);
        return m.matches();
    }

    public static boolean isEmailStandard(String email){
        Pattern emailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher m = emailPattern.matcher(email);
        return m.matches();
    }

    public static boolean isTime(String s){
        Pattern isTimePattern = Pattern.compile("((0|1)\\d|20|21|22|23):((0|1|2|3|4|5)\\d)");
        Matcher m = isTimePattern.matcher(s);
        return m.matches();
    }

    public static void allTimes(String s){
        Pattern timePattern = Pattern.compile("\\d\\d:\\d\\d");
        Matcher m = timePattern.matcher(s);
        while(m.find()){
            String x = m.group();
            if (isTime(x)){
                System.out.println(x + " время");
            } else {
                System.out.println(x + " невремя");
            }
        }
    }

    public static String replaceWhiteSpaces(String s){
        return s.replaceAll("\\s++,", ",");
    }

    public static String switchWords(String s){
        return s.replaceAll("([а-яА-Яa-zA-Z]+)-([а-яА-Яa-zA-Z]+)", "$2-$1");
    }


}
