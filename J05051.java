import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone37 implements Comparable<anyone37> {

    private static int id = 1;

    private int idKH;
    private String typeName;
    private int soCu;
    private int soMoi;

    public anyone37(String typeName, int soCu, int soMoi) {
        this.idKH = id++;
        this.typeName = typeName;
        this.soCu = soCu;
        this.soMoi = soMoi;
    }

    public int soDien() {
        return this.soMoi - this.soCu;
    }

    public int heSo() {
        if (this.typeName.equals("KD"))
            return 3;
        else if (this.typeName.equals("NN"))
            return 5;
        else if (this.typeName.equals("TT"))
            return 4;
        else
            return 2;
    }

    public int thanhTien() {
        return this.soDien() * this.heSo() * 550;
    }

    public double roundToDecimalPlaces(double number, int decimalPlaces) {
        double multiplier = Math.pow(10, decimalPlaces);
        return Math.round(number * multiplier) / multiplier;
    }


    public int phuTroi() {
        if (this.soDien() < 50)
            return 0;
        else if (this.soDien() <= 100)
            return Math.round(this.thanhTien() * 0.35f);
        else
            return this.thanhTien();
    }

    public int tongTien () {
        return this.thanhTien() + this.phuTroi();
    }

    public int compareTo (anyone37 other) {
        return other.tongTien() - this.tongTien();
    }

    @Override
    public String toString() {
        if (idKH < 10)
            return "KH0" + idKH + " " + heSo() + " " + thanhTien() + " " + phuTroi() + " " + tongTien();
        else
            return "KH" + idKH + " " + heSo() + " " + thanhTien() + " " + phuTroi() + " "+  tongTien();
    }
}
public class J05051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<anyone37> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String typeName = scanner.next();
            int soCu = scanner.nextInt();
            int soMoi = scanner.nextInt();
            list.add(new anyone37(typeName, soCu, soMoi));
        }

        Collections.sort(list);
        for (anyone37 i : list) {
            System.out.println(i);
        }
        scanner.close();
    }
}
