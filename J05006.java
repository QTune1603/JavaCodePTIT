import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class nhanVien{
    public static int cnt = 1;
    private String ma,ten,gioiTinh,ngaySinh,diaChi,ngayKy;
    private long maSo;

    public nhanVien(String ten, String gioiTinh, String ngaySinh, String diaChi,long maSo, String ngayKy) {
        this.ma = String.format("%05d",cnt++);
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.ngayKy = ngayKy;
        this.maSo = maSo;
    }
    public String chuanHoa(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) =='/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) =='/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + ngaySinh + " " + diaChi + " " + maSo + " " + ngayKy;
    }
    
    
    
}

public class J05006 {
    public static void main(String[] args) throws FileNotFoundException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<nhanVien> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            long maSo = Long.parseLong(sc.nextLine());
            String ngayKy = sc.nextLine();
            list.add(new nhanVien(ten,gioiTinh,ngaySinh,diaChi,maSo,ngayKy));
        }
        for(nhanVien x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
