import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
  
class A {
    String b;
    Long a, c;
    A(Long a, String b, Long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class J05071 {
    public static void main(String args[]) throws IOException {  
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        ArrayList<A> a = new ArrayList<>();
        while (t-- > 0) {
            long b = Long.parseLong(scanner.nextLine());
            String c = scanner.nextLine();                            
            long d = Long.parseLong(scanner.nextLine());
            a.add(new A(b, c, d));
        }

        int u = Integer.parseInt(scanner.nextLine());
        while (u-- > 0) {
            String b[] = scanner.nextLine().trim().split("\\s+");
            long c = ((b[1].charAt(0) - '0') * 10 + (b[1].charAt(1) - '0')) * 60 + (b[1].charAt(3) - '0') * 10 + (b[1].charAt(4) - '0');
            long d = ((b[2].charAt(0) - '0') * 10 + (b[2].charAt(1) - '0')) * 60 + (b[2].charAt(3) - '0') * 10 + (b[2].charAt(4) - '0');
            long e = d - c;
            if (b[0].charAt(0) == '0') {
                long f = (b[0].charAt(1) - '0') * 10 + (b[0].charAt(2) - '0'); 
                for (A i : a) {
                    if (i.a == f) {
                        System.out.println(b[0] + " " + i.b + " " + e + " " + (e * i.c));
                        break;
                    }
                }
                continue;
            }
            long f = Math.round(e * 1.0 / 3);
            System.out.println(b[0] + " Noi mang " + f + " " + f * 800);
        }
        scanner.close();
    }
}
