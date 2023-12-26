import java.util.HashSet;
import java.util.Scanner;

public class J03009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String a[] = s1.trim().split("\\s+");
            HashSet<String> c = new HashSet<>();
            for(String x:a){
                if(!s2.contains(x)){
                    c.add(x);
                }
            }
            for(String x:c){
                System.out.print(x + " ");
            }
            System.out.println("");
        } 
        sc.close();
    }
}
