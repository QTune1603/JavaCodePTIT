import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

class danhSach{
    public String ma,ten,lop,email;
    public int khoaHoc;

    public danhSach(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        
        this.khoaHoc = Integer.parseInt(ma.substring(1,3));
    }

    public String getLop() {
        return lop;
    }

    public int getKhoaHoc(){
        return khoaHoc;
    }

    @Override
    public String toString() {
        return  ma + " " + ten + " " + lop + " " + email;
    }
    
    
}
public class J05023 {
    public static void main(String[] args) throws FileNotFoundException, ParseException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            list.add(new danhSach(ma,ten,lop,email));
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            int s = sc.nextInt();
            System.out.println("DANH SACH SINH VIEN KHOA " + s + ":");
            for(int i = 0 ; i < list.size() ; i++){
                if(s == Integer.parseInt("20" + list.get(i).getLop().substring(1,3))){
                    System.out.println(list.get(i));
                }
            }
        }
        sc.close();
    }
}
