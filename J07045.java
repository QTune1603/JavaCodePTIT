import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String kiHieu,ten;
    int donGiaNgay;
    double phiPhucVu;

    public danhSach(String kiHieu, String ten, int donGiaNgay, double phiPhucVu) {
        this.kiHieu = kiHieu;
        this.ten = ten;
        this.donGiaNgay = donGiaNgay;
        this.phiPhucVu = phiPhucVu;
    }

    @Override 
    public int compareTo(danhSach o){
        return this.ten.compareTo(o.ten);
    }
    
    @Override
    public String toString() {
        return kiHieu + " " + ten + " " + donGiaNgay + " " + phiPhucVu;
    }
    
    
}
public class J07045 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("PHONG.in"));               
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String kiHieu = sc.next();
            String ten = sc.next();
            int donGiaNgay = Integer.parseInt(sc.next());
            double phiPhucVu = Double.parseDouble(sc.next());
            list.add(new danhSach(kiHieu,ten,donGiaNgay,phiPhucVu));
        }
        Collections.sort(list);
        for(danhSach i:list){
            System.out.println(i);
        }
    }
}
