import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    public String ten,ma,xepLoai;
    public Float p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,total;
    public static int cnt = 1;

    public danhSach(String ten, float p1, float p2, float p3, float p4, float p5, float p6, float p7, float p8, float p9, float p10) {
        this.ma = "HS" + String.format("%02d",cnt++);
        this.ten = ten;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
        this.p10 = p10;
        
        this.total = (p1*2+p2*2+p3+p4+p5+p6+p7+p8+p9+p10)/12f;
        
        total = Math.round(total*10f)/10f;
        
    }
    public String getXepLoai(){
        if(total >= 9){
            return "XUAT SAC";
        }
        if(total >= 8){
            return "GIOI";
        }
        if(total >= 7){
            return "KHA";
        }
        if(total >= 5){
            return "TB";
        }
        return "YEU";
    }
    @Override
    public int compareTo(danhSach o){
        if(this.total.compareTo(o.total) == 0){
            return this.ma.compareTo(o.ma);
        }
        return o.total.compareTo(this.total);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + total + " " + getXepLoai();
    }
}
public class J05018 {
    public static void main(String[] args) throws FileNotFoundException, ParseException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            float p1 = Float.parseFloat(sc.next());
            float p2 = Float.parseFloat(sc.next());
            float p3 = Float.parseFloat(sc.next());
            float p4 = Float.parseFloat(sc.next());
            float p5 = Float.parseFloat(sc.next());
            float p6 = Float.parseFloat(sc.next());
            float p7 = Float.parseFloat(sc.next());
            float p8 = Float.parseFloat(sc.next());
            float p9 = Float.parseFloat(sc.next());
            float p10 = Float.parseFloat(sc.next());
            sc.nextLine();
            list.add(new danhSach(ten,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
        }
        Collections.sort(list);
        for(danhSach x : list){
            System.out.println(x);
        }
        sc.close();
    }
}
