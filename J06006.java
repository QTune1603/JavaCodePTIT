import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone85 {

    private static int id = 1;
    private String Ma, Ten, gioiTinh, ngaySinh, diaChi;

    public anyone85(String Ten, String gioiTinh, String ngaySinh, String diaChi) {
        this.Ma = "KH" + (id > 99 ? "" : id > 9 ? "0" : "00") + String.valueOf(id++);
        this.Ten = Ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMa() {
        return Ma;
    }

    public String getTen() {
        return Ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

}

class anyone86 {

    private static int id = 1;
    private String Ma, Ten, donViTinh;
    private int giaMua, giaBan;

    public anyone86(String Ten, String donViTinh, int giaMua, int giaBan) {
        this.Ma = "MH" + (id > 99 ? "" : id > 9 ? "0" : "00") + String.valueOf(id++);
        this.Ten = Ten;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMa() {
        return Ma;
    }

    public String getTen() {
        return Ten;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }

}

class anyone87 implements Comparable<anyone87> {

    private static int id = 1;
    private String Ma, maKh, maSp;
    private int soLuong;
    private int thanhTien, loiNhuan;

    public anyone87(String maKh, String maSp, int soLuong) {
        this.Ma = "HD" + (id > 99 ? "" : id > 9 ? "0" : "00") + String.valueOf(id++);
        this.maKh = maKh;
        this.maSp = maSp;
        this.soLuong = soLuong;
    }

    public void setLoiNhuan(int loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    public static int getId() {
        return id;
    }

    public String getMa() {
        return Ma;
    }

    public String getMaKh() {
        return maKh;
    }

    public String getMaSp() {
        return maSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public int getLoiNhuan() {
        return loiNhuan;
    }
    
    @Override
    public int compareTo(anyone87 other) {
        return other.loiNhuan - this.loiNhuan;
    }

}

public class J06006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<anyone85> Kh = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String a = sc.nextLine();
            String b = sc.next();
            String c = sc.next();
            sc.nextLine();
            String d = sc.nextLine();

            Kh.add(new anyone85(a, b, c, d));
        }

        int m = sc.nextInt();
        ArrayList<anyone86> Sp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            sc.nextLine();
            String a = sc.nextLine();
            String b = sc.next();
            int c = sc.nextInt();
            int d = sc.nextInt();

            Sp.add(new anyone86(a, b, c, d));
        }

        int p = sc.nextInt();
        ArrayList<anyone87> Hd = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            String a = sc.next();
            String b = sc.next();
            int c = sc.nextInt();

            Hd.add(new anyone87(a, b, c));
        }
        
        for (anyone87 x : Hd) {
            for (anyone86 z : Sp) {
                if (z.getMa().equals(x.getMaSp())) {
                    
                    x.setThanhTien(z.getGiaBan() * x.getSoLuong());
                    x.setLoiNhuan((z.getGiaBan() - z.getGiaMua()) * x.getSoLuong());                   
                }            
            }
        }

        Collections.sort(Hd);
        for (anyone87 x : Hd) {

            System.out.print(x.getMa() + " ");
            for (anyone85 y : Kh) {
                if (y.getMa().equals(x.getMaKh())) {
                    System.out.print(y.getTen() + " " + y.getDiaChi() + " ");
                    break;
                }
            }
            
            int tmp = 0;
            for (anyone86 z : Sp) {
                if (z.getMa().equals(x.getMaSp())) {
                    System.out.print(z.getTen() + " ");
                    tmp = z.getGiaBan();
                    break;
                }
                
            }
            System.out.println(x.getSoLuong() + " " + x.getThanhTien() + " " + x.getLoiNhuan());

        }
        sc.close();
    }
}
