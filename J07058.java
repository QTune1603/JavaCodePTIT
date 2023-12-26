import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSachMonThi implements Comparable<danhSachMonThi>{
    private String maMon,tenMon,hinhThuc;

    public danhSachMonThi(String maMon, String tenMon, String hinhThuc) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThuc = hinhThuc;
    }

    @Override
    public int compareTo(danhSachMonThi p){
        return this.maMon.compareTo(p.maMon);
    }
    
    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + hinhThuc;
    }
    
    
}
public class J07058 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSachMonThi> list = new ArrayList<>();
        while(t-- > 0){
            String maMon = sc.nextLine();
            String tenMon = sc.nextLine();
            String hinhThuc = sc.nextLine();
            list.add(new danhSachMonThi(maMon,tenMon,hinhThuc));
        }
        Collections.sort(list);
        for(danhSachMonThi x : list){
            System.out.println(x);
        }
    }
}
