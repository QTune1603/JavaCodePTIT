import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class danhSach implements Comparable<danhSach>{
    private String ten;
    private int ma;
    private Long soLuong,donGia;
    
    private static Map<String,Integer> map = new HashMap<>();

    public danhSach(String ten, Long soLuong, Long donGia) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
        String id = chuanHoa(ten);
        if(map.containsKey(id)){
            map.put(id,map.get(id) + 1);
        }
        else {
            map.put(id,1);
        }
        this.ma = map.get(id);
    }
    
    public String chuanHoa(String s){
        String a[] = s.trim().split("\\s+");
        String x = a[0].charAt(0) + "" + a[1].charAt(0);
        return x.toUpperCase();
    }
    
    public long chietKhau(){
        long res = this.donGia * this.soLuong;
        if(this.soLuong > 10){
            return (int)(res * 0.05);
        }
        else if(this.soLuong >= 8){
            return (int)(res * 0.02);
        }
        else if(this.soLuong >= 5){
            return (int)(res * 0.01);
        }
        else return 0;
    }
    
    public long getThanhTien(){
        return donGia * soLuong - chietKhau();
    }

    
    @Override
    public int compareTo(danhSach o){
        return (int)(o.chietKhau() - this.chietKhau());
    }
    
    @Override
    public String toString() {
        String id = chuanHoa(ten);
        return id + "0" + ma + " " + ten + " " + this.chietKhau() + " " + getThanhTien();
    }
    
    
    
}
public class J05047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ten = sc.nextLine();
            long soLuong = Long.parseLong(sc.nextLine());
            long donGia = Long.parseLong(sc.nextLine());
            list.add(new danhSach(ten,soLuong,donGia));
        }
        Collections.sort(list);
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
   }
}
