import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach  implements Comparable<danhSach> {
    
    public String ten;
    public Long c,t;

    public danhSach(String ten, long c, long t) {
        this.ten = ten;
        this.c = c;
        this.t = t;
    }
    
    
    
    
    @Override
    public int compareTo(danhSach o){
        if(this.c.compareTo(o.c) != 0){
            return -this.c.compareTo(o.c);
        }
        if(this.t.compareTo(o.t) != 0){
            return this.t.compareTo(o.t);
        }
        return this.ten.compareTo(o.ten);
    }

    @Override
    public String toString() {
        return ten + " " + c + " " + t;
    }
    
    
}

public class J05042 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while (n-- > 0) {
            String b = sc.nextLine();
            String x[] = sc.nextLine().trim().split("\\s+");
            long c = Long.parseLong(x[0]);
            long d = Long.parseLong(x[1]);
            list.add(new danhSach(b, c, d));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
