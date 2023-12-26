import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone79 implements Comparable<anyone79> {

    private String chucVu, heSoLuong, soHieuNhanVien;
    private String Name;

    public anyone79(String line) {
        this.chucVu = line.substring(0, 2);
        this.heSoLuong = line.substring(2, 4);
        this.soHieuNhanVien = line.substring(4, 7);
        this.Name = line.substring(8);
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getName() {
        return Name;
    }

    
    @Override
    public int compareTo(anyone79 other) {
        if (!this.heSoLuong.equals(other.heSoLuong)) {
            return other.heSoLuong.compareTo(this.heSoLuong);
        }
        return this.soHieuNhanVien.compareTo(other.soHieuNhanVien);
    }

    @Override
    public String toString() {
        return Name + " " + chucVu + " " + soHieuNhanVien + " " + heSoLuong;
    }
}
public class J05066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<anyone79> arr = new ArrayList<>();

        int Gd = 0;
        int Tp = 0;
        int Pp = 0;

        int ind = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String chucVu = line.substring(0, 2);
            String soHieuNhanVien = line.substring(4, 7);
            arr.add(new anyone79(line));
            if (chucVu.equals("GD") && Integer.parseInt(soHieuNhanVien) > 1) {
               
                    arr.get(ind).setChucVu("NV");
                
            } else if (chucVu.equals("TP") && Integer.parseInt(soHieuNhanVien) > 3) {
                    arr.get(ind).setChucVu("NV");
            } else if (chucVu.equals("PP") && Integer.parseInt(soHieuNhanVien) > 3) {               
                    arr.get(ind).setChucVu("NV");
            }
            ind++;
        }

        Collections.sort(arr);

        int m = sc.nextInt();
        
      
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String key = sc.nextLine();
            for (anyone79 tmp : arr) {
                if (tmp.getName().toLowerCase().contains(key.toLowerCase())) {
                    System.out.println(tmp);
                }
            }
            System.out.println("");

        }
        sc.close();
    }
}
