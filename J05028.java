import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>  {
    
    public String ma,ten;
    public Integer soLuong;

    public danhSach(String ma, String ten, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
    }
    
    @Override
    public int compareTo(danhSach o){
        if(this.soLuong.compareTo(o.soLuong) == 0){
            return this.ma.compareTo(o.ma);
        }
        return -this.soLuong.compareTo(o.soLuong);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soLuong;
    }
    
    
}
public class J05028 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while (t-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ma,ten,soLuong));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
