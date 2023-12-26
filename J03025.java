import java.util.Scanner;

public class J03025 {
    public static boolean check(String s) {
        int l = 0, r = s.length()-1;
        int cnt = 0;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                cnt++;
            }
            l++; r--;
        }
        if(cnt == 1) return true;
        else return false;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int l = s.length(), cnt = 0;
            for (int i = 0; i < l / 2; i++) {
                if (s.charAt(i) != s.charAt(l - i - 1)) {
                    cnt++;
                }
            }
            if ((l % 2 == 0 && cnt == 1) || (l % 2 == 1 && cnt <= 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
