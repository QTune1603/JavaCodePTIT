import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class ksan implements Comparable<ksan> {
    private static int id = 1;
    private String maKh;
    private String Ten, maPhong;
    private Date d1, d2;

    private int dV;

    private int soNgay, thanhTien;

    public ksan(String ten, String maPhong, Date d1, Date d2, int dV) {
        this.maKh = String.format("KH%02d", id++);
        this.Ten = ten.trim();
        this.maPhong = maPhong.trim();
        this.d1 = d1;
        this.d2 = d2;
        this.dV = dV;
        this.soNgay = findSoNgay();
        this.thanhTien = findThanhTien();
    }

    public int findSoNgay() {
        long diff = (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
        return (int) diff + 1;
    }

    public int findThanhTien() {
        int res = 0;
        char c = maPhong.charAt(0);
        res = c == '1'? 25 : c == '2' ? 34 : c == '3' ? 50 : 80;
        res *= soNgay;
        res += dV;
        return res;
    }
    @Override
    public int compareTo (ksan other) {
        return other.thanhTien - this.thanhTien;
    }
    @Override
    public String toString() {
        return maKh + " " + Ten + " " + maPhong + " " + soNgay + " " + thanhTien;
    }
}
public class J05016 {
    public static void main(String[] args) throws  Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<ksan> arr = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String a = sc.nextLine();
            String b = sc.next();
            sc.nextLine();
            Date c = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine().trim());
            Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine().trim());
            int e = sc.nextInt();

            arr.add(new ksan(a, b, c, d, e));
        }

        Collections.sort(arr);

        for (ksan x: arr) {
            System.out.println(x);
        }
        sc.close();
    }
}
