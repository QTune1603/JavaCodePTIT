import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class J03019 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        String a = scanner.nextLine();
        SortedSet<Character> b = new TreeSet<>();
        for (char i : a.toCharArray()) b.add(i);
        int cur = 0;
        for (char i = 'z'; i >= 'a'; --i) {
            for (int j = cur; j < a.length(); ++j)
                if (a.charAt(j) == i) {
                    System.out.print(i);
                    cur = j; 
                 }
        }
        scanner.close();
    }
}
