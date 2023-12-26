import java.util.Scanner;

public class J03007 {
    public static boolean tong(String s){
        int sum = 0;
        for(char x:s.toCharArray()){
            sum += x - '0';
        }
        return sum % 10 == 0;
    }

    public static boolean check(String s){
        int l = 0, r = s.length()-1;
        if(s.charAt(0) == 8 && s.charAt(s.length()-1) == 8){
            return false;
        }
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
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
            if(check(s) && tong(s)){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
        sc.close();
    }
}
