import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>  {
    
    public static int stt = 1;
    public int id;
    public String ma,ten,lop,email,doanhNghiep;

    public danhSach(String ma, String ten, String lop, String email, String doanhNghiep) {
        this.id = stt++;
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        this.doanhNghiep = doanhNghiep;
    }

    @Override
    public int compareTo(danhSach o){
        return this.ma.compareTo(o.ma);
    }

    @Override
    public String toString() {
        return  id + " " + ma + " " + ten + " " + lop + " " + email + " " + doanhNghiep ;
    }
    
    
}
public class J05035 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while (t-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            String doanhNghiep = sc.nextLine();
            list.add(new danhSach(ma,ten,lop,email,doanhNghiep));
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String s = sc.nextLine();
            Collections.sort(list);
            for(int i = 0 ; i < list.size() ; i++){
                if(s.equals(list.get(i).doanhNghiep)){
                    System.out.println(list.get(i));
                }
            }
        }
        sc.close();
    }
}
