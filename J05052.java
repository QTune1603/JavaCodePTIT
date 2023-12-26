import java.util.ArrayList;
import java.util.Scanner;

class anyone38 {
    private String Product, idProduct;
    private int donGia, soLuongNhap;

    public anyone38(String Product, String idProduct, int donGia, int soLuongNhap) {
        this.Product = Product;
        this.idProduct = idProduct;
        this.donGia = donGia;
        this.soLuongNhap = soLuongNhap;
    }

    public String stt () {
        return this.idProduct.substring(1,4);
    }

    public int giamGia() {
        if (this.idProduct.charAt(4) == '1')
            return (int) (this.donGia * this.soLuongNhap * 0.5);
        return (int) (this.donGia * this.soLuongNhap * 0.3);
    }

    public int thanhTien() {
        return this.donGia * this.soLuongNhap - this.giamGia();
    }

    @Override
    public String toString() {
        return this.Product + " " + this.idProduct + " " + this.stt() + " " + this.giamGia() + " " + this.thanhTien();
    }
}
public class J05053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<anyone38> list = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String Product = scanner.nextLine();
            String idProduct = scanner.nextLine();
            int donGia = scanner.nextInt();
            int soLuongNhap = scanner.nextInt();
            scanner.nextLine();
            list.add(new anyone38(Product, idProduct, donGia, soLuongNhap));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        scanner.close();
    }
}
