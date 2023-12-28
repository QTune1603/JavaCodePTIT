import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class A implements Comparable<A> {
    String id, name;
    double toan, ly, hoa, bonus, mark;

    public A(String id, String name, double toan, double ly, double hoa) {
        this.id = id;
        this.name = name;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.bonus = (id.charAt(2) == '1' ? 0.5 : id.charAt(2) == '2' ? 1 : id.charAt(2) == '3' ? 2.5 : 0);
        this.mark = bonus + toan * 2 + ly + hoa;
    }
    @Override 
    public int compareTo(A a) {
        if (this.mark != a.mark) return Double.compare(a.mark, this.mark);
        return this.id.compareTo(a.id);
    }
    @Override
    public String toString() {
        return id + " " + name + " " + new DecimalFormat().format(bonus) + " " + new DecimalFormat().format(mark);
    }
}

public class J05058 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ArrayList<A> a = new ArrayList<>();
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String id = scanner.nextLine();
            String name = scanner.nextLine();
            double toan = Double.parseDouble(scanner.nextLine());
            double ly = Double.parseDouble(scanner.nextLine());
            double hoa = Double.parseDouble(scanner.nextLine());
            a.add(new A(id, name, toan, ly, hoa));
        }
        Collections.sort(a);
        for (A i : a) {
            if (i.mark >= 24) {
                System.out.println(i + " TRUNG TUYEN");
            }
            else System.out.println(i + " TRUOT");
        }
        scanner.close();
    }
}
