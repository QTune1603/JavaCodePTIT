import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class J02037 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        // if (System.getProperty("ONLINE_JUDGE") == null) { 
        //     try { 
        //         System.setOut(new PrintStream( 
        //             new FileOutputStream("java_output.txt"))); 
        //         scanner = new Scanner(new File("java_input.txt")); 
        //     } 
        //     catch (Exception e) { 
        //     } 
        // }    

        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            String temp[] = scanner.nextLine().trim().split("\\s+");
            ArrayList<Long> a = new ArrayList<>();
            int count_odd = 0, count_even = 0;
            for (String i : temp) {
                Long n = 0L;
                for (char j : i.toCharArray()) n = n * 10 + (j - '0');
                if (n % 2 == 0) ++count_even;
                else ++count_odd;
                a.add(n);
            } 
            if ((a.size() % 2 == 1 && count_odd > count_even) || (a.size() % 2 == 0 && count_even > count_odd))
                System.out.println("YES");
            else System.out.println("NO");
        }
        scanner.close();
    }   
    public static Long gcd(Long a, Long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
