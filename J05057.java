import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class danhSach {
    String ma,ten,trangThai ="";
    double p1,p2,p3;
    Double total,diemUuTien ;

    public danhSach(String ma, String ten, double p1, double p2, double p3) {
        this.ma = ma;
        this.ten = ten;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        
        if(ma.substring(0,3).equals("KV1")){
            this.diemUuTien = 0.5;
        }
        if(ma.substring(0,3).equals("KV2")){
            this.diemUuTien = 1.0;
        }
        if(ma.substring(0,3).equals("KV3")){
            this.diemUuTien = 2.5;
        }
        
        this.total = p1*2+p2+p3 ;
        
        if(this.total + this.diemUuTien < 24){
            this.trangThai += "TRUOT";
        }
        else this.trangThai += "TRUNG TUYEN";
    }

    public String formatFloat(double x){
        int xInt = (int)(x*10);
        return xInt % 10 == 0 ? String.format("%.0f", x) : String.format("%.1f",x);
    }
    
    @Override
    public String toString() {
        return  ma + " " + ten + " " + formatFloat(diemUuTien) + " " + formatFloat(total) + " " + trangThai;
    }
    
    
}

public class J05057 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            float p1 = Float.parseFloat(sc.nextLine());
            float p2 = Float.parseFloat(sc.nextLine());
            float p3 = Float.parseFloat(sc.nextLine());
            list.add(new danhSach(ma,ten,p1,p2,p3));
        }
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
