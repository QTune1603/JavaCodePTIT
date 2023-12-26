import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class anyone68 implements Comparable<anyone68> {
    private static int id = 1;
    private int idKh;
    private String name, gender;
    private Date dob;
    private String addr;

    public anyone68(String name, String gender, Date dob, String addr) {
        this.idKh = id++;
        this.name = normalizeName(name);
        this.gender = gender;
        this.dob = dob;
        this.addr = addr;
    }

    public String normalizeName(String name) {
        String[] words = name.trim().split("\\s+");
        String res = "";

        for (String word: words) {
            res += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            res += " ";
        }
        return res.trim();
    }

    @Override
    public int compareTo(anyone68 other) {
        return this.dob.compareTo(other.dob);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String birth = sdf.format(dob);
        if (idKh > 9)
            return "KH0" + idKh + " " + name + " " + gender + " " + addr + " " + birth;
        else
            return "KH00" + idKh + " " + name + " " + gender + " " + addr + " " + birth;
    }
}

public class J07025 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));

        ArrayList<anyone68> arrayList = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String gender = sc.nextLine();
            Date dob = sdf.parse(sc.nextLine());
            String addr = sc.nextLine();
            arrayList.add(new anyone68(name, gender,dob, addr));
        }

        Collections.sort(arrayList);

        for (anyone68 tmp: arrayList)
            System.out.println(tmp);
    }
}
