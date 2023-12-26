import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

class xetTuyen{
    public static int cnt = 1;
    private String id,ten,ngaySinh;
    private int tuoi;
    private int sumMark;

    public xetTuyen(String ten, String ngaySinh, double diem1, double diem2) {
        this.id = "PH" + String.format("%02d",cnt++);
        this.ten = chuanHoaTen(ten);
        this.ngaySinh = chuanHoaDate(ngaySinh);
        this.sumMark = countSumMark(diem1,diem2);
        
        this.tuoi = tinhTuoi(ngaySinh);
    }
    
    public int countSumMark(double diem1, double diem2){
        double diemThuong = 0;
        if(diem1 >= 8.0 && diem2 >= 8.0) diemThuong = 1;
        else if(diem1 >= 7.5 && diem2 >= 7.5) diemThuong = 0.5;
        double res = (diem1 + diem2)/2 + diemThuong;
        int ans = (int)Math.round(res);
        if(ans > 10) ans = 10;
        return ans;
    }
    
    
    
    public int tinhTuoi(String s){
        String a[] = s.split("/");
        int year = Integer.parseInt(a[2]);
        return 2021 - year;
    }
    
    public String chuanHoaDate(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) =='/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) =='/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }
    
    public String chuanHoaTen(String s){
        String a[] = s.trim().split("\\s+");
        String res ="";
        for(String x:a){
            res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
        }
        return res.substring(0, res.length()-1);
    }
    
    
    @Override
    public String toString() {
        String s = "";
        if(sumMark < 5){
            s += "Truot";
        }
        else if(sumMark < 7){
            s += "Trung binh";
        }
        else if(sumMark < 8){
            s += "Kha";
        }
        else if(sumMark < 9){
            s += "Gioi";
        }
        else s+= "Xuat sac";
        
        return id + " " + ten + " " + tuoi + " " + sumMark + " " + s;
    }
    
}

public class J07053 {
    public static void main(String[] args) throws ParseException, FileNotFoundException  {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<xetTuyen> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double diem1 = Double.parseDouble(sc.nextLine());
            double diem2 = Double.parseDouble(sc.nextLine());
            list.add(new xetTuyen(ten,ngaySinh,diem1,diem2));
        }
        for(xetTuyen x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
