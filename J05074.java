import java.util.ArrayList;
import java.util.Scanner;

class anyone51 {
    private String id, name, idClass;

    private String line;

    public anyone51(String id, String name, String idClass) {
        this.id = id;
        this.name = name;
        this.idClass = idClass;
    }

    public String getId() {
        return id;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int findMark() {
        int res = 10;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'm')
                res -= 1;
            else if (line.charAt(i) == 'v')
                res -= 2;
        }
        if (res <= 0)
            return 0;
        return res;
    }

    @Override
    public String toString() {
        if (findMark() == 0)
            return String.format("%s %s %s %d KDDK", id, name, idClass, findMark());
        return String.format("%s %s %s %d", id, name, idClass, findMark());
    }
}

public class J05074 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<anyone51> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            scanner.nextLine();
            String name = scanner.nextLine();
            String idClass = scanner.next();
            list.add(new anyone51(id, name, idClass));
        }
        scanner.nextLine();
        String line;

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] words = line.split("\\s+");
            for (anyone51 x: list) {
                if (x.getId().equals(words[0])) {
                    x.setLine(words[1]);
                    break;
                }
            }
        }

        for (anyone51 anyone51 : list) {
            System.out.println(anyone51);
        }
        scanner.close();
    }
}
