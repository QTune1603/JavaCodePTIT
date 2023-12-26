import java.util.Scanner;

class sinhVien{
    private String ten,ngaySinh;
    private float diem1,diem2,diem3;

    public sinhVien(String ten, String ngaySinh, float diem1, float diem2, float diem3) {
        this.ten = ten;
        this.ngaySinh = chuanHoa(ngaySinh);
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }
    
    public String chuanHoa(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4)=='/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }
    public void in(){
        System.out.print(ten + " " + ngaySinh + " ");
        System.out.printf("%.1f",diem1+diem2+diem3);
    }
}

public class J04005 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine();
        String ngaySinh = sc.nextLine();
        float diem1 = sc.nextFloat();
        float diem2 = sc.nextFloat();
        float diem3 = sc.nextFloat();
        sinhVien a = new sinhVien(ten,ngaySinh,diem1,diem2,diem3);
        a.in();
        sc.close();
    }
}
