import java.util.Scanner;

class sinhVien{
    private String ten,lop,ngaySinh;
    private float gpa;

    public sinhVien(String ten, String lop, String ngaySinh, float gpa) {
        this.ten = ten;
        this.lop = lop;
        this.ngaySinh = chuanHoa(ngaySinh);
        this.gpa = gpa;
    }
    
    public String chuanHoa(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3 ,'0'); 
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return  "B20DCCN001 " + ten + " " + lop + " " + ngaySinh + " " + String.format("%.2f",gpa);
    }
}
public class J04006 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine();
        String lop = sc.nextLine();
        String ngaySinh = sc.nextLine();
        float gpa = sc.nextFloat();
        sinhVien x = new sinhVien(ten,lop,ngaySinh,gpa);
        System.out.println(x);
        sc.close();
    }
}
