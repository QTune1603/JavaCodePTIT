import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    public static int cnt = 1;
    private String id;
    public String ten,chucVu;
    private long luongCoBan,soNgayCong;

    public danhSach(String ten, String chucVu, long luongCoBan, long soNgayCong) {
        this.id = "NV" + String.format("%02d",cnt++);
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
        
    }
    
    public Long getLuongChinh(){
        return soNgayCong * luongCoBan;
    }
    
    public long getPhuCap(){
        if(chucVu.equals("GD")){
            return 500;
        }
        if(chucVu.equals("PGD")){
            return 400;
        }
        if(chucVu.equals("TP")){
            return 300;
        }
        if(chucVu.equals("KT")){
            return 250;
        }
        return 100;
    }
    public String getChucVu(){
        return chucVu;
    }
    
    public long getTamUng(){
        double res = (getPhuCap() + getLuongChinh()) ;
        if(res * 2/3 > 25000){
            return 25000;
        }
        else return (int) lamTron(res * 2/3,-3);
    }
    
    public double lamTron(double x, int y){
        double k = Math.pow(10,y);
        return Math.round(x * k) / k;
    }
    
    public long getConLai(){
        return getLuongChinh() - getTamUng() + getPhuCap();
    }
    
    public Long getTongLuong(){
        return getLuongChinh() + getPhuCap();
    }

    @Override
    public String toString() {
        return id + " " + ten + " " + getPhuCap() + " " + getLuongChinh() + " " + getTamUng() + " " + getConLai();
    }
    
    @Override
    public int compareTo(danhSach o){
        if(this.getTongLuong() == o.getTongLuong()){
            return this.id.compareTo(o.id);
        }
        return -this.getTongLuong().compareTo(o.getTongLuong());
    }
    
}
public class J05045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            String chucVu = sc.nextLine();
            long luongCoBan = Long.parseLong(sc.nextLine());
            long soNgayCong = Long.parseLong(sc.nextLine());
            list.add(new danhSach(ten,chucVu,luongCoBan,soNgayCong));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
   }
}
