import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach  implements Comparable<danhSach> {
    
    public static int cnt = 1;
    public String id;
    public String ten,chucVu;
    public long luongNgay,soNgayCong,luongThang,phuCap,luongThuong;
    public Long total;
    
    public danhSach(String ten, long luongNgay, long soNgayCong , String chucVu) {
        this.id = "NV" + String.format("%02d", cnt++);
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongNgay = luongNgay;
        this.soNgayCong = soNgayCong;
        
        this.luongThang = luongNgay * soNgayCong;
        
        if(chucVu.equals("GD")){
            phuCap = 250000;
        }
        if(chucVu.equals("PGD")){
            phuCap = 200000;
        }
        if(chucVu.equals("TP")){
            phuCap = 180000;
        }
        if(chucVu.equals("NV")){
            phuCap = 150000;
        }
        
        if(soNgayCong >= 25){
            luongThuong = luongThang/5;
        }
        else if(soNgayCong >= 22 && soNgayCong < 25){
            luongThuong = luongThang/10;
        }
        if(soNgayCong < 22){
            luongThuong = 0;
        }
        
        total = luongThang + luongThuong + phuCap;
    }
    
    @Override
    public int compareTo(danhSach o){
        return -this.total.compareTo(o.total);
    }

    @Override
    public String toString() {
        return id + " " + ten + " " + luongThang + " " + luongThuong + " " + phuCap + " " + total;
    }
    
    
}
public class J05041 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while (t-- > 0) {
            String ten = sc.nextLine();
            long luongNgay = Long.parseLong(sc.nextLine());
            long soNgayCong = Long.parseLong(sc.nextLine());
            String chucVu = sc.nextLine();
            list.add(new danhSach(ten,luongNgay,soNgayCong,chucVu));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
