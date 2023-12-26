import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class SinhVien{
    public static int cnt = 1;
    private String id,ten,lop,ngaySinh;
    private float gpa;

    public SinhVien(String ten, String lop, String ngaySinh, float gpa) {
        this.id = String.format("B20DCCN%03d",cnt++);
        this.ten = chuanHoaName(ten);
        this.lop = lop;
        this.ngaySinh = chuanHoaDate(ngaySinh);
        this.gpa = gpa;
    }
    
    public String chuanHoaDate(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }
    
    public String chuanHoaName(String s){
        String a[] = s.trim().split("\\s+");
        String res = "";
        for(String x:a){
            res += x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase() + " ";
        }
        return res.substring(0,res.length()-1);
    }

    @Override
    public String toString() {
        return id + " " + ten + " " + lop + " " + ngaySinh + " " + String.format("%.2f",gpa);
    }
    
    
}
public class J05004 {
    public static void main(String[] args) throws ParseException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(t-- > 0){
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String ngaySinh = sc.nextLine();
            float gpa = Float.parseFloat(sc.nextLine());
            SinhVien a = new SinhVien(ten,lop,ngaySinh,gpa);
            System.out.println(a);
        }
        sc.close();
    }
}
