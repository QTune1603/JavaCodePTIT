import java.util.Scanner;

public class J03008 {
    public static boolean snt(String s){
        int l = s.length();
        for(int i = 0 ; i < l/2 ; i++){
            if(s.charAt(i) != s.charAt(l-i-1)) return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String s = sc.next();
            System.out.println(s.matches("[^014689]+") && snt(s) ? "YES" : "NO");
        }
        sc.close();
    }
}
