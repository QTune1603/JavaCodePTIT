import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class danhSach implements Comparable<danhSach> {
    
    public static int cnt = 1;
    private String ten,maPhong,id;
    private Long soNgay;

    public danhSach(String ten, String maPhong, Long soNgay) {
        this.id = "KH" + String.format("%02d",cnt++);
        this.ten = ten;
        this.maPhong = maPhong;
        this.soNgay = soNgay;
        
    }
    
    @Override
    public int compareTo(danhSach o){
        return -this.soNgay.compareTo(o.soNgay);
    }
    
    @Override
    public String toString() {
        return id + " " + ten + " " + maPhong + " "  + soNgay;
    }
    
    
}
public class J07046 {
    public static void main(String args[]) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(n-- > 0) {
            String ten = sc.nextLine();
            String maPhong = sc.nextLine();
            Date ngayDen = sdf.parse(sc.nextLine());
            Date ngayDi = sdf.parse(sc.nextLine());
            Long soNgay = (ngayDi.getTime() - ngayDen.getTime()) / (1000L * 60 * 60 * 24);
            list.add(new danhSach(ten,maPhong,soNgay));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        
    }
}
