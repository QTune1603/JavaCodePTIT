import java.util.Scanner;

class SinhVien{
    
    public static int cnt = 1;
    private String id,ten,lop,ngaySinh;
    private float gpa;

    public SinhVien(String ten, String lop, String ngaySinh, float gpa) {
        this.id = "B20DCCN" + String.format("%03d",cnt++);
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
            sb.insert(3,'0');
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return id + " " + ten + " " + lop + " " + ngaySinh + " " + String.format("%.2f",gpa);
    }
    
}

public class J05003 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
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
