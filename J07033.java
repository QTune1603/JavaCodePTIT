import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String ma,ten,lop,mail;

    public SinhVien(String ma, String ten, String lop, String mail) {
        this.ma = ma;
        this.ten = chuanHoaName(ten);
        this.lop = lop;
        this.mail = mail;
    }
    
    public String chuanHoaName(String s){
        String a[] = s.trim().split("\\s+");
        String res = "";
        for(String x:a){
            res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
        }
        return res.substring(0,res.length()-1);
    }

    public String getMa() {
        return ma;
    }
    
    
    
    @Override 
    public int compareTo(SinhVien p){
        return this.ma.compareTo(p.ma);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + mail ; 
    }
    
    
}

public class J07033 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        ArrayList<SinhVien> a = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 1 ; i <= t ; i++){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String mail = sc.nextLine();
            a.add(new SinhVien(ma,ten,lop,mail));
        }
        Collections.sort(a);
        for(SinhVien x:a){
            System.out.println(x);
        }
    }
}
