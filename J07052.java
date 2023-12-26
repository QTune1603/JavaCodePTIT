import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String ma,ten,trangThai;
    float p1,p2,p3,diemUuTien;
    Float total,diemChuan;

    public danhSach(String ma, String ten, float p1, float p2, float p3) {
        this.ma = ma;
        this.ten = name(ten);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        
        if(ma.substring(0,3).equals("KV1")){
            this.diemUuTien = 0.5f;
            this.total = p1*2 + p2 + p3 + 0.5f;
        }
        if(ma.substring(0,3).equals("KV2")){
            this.diemUuTien = 1.0f;
            this.total = p1*2 + p2 + p3 + 1.0f;
        }
        if(ma.substring(0,3).equals("KV3")){
            this.diemUuTien = 2.5f;
            this.total = p1*2 + p2 + p3 + 2.5f;
        }
    }
    
    public static String xoaZero(float x){
        DecimalFormat format = new DecimalFormat("#.#");
        return format.format(x);
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
        if(this.total == o.total){
            return this.ma.compareTo(o.ma);
        }
        return -this.total.compareTo(o.total);
    }
    
    
    
    @Override
    public String toString(){
        return ma + " " + ten + " " + xoaZero(diemUuTien) + " " + xoaZero(total) + " " + trangThai;
    }
}
 
public class J07052 {
    public static void main(String[] args) throws ParseException,FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            float p1 = Float.parseFloat(sc.nextLine());
            float p2 = Float.parseFloat(sc.nextLine());
            float p3 = Float.parseFloat(sc.nextLine());
            list.add(new danhSach(ma,ten,p1,p2,p3));
        }
        Collections.sort(list);
        int n = Integer.parseInt(sc.nextLine());
        float m = list.get(n-1).total;
        for(danhSach x:list){
            if(x.total >= m){
                x.trangThai = "TRUNG TUYEN";
            }
            else x.trangThai = "TRUOT";
        }
        System.out.println(String.format("%.1f", m));
        for(danhSach x:list){
            System.out.println(x);
        }
    }
}
