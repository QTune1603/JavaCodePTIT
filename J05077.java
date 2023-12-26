import java.util.ArrayList;
import java.util.Scanner;

class anyone61 {
    private String id, name;

    public anyone61(String line) {
        String[] words = line.split(" ");
        this.id = words[0];
        String tmp = "";
        for (int i = 1; i < words.length; i++) {
            tmp += words[i] + " ";
        }
        this.name = tmp.trim();
    }

    public anyone61 (String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

class anyone62 extends anyone61 {

    private String nameNv;
    private int salary;
    private int days;

    public anyone62(String id, String name, String nameNv, int salary, int days) {
        super(id, name);
        this.nameNv = nameNv;
        this.salary = salary;
        this.days = days;
    }

    public int income() {
        int res = this.salary * this.days;
        int[][] a = new int[25][25];
        a[1][1] = 10; a[1][2] = 12; a[1][3] = 14; a[1][4] = 20;
        a[2][1] = 10; a[2][2] = 11; a[2][3] = 13; a[2][4] = 16;
        a[3][1] = 9; a[3][2] = 10; a[3][3] = 12; a[3][4] = 14;
        a[4][1] = 8; a[4][2] = 9; a[4][3] = 11; a[4][4] = 13;

        int years = Integer.parseInt(super.getId().substring(1,3));
        char c = super.getId().charAt(0);
        int x, y;

        if (c == 'A')
            x = 1;
        else if (c == 'B')
            x = 2;
        else if (c == 'C')
            x = 3;
        else
            x = 4;


        if (years >= 16)
            y = 4;
        else if (years >= 9)
            y = 3;
        else if (years >= 4)
            y = 2;
        else
            y = 1;

        return res * a[x][y] * 1000;
    }

    @Override
    public String toString() {
        return super.getId() + " " + this.nameNv + " " + super.getName() + " " + income();
    }
}

public class J05077 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();
        ArrayList<anyone61> list = new ArrayList<>();
        ArrayList<anyone62> list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            list.add(new anyone61(line));
        }

        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            String id = scanner.nextLine();
            for (anyone61 x: list) {
                if (x.getId().equals(id.substring(3,5))) {
                    String nameNv = scanner.nextLine();
                    int salary = scanner.nextInt();
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    list2.add(new anyone62(id, x.getName(), nameNv, salary, days));
                }
            }
        }

        for (anyone62 x : list2) {
            System.out.println(x);
        }
        scanner.close();

    }
}
