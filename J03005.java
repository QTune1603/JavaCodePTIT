import java.util.Scanner;

public class J03005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            String a[] = s.trim().split("\\s+");
            for(int i = 1 ; i < a.length ; i++){
                System.out.print(a[i].substring(0, 1).toUpperCase() + a[i].substring(1).toLowerCase());
                if(i != a.length - 1){
                    System.out.print(" ");
                }
            }
            System.out.println(", " + a[0].toUpperCase());
            System.out.println("");
        }
        sc.close();
    }
}
