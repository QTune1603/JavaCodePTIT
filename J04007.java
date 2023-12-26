import java.util.Scanner;

class nhanVien{
    private String ten,gioiTinh,ngaySinh,diaChi,ngayKy;
    private long maSo;

    public nhanVien(String ten, String gioiTinh, String ngaySinh, String diaChi, String ngayKy, long maSo) {
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = chuanHoa(ngaySinh);
        this.diaChi = diaChi;
        this.ngayKy = ngayKy;
        this.maSo = maSo;
    }
    
    public String chuanHoa(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3,'0');
        }
        return sb.toString();
    }
    
    public void in(){
        System.out.println("00001 " + ten + " " + gioiTinh + " " + ngaySinh + " " + diaChi + " " + maSo + " " + ngayKy);
    }
}
public class J04007 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine();
        String gioiTinh = sc.nextLine();
        String ngaySinh = sc.nextLine();
        String diaChi = sc.nextLine();
        long maSo = Long.parseLong(sc.nextLine());
        String ngayKy = sc.nextLine();
        nhanVien a = new nhanVien(ten,gioiTinh,ngaySinh,diaChi,ngayKy,maSo);
        a.in();
        sc.close();
    }
}
