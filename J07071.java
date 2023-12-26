import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class noName implements Comparable<noName>{

    private String familyName;
    private String middleName;
    private String name;

    private String fullName;

    private String aka;

    public noName (String fullName) {
        this.fullName = fullName;
        String[] arr = fullName.split("\\s+");
        this.aka = findAka(fullName);

        this.familyName = arr[0];
        this.middleName = "";
        for (int i = 1; i < arr.length - 1; i++) {
            if (i < arr.length - 2)
                this.middleName += arr[i] + " ";
            else
                this.middleName += arr[i];
        }
        this.name = arr[arr.length - 1];



    }

    public String findAka(String fullName) {
        StringBuilder sb = new StringBuilder();
        String[] words = fullName.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1)
                sb.append(words[i].charAt(0));
            else
                sb.append(words[i].charAt(0) + ".");
        }
        return sb.toString();
    }

    public String getAka() {
        return aka;
    }


    public int compareTo (noName other) {
        if (this.name.compareTo(other.name) != 0) {
            return this.name.compareTo(other.name);
        } else
            return this.familyName.compareTo(other.familyName);
    }

    @Override
    public String toString() {
        return fullName;
    }
}
public class J07071 {
    public static void main(String[] args) throws Exception {
        File file = new File("DANHSACH.in");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<noName> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String fullName = sc.nextLine();
            list.add(new noName(fullName));
        }
        Collections.sort(list);
        int m = sc.nextInt();

        ArrayList<String> aka = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            aka.add(sc.next());
        }

//        for (noName x : list) {
//            System.out.println(x.getAka());
//        }

        for (String x : aka) {
//            String[] res = x.split("\\.");
//            System.out.println(x);

            for (noName y : list) {
                boolean d = true;
                if (y.getAka().length() != x.length()) {
                    d = false;
                    continue;
                }
                for (int i = 0; i < y.getAka().length(); i++) {
                    if (y.getAka().charAt(i) != x.charAt(i) && x.charAt(i) != '*' ) {
                        d = false;
                        break;
                    }
                }
                if (d)
                    System.out.println(y);
            }
        }
        sc.close();
    }
}
