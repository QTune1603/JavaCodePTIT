import java.util.ArrayList;
import java.util.Scanner;

class anyone47 {
    private String id;
    private long amount;

    public anyone47 (String line) {
        String [] words = line.split("\\s+");
        this.id = words[0];
        this.amount = Long.parseLong(words[1]);
    }

    public String tenHang() {
        int l = id.length();
        if (id.substring(l-2,l).equals("BP"))
            return "British Petro";
        else if (id.substring(l-2,l).equals("ES"))
            return "Esso";
        else if (id.substring(l-2,l).equals("SH"))
            return "Shell";
        else if (id.substring(l-2,l).equals("CA"))
            return "Castrol";
        else if (id.substring(l-2,l).equals("MO"))
            return "Mobil";
        return "Trong Nuoc";
    }
    public long donGia() {
        if (id.charAt(0) == 'X')
            return 128000;
        else if (id.charAt(0) == 'D')
            return 11200;
        return 9700;
    }

    public long thue() {
        if (this.tenHang().equals("Trong Nuoc"))
            return 0;
        long tmp = donGia() * amount;
        if (this.donGia() == 128000)
            return (long) (tmp * 0.03);
        else if (this.donGia() == 11200)
            return (long) (tmp * 0.035);
        else
            return (long) (tmp * 0.02);

    }

    public long thanhTien() {
        return donGia() * amount + thue();
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", id, tenHang(), donGia(), thue(), thanhTien());
    }
}

public class J05067 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.nextLine();
        ArrayList<anyone47> list = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            list.add(new anyone47(scanner.nextLine()));
        }

        for (anyone47 anyone47 : list) {
            System.out.println(anyone47);
        }
        scanner.close();
    }
}
