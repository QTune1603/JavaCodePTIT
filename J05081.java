import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    private String ma,ten,donVi;
    private int giaMua,giaBan;
    private int loiNhuan;
    public static int cnt = 1;

    public danhSach( String ten, String donVi, int giaMua, int giaBan) {
        this.ma = "MH" + String.format("%03d",cnt++);
        this.ten = ten;
        this.donVi = donVi;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        
        this.loiNhuan = giaBan - giaMua;
    }

    @Override
    public int compareTo(danhSach p){
        return -(this.loiNhuan - (p.loiNhuan));
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + giaMua + " " + giaBan + " " + loiNhuan;
    }
    
    
}
public class J05081 {
    public static void main(String[] args) throws FileNotFoundException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String donVi = sc.nextLine();
            int giaMua = Integer.parseInt(sc.nextLine());
            int giaBan = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ten,donVi,giaMua,giaBan));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
