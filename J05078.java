import java.util.ArrayList;
import java.util.Scanner;

class anyone65 {
    private String id, name;
    private int basicSalary, numberOfDays;
    private static int[][] x = new int[105][105];
    private int Income;
    private String idCom;

    public anyone65(String id, String name, int salary, int numberOfDays) {
        this.id = id;
        this.name =name;
        this.basicSalary = salary;
        this.numberOfDays = numberOfDays;
        this.idCom = this.id.substring(3);
    }

    public String getIdCom() {
        return idCom;
    }

    public static void setX() {
        for (int j =1; j<=3;j++) {
            x[1][j] = 10;
            x[2][j] = 10;
            x[3][j] = 9;
            x[4][j] = 8;
        }

        for (int j = 4; j<=8;j++) {
            x[1][j] = 12;
            x[2][j] = 11;
            x[3][j] = 10;
            x[4][j] = 9;
        }

        for (int j = 9 ; j<=15;j++) {
            x[1][j] = 14;
            x[2][j] = 13;
            x[3][j] = 12;
            x[4][j] = 11;
        }

        for (int j = 16; j<=99;j++) {
            x[1][j] = 20;
            x[2][j] = 16;
            x[3][j] = 14;
            x[4][j] = 13;
        }

    }

    public int getIncome() {
        int res = this.basicSalary * this.numberOfDays;
        int i;
        if (this.id.charAt(0) == 'A')
            i = 1;
        else if (this.id.charAt(0) == 'B')
            i = 2;
        else if (this.id.charAt(0) == 'C')
            i = 3;
        else
            i = 4;
        int j = Integer.parseInt(this.id.substring(1,3));
        return res * x[i][j] * 1000;
    }

    public String toString() {
        return id + " " + name + " " + getIncome();
    }


}

class anything20 {
    private String id, name;

    public anything20 (String line) {
        String[] words = line.split("\\s+");
        this.id = words[0];
        String tmp = "";
         for (int i = 1; i < words.length; i++) {
            tmp += words[i];
            tmp += " ";
        }
        this.name = tmp.trim();
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}

public class J05078 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        anyone65.setX();
        ArrayList<anything20> a1 = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            a1.add(new anything20(line));
        }
        ArrayList<anyone65> a2 = new ArrayList<>();
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            scanner.nextLine();
            String name = scanner.nextLine();
            int basicS = scanner.nextInt();
            int numberOfDays = scanner.nextInt();
            a2.add(new anyone65(id, name, basicS, numberOfDays));
        }

        String aka = scanner.next();
        for (anything20 tmp : a1) {
            if (tmp.getId().equals(aka)) {
                System.out.println("Bang luong phong " + tmp.getName() + ":");
                break;
            }
        }
        for (anyone65 tmp : a2) {
            if (tmp.getIdCom().equals(aka)) {
                System.out.println(tmp);
            }
        }
        scanner.close();
    }
}
