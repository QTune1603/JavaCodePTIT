import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J03010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<String> ar = new ArrayList<>();
        while(t-- > 0){
            String s = sc.nextLine();
            String a[] = s.trim().split("\\s+");
            String res = a[a.length-1].toLowerCase();
            
            for(int i = 0 ; i < a.length-1 ; i++){
                res += a[i].substring(0,1).toLowerCase();
            }
            ar.add(res);
            int cnt = Collections.frequency(ar, res);
            res += (cnt == 1 ? "" : cnt)  + "@ptit.edu.vn";
            System.out.println(res);
        } 
        sc.close();
    }
}
