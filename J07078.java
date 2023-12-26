import java.io.File;
import java.util.Scanner;

public class J07078 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File ("STRING.in"));
        
        int n = sc.nextInt();
        
        for (int i =0; i < n;i++) {
            String x = sc.next();
            String y = sc.next();
            
            if (x.contains(y)) {
                int lenx = x.length();
                int leny = y.length();
                
                int l = 0;
                int r = leny;
                
                for (; r <= lenx; r++ ) {
                    String tmp = x.substring(l, r);
                    if (tmp.equals(y)) {
                        System.out.print((l + 1) + " ");
                    }
                    l++;
                }
                System.out.println();
            }
        }
    }
}
