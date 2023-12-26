import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class anyone67 {
    private static int id = 1;
    private int idSv;
    private String name, idClass;
    private Date dob;
    private double gpa;

    public anyone67(String name, String idClass, Date date, double gpa) {
        this.idSv = id++;
        this.name = normalizeName(name);
        this.idClass = idClass;
        this.dob = date;
        this.gpa = gpa;
    }

    public String normalizeName(String name) {
        String res = "";
        String[] words = name.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            res += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            res += " ";
        }
        return res.trim();
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (idSv > 9)
            return "B20DCCN0" + idSv + " " + name + " " + idClass + " " + sdf.format(dob) + " " + String.format("%.2f", gpa);
        return "B20DCCN00" + idSv + " " + name + " " + idClass + " " + sdf.format(dob) + " " + String.format("%.2f", gpa);


    }

}
public class J07018 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<anyone67> arrayList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            String idClass = sc.next();
            Date dob = sdf.parse(sc.next());
            Double gpa = sc.nextDouble();
            arrayList.add(new anyone67(name, idClass, dob, gpa));
        }

        for (anyone67 tmp : arrayList) {
            System.out.println(tmp);
        }

    }
}
