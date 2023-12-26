import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

class danhSach{
    public String ma,ten,lop,email;

    public danhSach(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    

    @Override
    public String toString() {
        return  ma + " " + ten + " " + lop + " " + email;
    }
    
    
}
public class J05022 {
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
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + s + ":");
            for(int i = 0 ; i < list.size() ; i++){
                if(s.equals(list.get(i).getLop())){
                    System.out.println(list.get(i));
                }
            }
        }
        sc.close();
    }
}
