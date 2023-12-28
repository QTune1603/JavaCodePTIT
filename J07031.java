import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
public class J07031 {
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
        for (int i : a) 
            if (isPrime(i)) s1.add(i);
        for (int i : b) 
            if (isPrime(i)) s2.add(i);
        for (int i : s1) 
            if (s1.contains(1000000 - i) && isPrime(1000000 - i) && i < 1000000 - i && !s2.contains(i) && !s2.contains(1000000 - i)) 
                System.out.println(i + " " + (1000000 - i));
    }   
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; ++i)
            if (n % i == 0) return false;
        return true;
    }
}
