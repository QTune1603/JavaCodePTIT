import java.util.ArrayList;
import java.util.Scanner;

class danhSach {
    private String name;
    private int soLuongNhap;
    public danhSach(String name, int soLuongNhap) {
        this.name = name;
        this.soLuongNhap = soLuongNhap;
    }

    public int soLuongXuat() {
        if (name.charAt(0) == 'A')
            return (int) roundToDecimalPlaces(this.soLuongNhap * 0.6, 0);
        else
            return (int) roundToDecimalPlaces(this.soLuongNhap * 0.7, 0);
    }

    public int donGia() {
        if (name.charAt(name.length() - 1) == 'Y') {
            return 110000;
        }
        return 135000;
    }

    public double roundToDecimalPlaces(double number, int decimalPlaces) {
        double multiplier = Math.pow(10, decimalPlaces);
        return Math.round(number * multiplier) / multiplier;
    }

    public int Tien() {
        return this.soLuongXuat() * this.donGia();
    }

    public int Thue() {
        double tax = 0;
        if (name.charAt(0) == 'A' && name.charAt(name.length() - 1) == 'Y') {
            tax = 0.08;
        } else if (name.charAt(0) == 'A' && name.charAt(name.length() - 1) == 'N') {
            tax = 0.11;
        } else if (name.charAt(0) == 'B' && name.charAt(name.length() - 1) == 'Y') {
            tax = 0.17;
        } else
            tax = 0.22;

        return (int)roundToDecimalPlaces(this.Tien() * tax, 0);
    }

    @Override
    public String toString() {
        return name + " " + soLuongNhap + " " + soLuongXuat() + " " + donGia() + " " + Tien() + " " + Thue();
    }

}

public class J05049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while(t-- > 0){
            String ma = sc.nextLine();
            int soLuongNhap = Integer.parseInt(sc.nextLine());
            list.add(new danhSach(ma,soLuongNhap));
        }
        for(danhSach x:list){
            System.out.println(x);
        }
        sc.close();
   }
}
