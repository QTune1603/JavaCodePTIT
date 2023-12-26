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

    public String getChucVu() {
        return chucVu;
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

public class J05065 {
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
            String line = sc.nextLine();
            String chucVu = line.substring(0, 2);

            arr.add(new anyone79(line));
            if (chucVu.equals("GD")) {
                if (Gd >= 1) {
                    arr.get(ind).setChucVu("NV");
                }
                Gd++;
            } else if (chucVu.equals("TP")) {
                if (Tp >= 3) {
                    arr.get(ind).setChucVu("NV");
                }
                Tp++;
            } else if (chucVu.equals("PP")) {
                if (Pp >= 3) {
                    arr.get(ind).setChucVu("NV");
                }
                Pp++;
            }
            ind++;
        }

        Collections.sort(arr);

        int m = sc.nextInt();
        
      

        for (int i = 0; i < m; i++) {
            String chucVu = sc.next();
            for (anyone79 tmp : arr) {
                if (tmp.getChucVu().equals(chucVu)) {
                    System.out.println(tmp);
                }
            }
            System.out.println("");

        }
        sc.close();
    }
}
