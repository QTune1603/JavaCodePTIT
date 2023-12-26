import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface anyone53 {
    void letgo();

}


class anyone55<T> {
    private T name;
    private static int id = 1;
    private int idGroup;

    public anyone55(T name) {
        this.name = name;
        this.idGroup = id++;
    }

    public T getName() {
        return name;
    }
}
class anyone54<T>implements anyone53 {

    private T id, name, phoneNumber, nameGroup, nameTopic;

    public anyone54(T id, T name, T phoneNumber, T nameGroup) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nameGroup = nameGroup;
    }

    public anyone54 (T id, T name, T phoneNumber, T nameGroup, T nameTopic) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nameGroup = nameGroup;
        this.nameTopic = nameTopic;
    }

    public void setNameTopic(T nameTopic) {
        this.nameTopic = nameTopic;
    }
    public T getNameGroup() {
        return nameGroup;
    }

    public T getNameTopic() {
        return nameTopic;
    }

    @Override
    public void letgo() {
        System.out.println("let go");
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.phoneNumber;
    }
}

public class J06003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<anyone54<String>> list = new ArrayList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String id = scanner.nextLine();
            String name = scanner.nextLine();
            String phoneNumber = scanner.nextLine();
            String nameGroup = scanner.nextLine();
            list.add(new anyone54(id, name, phoneNumber, nameGroup));
        }
        List<anyone55<String>> listCourse = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String nameTopic = scanner.nextLine();
            listCourse.add(new anyone55<>(nameTopic));
            for (anyone54 j : list) {
                if (j.getNameGroup().equals(String.valueOf(i))) {
                    j.setNameTopic(nameTopic);
                }
            }

        }

        int query = scanner.nextInt();
        for (int i = 0; i < query; i++) {
            int orderGroup = scanner.nextInt();
            System.out.println("DANH SACH NHOM " + orderGroup + ":");
            for (anyone54 j : list) {
                if (j.getNameGroup().equals(String.valueOf(orderGroup))) {
                    System.out.println(j);
                }
            }
            System.out.println("Bai tap dang ky: " + listCourse.get(orderGroup - 1).getName());

        }
        scanner.close();
    }
}
