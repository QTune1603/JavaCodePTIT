import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J07076 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        // Scanner scanner = new Scanner(new File ("java_input.txt"));
        Scanner scanner = new Scanner(new File ("MATRIX.in"));
        
        int t = Integer.parseInt(scanner.nextLine()), test = 0;
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();
            int a[][] = new int[n][m];
            for (int i = 0; i < n; ++i) 
                for (int j = 0; j < m; ++j) a[i][j] = scanner.nextInt();
            ArrayList<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; ++i) b.add(a[i][c - 1]);
            Collections.sort(b);
            ArrayList<String> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String s = "";
                for (int j = 0; j < m; ++j) {
                    Integer x = a[i][j];
                    if (j == c - 1) {
                        s += b.get(i).toString() + " ";
                        continue;
                    }
                    s += x.toString() + " ";
                }
                ans.add(s);
            }
            for (String i : ans) System.out.println(i);
        }
        scanner.close();
    }   
}
