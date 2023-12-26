import java.util.ArrayList;
import java.util.Scanner;

class danhSach{
    public String ma,ten,lop,email;
    public String nganh;

    public danhSach(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        
        this.nganh = ma.substring(5,7);
    }
   
    
    

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + email;
    }
    
    
    
}
public class J05024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<danhSach> list = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            list.add(new danhSach(ma,ten,lop,email));
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String s = sc.nextLine().toUpperCase();
            System.out.println("DANH SACH SINH VIEN NGANH " + s + ":");
            String a[] = s.trim().split("\\s+");
            String h = ""  + a[0].charAt(0) + a[1].charAt(0);
            for(danhSach x:list){
                if(x.nganh.equals(h) && (x.lop.charAt(0) != 'E' || (x.lop.charAt(0) == 'E' && !h.equals("AT") && !h.equals("CN")))){
                    System.out.println(x);
                }
            }
        }
        sc.close();
    }
}
