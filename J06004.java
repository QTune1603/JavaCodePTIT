import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

interface anyone56 {
    void letgo();

}

class anyone57<T> implements Comparable<anyone57> {

    private T id, name, phoneNumber, nameGroup, nameTopic;

    public anyone57(T id, T name, T phoneNumber, T nameGroup) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nameGroup = nameGroup;
    }

    public anyone57 (T id, T name, T phoneNumber, T nameGroup, T nameTopic) {
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

    public int compareTo(anyone57 other) {
        String tmp1 = (String) this.id;
        String tmp2 = (String) other.id;
        return tmp1.compareTo(tmp2);

    }
    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.phoneNumber + " " + this.nameGroup + " " + this.nameTopic;
    }
}

public class J06004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<anyone57<String>> list = new ArrayList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String id = scanner.nextLine();
            String name = scanner.nextLine();
            String phoneNumber = scanner.nextLine();
            String nameGroup = scanner.nextLine();
            list.add(new anyone57(id, name, phoneNumber, nameGroup));
        }

        for (int i = 1; i <= m; i++) {
            String nameTopic = scanner.nextLine();
            for (anyone57 j : list) {
                if (j.getNameGroup().equals(String.valueOf(i))) {
                    j.setNameTopic(nameTopic);
                }
            }
        }
        Collections.sort(list);

        for (anyone57 i : list) {
            System.out.println(i);
        }
        scanner.close();
    }
}
