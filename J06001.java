import java.util.ArrayList;
import java.util.Scanner;

class anyone83 {

    private String Ma, Ten;
    private int Gia1, Gia2;

    public anyone83(String Ma, String Ten, int Gia1, int Gia2) {
        this.Ma = Ma;
        this.Ten = Ten;
        this.Gia1 = Gia1;
        this.Gia2 = Gia2;
    }

    public String getMa() {
        return Ma;
    }

    public String getTen() {
        return Ten;
    }

    public int getGia1() {
        return Gia1;
    }

    public int getGia2() {
        return Gia2;
    }

}

class anyone84 {

    private static int id = 1;
    private String Ma, Ten;
    private int soLuong;
    private int giamGia, tongTien;

    public anyone84(String Ma, int soLuong) {
        this.Ma = Ma + (id > 99 ? "" : id > 9 ? "-0" : "-00") + String.valueOf(id);
        id++;
        this.soLuong = soLuong;
    }

    public String getMa() {
        return Ma;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getGiamGia() {
        return giamGia;
    }

    @Override
    public String toString() {
        return Ma + " " + Ten + " " + giamGia + " " + tongTien;
    }
}
public class J06001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<anyone83> sanPham = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String Ma = sc.next();
            sc.nextLine();
            String Name = sc.nextLine();
            int Gia1 = sc.nextInt();
            int Gia2 = sc.nextInt();

            sanPham.add(new anyone83(Ma, Name, Gia1, Gia2));
        }

        int m = sc.nextInt();
        ArrayList<anyone84> hoaDon = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String Ma = sc.next();
            int soLuong = sc.nextInt();

            hoaDon.add(new anyone84(Ma, soLuong));
        }

        for (anyone84 x : hoaDon) {
            for (anyone83 y : sanPham) {
                if (x.getMa().substring(0, 2).equals(y.getMa())) {
                    x.setTen(y.getTen());
                    double giamGia = x.getSoLuong() >= 150 ? 0.5 : x.getSoLuong() >= 100 ? 0.3 : x.getSoLuong() >= 50 ? 0.15 : 0;
                    double thanhTien = x.getSoLuong() * (x.getMa().charAt(2) == '1' ? y.getGia1() : y.getGia2());

                    x.setGiamGia((int) (giamGia * thanhTien));
                    x.setTongTien((int) (thanhTien - x.getGiamGia()));

                }

            }
        }
        
        for(anyone84 tmp: hoaDon) {
            System.out.println(tmp);
        }
        sc.close();
    }
}
