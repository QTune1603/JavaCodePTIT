import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String ten,soPhong,id;
    Date ngayNhan,ngayTra;
    Integer tienDichVu,total,donGia,soNgay;
    
    public static int cnt = 1;

    public danhSach(String ten, String soPhong, Date ngayNhan, Date ngayTra, int tienDichVu) {
        this.id = "KH" + String.format("%02d",cnt++);
        this.ten = chuanHoaName(ten);
        this.soPhong = soPhong;
        this.ngayNhan = ngayNhan;
        this.ngayTra = ngayTra;
        this.tienDichVu = tienDichVu;
        
        this.soNgay = thoiGian(ngayNhan,ngayTra);
        if(soPhong.substring(0,1).equals("1")){
            this.total = this.tienDichVu + soNgay*25;
        }
        if(soPhong.substring(0,1).equals("2")){
            this.total = this.tienDichVu + soNgay*34;
        }
        if(soPhong.substring(0,1).equals("3")){
            this.total = this.tienDichVu + soNgay*50;
        }
        if(soPhong.substring(0,1).equals("4")){
            this.total = this.tienDichVu + soNgay*80;
        }
    }
    
    public String chuanHoaName(String s){
        String a[] = s.trim().split("\\s+");
        String res = "";
        for(int i = 0 ; i < a.length ; i++){
            res += a[i].substring(0,1).toUpperCase() + a[i].substring(1).toLowerCase();
            res += " ";
        }
        return res.substring(0,res.length()-1);
    }
    
    public int thoiGian(Date ngayNhan, Date ngayTra){
        long in = ngayNhan.getTime();
        long out = ngayTra.getTime();
        return (int)((out-in) / (1000*60*60*24)) + 1;
    }
    
    @Override
    public int compareTo(danhSach o){
        return -this.total.compareTo(o.total);
    }
    
    @Override
    public String toString(){
        return id + " " + ten + " " + soPhong + " " + soNgay + " " + total;
    }
}
public class J07051 {
    public static void main(String[] args) throws  FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String soPhong = sc.nextLine();
            Date ngayNhan = sdf.parse(sc.nextLine());
            Date ngayTra = sdf.parse(sc.nextLine());
            int tienDichVu = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ten,soPhong,ngayNhan,ngayTra,tienDichVu));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
    }
}
