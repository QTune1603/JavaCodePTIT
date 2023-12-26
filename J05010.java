import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    public String ten,nhom;
    public double giaMua,giaBan;
    public Double loiNhuan;
    public static int cnt = 1;
    public int id;
    
    public danhSach(String ten, String nhom, double giaMua, double giaBan) {
        this.id = cnt++;
        this.ten = ten;
        this.nhom = nhom;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        
        this.loiNhuan = giaBan-giaMua;
    }
    
    @Override
    public int compareTo(danhSach o){
        return o.loiNhuan.compareTo(this.loiNhuan);
    } 

    @Override
    public String toString() {
        return id + " " + ten + " " + nhom + " " + String.format("%.2f",loiNhuan);
    }
    
    
    
}
public class J05010 {
    public static void main(String[] args) throws FileNotFoundException, ParseException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            double giaMua = Double.parseDouble(sc.nextLine());
            double giaBan = Double.parseDouble(sc.nextLine());
            list.add(new danhSach(ten,nhom,giaMua,giaBan));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
