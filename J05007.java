import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


class nhanVien implements Comparable<nhanVien>{
    public static int cnt = 1;
    private String ma,ten,gioiTinh,diaChi;
    private Date ngaySinh,ngayKy;
    private long maSo;

    public nhanVien(String ten, String gioiTinh, Date ngaySinh, String diaChi,long maSo, Date ngayKy) {
        this.ma = String.format("%05d",cnt++);
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.ngayKy = ngayKy;
        this.maSo = maSo;
    }
    public String chuanHoa(Date s){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(s);
    }
    
    
    
    @Override
    public int compareTo(nhanVien p){
        return this.ngaySinh.compareTo(p.ngaySinh);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + chuanHoa(ngaySinh) + " " + diaChi + " " + maSo + " " + chuanHoa(ngayKy);
    }
    
    
    
}
public class J05007 {
    public static void main(String[] args) throws FileNotFoundException, ParseException  {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<nhanVien> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            Date ngaySinh = sdf.parse(sc.nextLine());
            String diaChi = sc.nextLine();
            long maSo = Long.parseLong(sc.nextLine());
            Date ngayKy = sdf.parse(sc.nextLine());
            list.add(new nhanVien(ten,gioiTinh,ngaySinh,diaChi,maSo,ngayKy));
        }
        Collections.sort(list);
        for(nhanVien x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
