import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien>{
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

    public Float getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(SinhVien p){
        return -(this.getGpa().compareTo(p.getGpa()));
    }
    
    @Override
    public String toString() {
        return id + " " + ten + " " + lop + " " + ngaySinh + " " + String.format("%.2f",gpa);
    }
    
    
}
public class J05005 {
    public static void main(String[] args) throws ParseException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String ngaySinh = sc.nextLine();
            float gpa = Float.parseFloat(sc.nextLine());
            list.add(new SinhVien(ten,lop,ngaySinh,gpa));
        }
        Collections.sort(list);
        for(SinhVien x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
