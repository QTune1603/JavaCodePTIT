import java.io.IOException;
import java.util.Scanner;

public class J03029 {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean isUpperCase = false;
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            a = a.trim().toLowerCase();
            a = a.replaceAll("\\s+", " ");
            a = a.replaceAll("\\s+([.!?])", "$1");
            a = String.valueOf(a.charAt(0)).toUpperCase() + a.substring(1);
            if (a.charAt(a.length() - 1) >= 'a' && a.charAt(a.length() - 1) <= 'z')
                a += ".";
            System.out.println(a);
        }
        scanner.close();
    }
}
