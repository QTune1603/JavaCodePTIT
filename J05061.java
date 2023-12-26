import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone45 implements Comparable<anyone45>{

    private static int id = 1;

    private int IdPH;
    private String Name;

    private int sumMark;

    private int age;
    public anyone45(String name, String dob, double Lit, double Practise) {
        this.IdPH = id++;
        this.Name = normalizeName(name);
        this.age = countAge(dob);
        this.sumMark = countSumMark(Lit, Practise);
    }

    public String normalizeName(String name) {
        String[] words = name.trim().split("\\s+");
        String result = "";
        for (String word : words) {
            result += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return result.trim();
    }

    public int countAge(String dob) {
        String[] words = dob.split("/");
        int year = Integer.parseInt(words[2]);
        return 2021 - year;
    }
    public int countSumMark(double Lit, double Practise) {
        double add = 0;
        if (Lit >= 8.0 && Practise >= 8.0) add = 1;
        else if (Lit >= 7.5 && Practise >= 7.5) add = 0.5;
        double result = (Lit + Practise)/2 + add;
        int ans = (int)Math.round(result);
        if (ans > 10) ans = 10;
        return ans;
    }

    public int compareTo(anyone45 other) {
       if (this.sumMark > other.sumMark)
           return -1;
       else if (this.sumMark < other.sumMark)
           return 1;

       return this.IdPH - other.IdPH;
    }

    @Override
    public String toString() {
        String assessement = "";
        if (sumMark < 5)
            assessement += "Truot";
        else if (sumMark < 7)
            assessement += "Trung binh";
        else if (sumMark < 8)
            assessement += "Kha";
        else if (sumMark < 9)
            assessement += "Gioi";
        else
            assessement += "Xuat sac";
        if (IdPH < 10)
            return "PH0" + IdPH + " " + Name + " " + age + " " + sumMark + " " + assessement;
        else
            return "PH" + IdPH + " " + Name + " " + age + " " + sumMark + " " + assessement;
    }
}
public class J05061 {
    public static void main(String[] args) throws Exception {
//        File file = new File("XETTUYEN.in");
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<anyone45> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String name = scanner.nextLine();
            String dob = scanner.next();
            double Lit = scanner.nextDouble();
            double Practise = scanner.nextDouble();
            anyone45 anyone45 = new anyone45(name, dob, Lit, Practise);
            list.add(anyone45);
        }

        Collections.sort(list);

        for (anyone45 anyone45 : list) {
            System.out.println(anyone45);
        }
        scanner.close();
    }
}
