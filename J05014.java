import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class giaoVien implements Comparable<giaoVien>{
    private static int id = 1;
    private int idGv;
    String name, maXetTuyen;
    double  sub1, sub2, mark;
    String sub;
    String res;

    public giaoVien (String name, String maXetTuyen, double sub1, double sub2) {
        this.idGv = id++;
        this.name = name;
        this.maXetTuyen = maXetTuyen;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.res = Result();
        if(this.maXetTuyen.contains("A"))
            this.sub = "TOAN";
        else if (this.maXetTuyen.contains("B"))
            this.sub = "LY";
        else
            this.sub = "HOA";
    }


    public String Result() {
        Double diem = sub1 * 2 + sub2;
        if (this.maXetTuyen.contains("1"))
            diem += 2;
        else if (this.maXetTuyen.contains("2"))
            diem += 1.5;
        else if (this.maXetTuyen.contains("3"))
            diem += 1;

        this.mark = diem;
        if (diem >= 18)
            return String.format("%.1f TRUNG TUYEN", diem);
        else
            return String.format("%.1f LOAI", diem);
    }

    public int compareTo(giaoVien other) {
        if (this.mark > other.mark)
            return -1;
        else if (this.mark < other.mark)
            return 1;
        else {
            if (this.idGv > other.idGv)
                return 1;
            else
                return -1;
        }
    }

    @Override
    public String toString() {
        if (this.idGv >= 10)
            return "GV" + this.idGv + " " + this.name + " " + this.sub + " " + Result();
        else
            return "GV0" + this.idGv + " " + this.name + " " + this.sub + " " + Result();
    }
}
public class J05014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<giaoVien> giaoViens = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
                String name = sc.nextLine();
                String maXetTuyen = sc.next();
                double sub1 = sc.nextDouble();
                double sub2 = sc.nextDouble();
                sc.nextLine();
                giaoViens.add(new giaoVien(name, maXetTuyen, sub1, sub2));
        }
        Collections.sort(giaoViens);

        for (giaoVien x : giaoViens) {
            System.out.println(x);
        }
        sc.close();
    }
}
