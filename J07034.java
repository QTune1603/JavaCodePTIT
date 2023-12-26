import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    private String maMon,tenMon;
    private int tinChi;

    public danhSach(String maMon, String tenMon, int tinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.tinChi = tinChi;
    }
    
    public String getTenMon(){
        return tenMon;
    }
    
    @Override
    public int compareTo(danhSach p){
        return this.tenMon.compareTo(p.getTenMon());
    }
    
    @Override
    public String toString(){
        return maMon + " " + tenMon + " " + tinChi; 
    }
    
}
public class J07034 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String maMon = sc.nextLine();
            String tenMon = sc.nextLine();
            int tinChi = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(maMon,tenMon,tinChi));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
    }
}
