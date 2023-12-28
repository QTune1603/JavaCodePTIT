import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class J07032 {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        ObjectInputStream scanner = new ObjectInputStream(new FileInputStream ("DATA1.in"));
        // if (System.getProperty("ONLINE_JUDGE") == null) { 
        //     try { 
        //         System.setOut(new PrintS tream( 
        //             new FileOutputStream("java_output.txt"))); 
        //         scanner = new Scanner(new File("java_input.txt")); 
        //     } 
        //     catch (Exception e) { 
        //     } 
        // }   

        // int t = Integer.parseInt(scanner.nextLine()), test = 0;
        // while (t-- > 0) {
            
        // } 
        ArrayList<Integer> a = (ArrayList<Integer>)scanner.readObject();
        scanner = new ObjectInputStream(new FileInputStream ("DATA2.in"));
        ArrayList<Integer> b = (ArrayList<Integer>)scanner.readObject();
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();
        for (Integer i : a) 
            if (isPalin(i) && isFullOdd(i)) s1.add(i);
        for (Integer i : b)
            if (isPalin(i) && isFullOdd(i)) s2.add(i);
        int count = 0;
        for (Integer i : s1) 
            if (s2.contains(i) && count < 10) {
                System.out.println(i + " " + (Collections.frequency(a, i) + Collections.frequency(b, i)));
                ++count;
            }
    }   
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i)
            if (n % i == 0) return false;
        return true;
    }
    public static boolean isPalin(Integer n) {
        String a = n.toString();
        for (int i = 0; i < a.length() / 2; ++i)
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) return false;
        return true;
    }
    public static boolean isFullOdd(Integer n) {
        String a = n.toString();
        if (a.length() % 2 == 0 || a.length() == 1) return false;
        for (char i : a.toCharArray()) {
            if ((i - '0') % 2 == 0) return false;
        }
        return true;
    }
}
