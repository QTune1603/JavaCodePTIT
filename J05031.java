import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>  {
    
    public String ma,ten,lop;
    public Float p1,p2,p3;
    public int id;
    public static int cnt = 1;

    public danhSach(String ma, String ten, String lop, Float p1, Float p2, Float p3) {
        
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    
    
    @Override
    public int compareTo(danhSach o){
        return this.ten.compareTo(o.ten);
    }

    @Override
    public String toString() {
        return cnt++ + " " + ma + " " + ten + " " + lop + " " + String.format("%.1f",p1) + " " + String.format("%.1f",p2) + " " + String.format("%.1f",p3) ;
    }
    
    
}
public class J05031 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while (t-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            float p1 = Float.parseFloat(sc.nextLine());
            float p2 = Float.parseFloat(sc.nextLine());
            float p3 = Float.parseFloat(sc.nextLine());
            list.add(new danhSach(ma,ten,lop,p1,p2,p3));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
