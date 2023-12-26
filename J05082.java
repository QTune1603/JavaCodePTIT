import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class anyone63 implements  Comparable<anyone63> {
    private static int i = 1;
    private String name;
    private int id;
    private String gender;
    private Date dob;
    private String birth;
    private String address;

    public anyone63(String name, String gender, String dob, String address) throws ParseException {
        this.id = i++;
        this.name = normalizeName(name);
        this.gender = gender;
        this.birth = normalizeDate(dob);
        this.dob = getDob();
        this.address = address;
    }

    public Date getDob() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.parse(birth);
    }
    public String normalizeName(String x) {
        String[] words = x.trim().split("\\s+");
        String res = "";
        for (int i = 0; i < words.length; i++) {
            res += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            if (i != words.length - 1)
                res += " ";
        }
        return res;
    }

    public String  normalizeDate(String dob) {
        StringBuilder sb = new StringBuilder(dob);
        if (sb.charAt(1) == '/')
            sb.insert(0, '0');
        if (sb.charAt(4) == '/')
            sb.insert(3, '0');
        return sb.toString();
    }
    @Override
    public int compareTo(anyone63 other) {
        return this.dob.compareTo(other.dob);
    }

    @Override
    public String toString() {
        if (id > 9)
            return "KH0" + id + " " + name + " " + gender + " " + address + " " + birth;
        else
            return "KH00" + id + " " + name + " " + gender + " " +  address + " " + birth;
    }
}
public class J05082 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<anyone63> arr = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String gender = scanner.next();
            String dob = scanner.next();
            scanner.nextLine();
            String addr = scanner.nextLine();
            arr.add(new anyone63(name, gender, dob, addr));
        }

        Collections.sort(arr);

        for (anyone63 x : arr) {
            System.out.println(x);
        }
        scanner.close();
    }
}
