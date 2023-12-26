import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String id,ten,danToc,trangThai;
    float diem,diemUuTien = 0;
    Float total;
    int khuVuc;
    public static int cnt = 1;

    public danhSach(String ten, String danToc, float diem, int khuVuc) {
        this.id = "TS" + String.format("%02d", cnt++);
        this.ten = name(ten);
        this.danToc = danToc;
        this.diem = diem;
        this.khuVuc = khuVuc;
        
        if(this.khuVuc == 1 ){
            diemUuTien += 1.5f;
        }
        if(this.khuVuc == 2){
            diemUuTien += 1;
        }
        if(this.khuVuc == 3 ){
            diemUuTien += 0;
        }
        if(!this.danToc.equals("Kinh")){
            diemUuTien += 1.5f;
        }
        else {
            diemUuTien += 0;
        }
        
        this.total = this.diem + this.diemUuTien;
        
        if(this.total >= 20.5){
            trangThai = "Do";
        }
        else {
            trangThai = "Truot";
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

    public int compareTo(danhSach o){
        if(this.total.compareTo(o.total) == 0){
            return this.id.compareTo(o.id);
        }
        return Float.compare(o.total,this.total);
    }
    
    @Override
    public String toString() {
        return id + " " + ten + " " + String.format("%.1f",total) + " " + trangThai;
    }
    
    
}
public class J07057 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            float diem = Float.parseFloat(sc.nextLine());
            String danToc = sc.nextLine();
            int khuVuc = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ten,danToc,diem,khuVuc));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
    }
}
