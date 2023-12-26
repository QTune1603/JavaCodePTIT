import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class danhSach1 implements Comparable<danhSach1> {
    String ma, ten;
    Long giaBan;
    Integer thoiHan;

    danhSach1(String ma, String ten, long giaBan, int thoiHan) {
        this.ma = ma;
        this.ten = ten;
        this.giaBan = giaBan;
        this.thoiHan = thoiHan;
    }

    @Override
    public int compareTo(danhSach1 o) {
        if (!this.ten.equals(o.ten))
            return o.ten.compareTo(this.ten);
        return this.ma.compareTo(o.ma);
    }

    @Override
    public String toString() {
        return ma;
    }
}

class danhSach2 implements Comparable<danhSach2> {
    String id, tenKhachHang, diaChi, maSp;
    Long soLuong;
    Date ngayMua;

    danhSach2(int id, String tenKhachHang, String diaChi, String maSp, long soLuong, Date ngayMua) {
        this.id = "KH" + (id < 10 ? "0" : "") + id;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.maSp = maSp;
        this.soLuong = soLuong;
        this.ngayMua = ngayMua;
    }

    @Override
    public int compareTo(danhSach2 o) {
        return this.ngayMua.compareTo(o.ngayMua);
    }
    // @Override
    // public String toString() {
    // return id + " " + tenKhachHang + " " + diaChi + " " + maSp + " " +
    // String.format("%.2f", soLuong);
    // }
}

public class J07049 {
    public static void main(String args[])
            throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File("MUAHANG.in"));

        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        ArrayList<danhSach1> list1 = new ArrayList<>();
        while (t-- > 0) {
            String ma = scanner.nextLine();
            String ten = scanner.nextLine();
            long giaBan = Long.parseLong(scanner.nextLine());
            int thoiHan = Integer.parseInt(scanner.nextLine());
            list1.add(new danhSach1(ma, ten, giaBan, thoiHan));
        }

        t = Integer.parseInt(scanner.nextLine());
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<danhSach2> list2 = new ArrayList<>();
        while (t-- > 0) {
            String khach = scanner.nextLine();
            String diaChi = scanner.nextLine();
            String maSp = scanner.nextLine();
            long soLuongMua = Long.parseLong(scanner.nextLine());
            Date ngayMua = s.parse(scanner.nextLine()), h = ngayMua;
            long m = soLuongMua;
            for (danhSach1 i : list1)
                if (i.ma.equals(maSp)) {
                    m *= i.giaBan;
                    Calendar x = Calendar.getInstance();
                    x.setTime(ngayMua);
                    x.add(Calendar.MONTH, i.thoiHan);
                    h = x.getTime();
                }
            list2.add(new danhSach2(++num, khach, diaChi, maSp, m, h));
        }
        Collections.sort(list2);
        for (danhSach2 i : list2)
            System.out.println(i.id + " " + i.tenKhachHang + " " + i.diaChi + " " + i.maSp + " " + i.soLuong + " "
                    + s.format(i.ngayMua));
    }
}
