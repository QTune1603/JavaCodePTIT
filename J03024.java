import java.util.Scanner;

public class J03024 {
    public static int check(String s){
        if(s.charAt(0) == '0'){
            return -1;
        }
        int chan = 0,le = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(!Character.isDigit(s.charAt(i))){
                return -1;
            }
            if((s.charAt(i) -'0') % 2 == 0) chan++;
            else le++;
        }
        if((s.length() % 2 == 0 && chan > le) || (s.length() % 2 == 1 && le > chan)){
            return 1;
        }
        return 0;
    }
    
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            if(check(s) == -1){
                System.out.println("INVALID");
            }
            else if(check(s) == 1){
                System.out.println("YES");
            }
            else System.out.println("NO");
            
        }
        sc.close();
    }
}
