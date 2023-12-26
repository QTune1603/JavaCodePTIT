import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String id,ten,trangThai;
    Float p1,p2,p3,total;
    
    public static int cnt = 1;

    public danhSach(String ten, Float p1, Float p2, Float p3) {
        this.id = "SV" + String.format("%02d",cnt++);
        this.ten = name(ten);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        
        this.total = p1 * 0.25f + p2 * 0.35f + p3*0.4f;
        
        if(this.total >= 8){
            trangThai = "GIOI";
        }
        if(this.total >= 6.5 && this.total < 8){
            trangThai = "KHA";
        }
        if(this.total >= 5 && this.total < 6.5){
            trangThai = "TRUNG BINH";
        }
        if(this.total < 5){
            trangThai = "KEM";
        }
    }
    
    public String name(String s){
        String a[] = s.trim().split("\\s+");
        String res = "";
        for(int i = 0 ; i < a.length ; i++){
            res += a[i].substring(0,1).toUpperCase() + a[i].substring(1).toLowerCase();
            res += " ";
        }
        return res.substring(0,res.length()-1);
    }
    
    @Override
    public int compareTo(danhSach o){
        return -this.total.compareTo(o.total);
    }
    
    @Override
    public String toString(){
        return id + " " + ten + " " + String.format("%.2f",total) + " " + trangThai;
    }
}
public class J07055 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            float p1 = Float.parseFloat(sc.nextLine());
            float p2 = Float.parseFloat(sc.nextLine());
            float p3 = Float.parseFloat(sc.nextLine());
            list.add(new danhSach(ten,p1,p2,p3));
        }
        Collections.sort(list);
        
        for(danhSach x:list){
            System.out.println(x);
        }
    }
}
