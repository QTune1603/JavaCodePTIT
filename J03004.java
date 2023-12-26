import java.util.Scanner;

public class J03004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            String a[] = s.trim().split("\\s+");
            String res = "";
            for(int i = 0 ; i < a.length ; i++){
                res += a[i].substring(0,1).toUpperCase() + a[i].substring(1).toLowerCase();
                res += " ";
            }
            System.out.println(res.substring(0,res.length()-1));
            
        } 
        sc.close();
    }
}
