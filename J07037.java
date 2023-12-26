import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String ma,ten;
    int soSinhVien;

    public danhSach(String ma, String ten, int soSinhVien) {
        this.ma = ma;
        this.ten = ten;
        this.soSinhVien = soSinhVien;
    }
    
    @Override
    public int compareTo(danhSach o){
        return this.ma.compareTo(o.ma);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soSinhVien;
    }
    
    
}
public class J07037 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("DN.in"));               
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soSinhVien = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ma,ten,soSinhVien));
        }
        Collections.sort(list);
        for(danhSach i:list){
            System.out.println(i);
        }
    }
}
