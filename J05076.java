import java.util.ArrayList;
import java.util.Scanner;

interface anyone59 {
    public void nhap();

}

class anyone58<T> implements anyone59 {
    T ma, ten, loai;

    public anyone58 (T ma, T ten, T loai) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
    }

    public T getMa() {
        return ma;
    }

    public T getTen() {
        return ten;
    }

    public T getLoai() {
        return loai;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        this.ma = (T) scanner.nextLine();
        this.ten = (T) scanner.nextLine();
        this.loai = (T) scanner.nextLine();
        scanner.close();
    }
}

class anyone60<T, V> extends anyone58 {
    T quantityImport, quantityExport, price;

    public anyone60(V ma, V ten, V loai, T quantityImport, T price, T quantityExport) {
        super(ma, ten, loai);
        this.quantityImport = quantityImport;
        this.price = price;
        this.quantityExport = quantityExport;
    }

    public Integer sumImport() {
        return (Integer) this.quantityImport * (Integer) this.price;
    }

    public Integer sumExport() {
        if (super.loai.equals("A")) {
            return (int) ((Integer)this.quantityExport * (Integer) this.price * 1.08);
        } else if (super.loai.equals("B")) {
            return (int) ((Integer)this.quantityExport * (Integer) this.price * 1.05);
        } else
            return (int) ((Integer)this.quantityExport * (Integer) this.price * 1.02);
    }

    @Override
    public String toString() {
        return super.ma + " " + super.ten + " " + this.sumImport() + " " + this.sumExport();
    }

}
public class J05076 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<anyone58<String>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
//            anyone58<String> a = new anyone58<>("", "", "");
//
//            a.nhap();
//            list.add(a);
            String ma = scanner.nextLine();
            String ten = scanner.nextLine();
            String loai = scanner.nextLine();
            list.add(new anyone58<String>(ma, ten, loai));
        }

        int m = scanner.nextInt();
        scanner.nextLine();
        ArrayList<anyone60<Integer, String>> list2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            String[] tmp = line.split("\\s+");
            for (anyone58<String> x : list) {
                if (x.getMa().equals(tmp[0])) {
                    anyone60<Integer, String> y = new anyone60<Integer, String>(x.getMa(), x.getTen(), x.getLoai(), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
                    list2.add(y);
                }
            }
        }
        for (anyone60<Integer, String> x : list2) {
            System.out.println(x);
        }
        scanner.close();
    }
}
