import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    private String ma,ten;
    public Integer soSinhVien;

    public danhSach(String ma, String ten, int soSinhVien) {
        this.ma = ma;
        this.ten = ten;
        this.soSinhVien = soSinhVien;
    }
    
    @Override
    public int compareTo(danhSach o){
        if(this.soSinhVien.compareTo(o.soSinhVien) == 0){
            return this.ma.compareTo(o.ma);
        }
        return -this.soSinhVien.compareTo(o.soSinhVien);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soSinhVien;
    }
    
    
    
}
public class J05029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<danhSach> list = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soSinhVien = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ma,ten,soSinhVien));
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b + " SINH VIEN:");
            Collections.sort(list);
            for(danhSach x:list){
                if(x.soSinhVien >= a && x.soSinhVien <= b){
                    System.out.println(x);
                }
            }
        }
        sc.close();
    }
}
