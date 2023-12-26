import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach> {
    private String ma,ten;
    private Integer giaBan,thoiHan;

    public danhSach(String ma, String ten, int giaBan, int thoiHan) {
        this.ma = ma;
        this.ten = ten;
        this.giaBan = giaBan;
        this.thoiHan = thoiHan;
    }
    
    
    
    @Override
    public int compareTo(danhSach o){
        if(this.giaBan.compareTo(o.giaBan) == 0){
            return this.ma.compareTo(o.ma);
        }
        return -this.giaBan.compareTo(o.giaBan);
    }
    
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + giaBan + " " + thoiHan;
    }
    
    
}

public class J07048 {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(n-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int giaBan = Integer.parseInt(sc.nextLine());
            int thoihan = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ma,ten,giaBan,thoihan));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        
    }
}
