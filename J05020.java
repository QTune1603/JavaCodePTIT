import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    public String ma,ten,lop,email;

    public danhSach(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }
    
    @Override
    public int compareTo(danhSach o){
        if(this.lop.compareTo(o.lop) == 0){
            return this.ma.compareTo(o.ma);
        }
        return this.lop.compareTo(o.lop);
    }

    @Override
    public String toString() {
        return  ma + " " + ten + " " + lop + " " + email;
    }
    
    
}

public class J05020 {
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
        Collections.sort(list);
        for(danhSach x : list){
            System.out.println(x);
        }
        sc.close();
    }
}
