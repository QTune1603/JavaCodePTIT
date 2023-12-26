import java.io.FileNotFoundException;
import java.util.Scanner;

class tuyenSinh{
    private String ma,ten,trangThai ="";
    private double diemToan,diemLy,diemHoa;
    private double tongDiem,diemUuTien;

    public tuyenSinh(String ma, String ten, double diemToan, double diemLy, double diemHoa) {
        this.ma = ma;
        this.ten = ten;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        
        if(ma.substring(0,3).equals("KV1")){
            this.diemUuTien = 0.5;
        }
        else if(ma.substring(0,3).equals("KV2")){
            this.diemUuTien = 1.0;
        }
        else if(ma.substring(0,3).equals("KV3")){
            this.diemUuTien = 1.5;
        }
        
        this.tongDiem = diemToan * 2 + diemLy + diemHoa ;
        
        if(diemToan * 2 + diemLy + diemHoa + diemUuTien < 24){
            trangThai += "TRUOT";
        }
        else trangThai += "TRUNG TUYEN";
        
    }
    
    public String formatFloat(double x){
        int xInt = (int)(x*10);
        return xInt % 10 == 0 ? String.format("%.0f", x) : String.format("%.1f", x);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + formatFloat(diemUuTien) + " " + formatFloat(tongDiem) + " " + trangThai;
    }
    
    
}
public class J04013 {
    public static void main(String[] args) throws FileNotFoundException  {
        Scanner sc = new Scanner(System.in);
        String ma = sc.nextLine();
        String ten = sc.nextLine();
        double diemToan = sc.nextDouble();
        double diemLy = sc.nextDouble();
        double diemHoa = sc.nextDouble();
        tuyenSinh a = new tuyenSinh(ma,ten,diemToan,diemLy,diemHoa);
        System.out.println(a);
        sc.close();
    }
}
