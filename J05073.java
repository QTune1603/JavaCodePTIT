import java.util.ArrayList;
import java.util.Scanner;

class anyone82 {
    private String Ma;
    private long donGia, soLuong;
    private double tongGia;
    public anyone82 (String line) {
        String[] words = line.split("\\s+");
        this.Ma = words[0];
        this.donGia = Integer.parseInt(words[1]);
        this.soLuong = Integer.parseInt(words[2]);
        this.tongGia = findTongGia();
    }
    
    public double findTongGia() {
        double thue, giaShip;
        char maDau = Ma.charAt(0);
        char maCuoi = Ma.charAt(Ma.length() - 1);
       
        thue = maDau == 'T' ? 0.29 : maDau == 'C' ? 0.1 : maDau == 'D' ? 0.08 : 0.02;
        giaShip =  maDau == 'T' ? 0.04 : maDau == 'C' ? 0.03 : maDau == 'D' ? 0.025 : 0.005;
        
        
        thue = thue * donGia * soLuong;
        giaShip = giaShip * donGia * soLuong;
        
        thue = maCuoi == 'C' ? thue * 0.95 : thue;
        
        
        return ((double) (donGia * soLuong) + thue + giaShip) * 1.2 / (double) soLuong;
    }
    
    @Override
    public String toString () {
        return Ma + " " + String.format("%.2f", tongGia);
    }
}
public class J05073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<anyone82> arr = new ArrayList<>();
        sc.nextLine();
        for (int i=0;i<n;i++) {
            String line = sc.nextLine();
            arr.add(new anyone82(line));
        }
        
        for(anyone82 tmp: arr) {
            System.out.println(tmp);
        }
        sc.close();
    }
}
