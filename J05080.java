import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class hoc_phan<T1> implements Comparable<hoc_phan> {

    private T1 codeSub, groupClass, nameSub, nameTeacher;


    public hoc_phan (T1 codeSub, T1 nameSub, T1 groupClass, T1 nameTeacher) {
        this.codeSub = codeSub;
        this.nameSub = nameSub;
        this.groupClass = groupClass;
        this.nameTeacher = nameTeacher;
    }

    public T1 getCodeSub() {
        return this.codeSub;
    }

    public T1 getNameSub() {
        return this.nameSub;
    }

    public T1 getNameTeacher() {
        return this.nameTeacher;
    }

    public int compareTo (hoc_phan other) {
        String tmp1 = (String) this.codeSub;
        String tmp2 = (String) other.codeSub;
        if (tmp1.compareTo(tmp2) != 0) {
            return tmp1.compareTo(tmp2);
        }

        String s1 = (String) this.groupClass;
        String s2 = (String) other.groupClass;
        return s1.compareTo(s2);
    }

    @Override
    public String toString() {
        return this.codeSub + " " + this.nameSub + " " + this.groupClass;
    }
}
public class J05080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<hoc_phan> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String codeSub = scanner.nextLine();
            String nameSub = scanner.nextLine();
            String groupClass = scanner.nextLine();
            String nameTeacher = scanner.nextLine();

            list.add(new hoc_phan<>(codeSub,nameSub, groupClass, nameTeacher));

        }

        Collections.sort(list);

        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String nameTeacher = scanner.nextLine();
            System.out.print("Danh sach cho giang vien ");
            boolean d = true;
            for (hoc_phan x : list) {

                if (x.getNameTeacher().equals(nameTeacher)) {
                    if (d) {
                        System.out.println(x.getNameTeacher() + ":");
                        d = false;
                    }


                    System.out.println(x);
                }
            }

        }
        scanner.close();
    }
}
