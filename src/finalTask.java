import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class finalTask {
    public static void main(String[] args) throws Exception {
        writeFile("numbersAligned.txt", readFile("numbers.txt"));
    }

    public static int[] readFile(String fileName) throws Exception{
        Path txt = Path.of(fileName);
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            return a;
        }
    }

    public static int maxLength(int[] a) throws Exception{
        int max = 0;
        for (int x : a){
            if (Integer.toString(x).length() > max){
                max = Integer.toString(x).length();
            }
        }
        return max;
    }

    public static String align(int[] a) throws Exception{
        int max = maxLength(a);
        String aligned = "";
        for (int i = 0; i < a.length; i++){
            String s = " ".repeat(max - Integer.toString(a[i]).length()) + Integer.toString(a[i]) + "\n";
            aligned += s;
        }
        return aligned;
    }

    public static void writeFile(String fileName, int[] a) throws Exception{
        try (PrintStream outFile = new PrintStream(fileName, StandardCharsets.UTF_8)) {
            outFile.println(align(a));
            outFile.flush();
        }
    }
}
