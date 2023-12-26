import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    String id,ngayThi,gioThi;
    Long ma;
    
    public static int cnt = 1;
    
    public danhSach(String ngayThi, String gioThi, long ma) {
        this.id = "C" + String.format("%03d",cnt++);
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.ma = ma;
    }
    
    

    public int compareTo(danhSach o){
        if(this.ngayThi.compareTo(o.ngayThi) == 0){
            if(this.gioThi.compareTo(o.gioThi) == 0){
                return this.id.compareTo(o.id);
            }
            else return this.gioThi.compareTo(o.gioThi);
        }
        return this.ngayThi.compareTo(o.ngayThi);
    }
    
    @Override
    public String toString() {
        return  id + " " + ngayThi + " " + gioThi + " " + ma;
    }
    
    
}

public class J07059 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ngayThi = sc.nextLine();
            String gioThi = sc.nextLine();
            long ma = Long.parseLong(sc.nextLine());
            list.add(new danhSach(ngayThi,gioThi,ma));
        }
        Collections.sort(list);
        for(danhSach i:list){
            System.out.println(i);
        }
    }
}
