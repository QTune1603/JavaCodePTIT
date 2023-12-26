import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class monHoc {
    private String Ma, Ten;

    public monHoc (String line) {
        String[] words = line.split("\\s+");
        this.Ma = words[0];
        this.Ten = words[1];
    }

    public String getMa() {
        return Ma;
    }
}

class giaoVien {
    private String Ma, Ten;
    private double gioChuan;
    public giaoVien (String line) {
        String[] words = line.split("\\s+");
        this.Ma = words[0];
        this.Ten = line.substring(words[0].length() + 1);
        this.gioChuan = 0;
    }

    public void setGioChuan(double gioChuan) {
        this.gioChuan += gioChuan;
    }

    public String getMa() {
        return Ma;
    }

    public String getTen() {
        return Ten;
    }

    @Override
    public String toString() {
        return Ten + " " + String.format("%.2f", gioChuan);
    }
}


class gioChuan {
    private giaoVien giaoVien;
    private monHoc monHoc;
    private double Time;
    public gioChuan(giaoVien giaoVien, monHoc monHoc,double time) {

        this.giaoVien = giaoVien;
        this.monHoc = monHoc;
        Time = time;
    }

    public void setGiaoVien(giaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }



    public void setMonHoc(monHoc monHoc) {
        this.monHoc = monHoc;
    }

    @Override
    public String toString() {
        return giaoVien.getTen() + " " + String.format("%.2f", Time);
    }
}
public class J07028 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("GIANGVIEN.in"));
        Scanner sc3 = new Scanner(new File("GIOCHUAN.in"));

        int n = sc1.nextInt();
        Map<String, monHoc> map1 = new HashMap<>();
        sc1.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc1.nextLine();
            monHoc x = new monHoc(line);
            map1.put(x.getMa(), x);
        }

        int m = sc2.nextInt();

        Map<String, giaoVien> map2 = new LinkedHashMap<>();

        sc2.nextLine();

        for (int i = 0; i < m; i++) {
            String line = sc2.nextLine();
            giaoVien y = new giaoVien(line);
            map2.put(y.getMa(), y);
        }

        int q = sc3.nextInt();
//        ArrayList<gioChuan>
        sc3.nextLine();
        for (int i = 0; i < q; i++) {
            String line = sc3.nextLine();
            String[] words = line.split("\\s+");
            gioChuan x = new gioChuan( map2.get(words[0]), map1.get(words[1]), Double.parseDouble(words[2]));
            map2.get(words[0]).setGioChuan(Double.parseDouble(words[2]));


        }

        for(String ma: map2.keySet() ){
            System.out.println(map2.get(ma));
        }
        
    }
}
