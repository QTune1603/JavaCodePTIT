import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>  {
    
    public String ten,ngaySinh;
    public String young,old;
    public String ngay,thang,nam;

    
    public danhSach(String ten, String ngaySinh) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        
        this.ngay = ngaySinh.substring(0,2);
        this.thang = ngaySinh.substring(3,5);
        this.nam = ngaySinh.substring(6,10);
    }

    public String getTen() {
        return ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
    
    
    
    @Override
    public int compareTo(danhSach o){
        if(this.nam.compareTo(o.nam) == 0){
            if(this.thang.compareTo(o.thang) == 0){
                return this.ngay.compareTo(o.ngay);
            }
            else return this.thang.compareTo(o.thang);
        }
        return this.nam.compareTo(o.nam);
    }

    @Override
    public String toString() {
        return  ten ;
    }
    
    
}
public class J05032 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while (t-- > 0) {
            String ten = sc.next();
            String ngaySinh = sc.next();
            sc.nextLine();
            list.add(new danhSach(ten,ngaySinh));
        }
        Collections.sort(list);
        danhSach x = list.get(0);
        danhSach y = list.get(list.size()-1);
        System.out.println(y);
        System.out.println(x);
        sc.close();
        
    }
}
