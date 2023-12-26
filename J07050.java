import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String id,nhomHang,ten;
    Float giaMua,giaBan,loiNhuan;
    
    public static int cnt = 1;

    public danhSach( String nhomHang, String ten, float giaMua, float giaBan) {
        this.id = "MH" + String.format("%02d",cnt++);
        this.nhomHang = nhomHang;
        this.ten = ten;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        
        this.loiNhuan = this.giaBan - this.giaMua;
    }
    
    @Override
    public int compareTo(danhSach o){
        return -this.loiNhuan.compareTo(o.loiNhuan);
    }

    @Override
    public String toString() {
        return id + " " + nhomHang + " " + ten + " " + String.format("%.2f",loiNhuan);
    }
    
    
    
}
public class J07050 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("MATHANG.in"));               
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String nhomHang = sc.nextLine();
            String ten = sc.nextLine();
            float giaMua = Float.parseFloat(sc.nextLine());
            float giaBan = Float.parseFloat(sc.nextLine());
            list.add(new danhSach(nhomHang,ten,giaMua,giaBan));
        }
        Collections.sort(list);
        for(danhSach i:list){
            System.out.println(i);
        }
    }
}
