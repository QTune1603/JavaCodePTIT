import java.util.Scanner;

public class J03006 {
    public static boolean check(String s){
        int l = 0, r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r) || s.charAt(l)%2 != 0 || s.charAt(r)%2!=0){
                return false;
            }
            l++; r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            if(check(s)){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
        sc.close();
    }
}
