import java.util.ArrayList;
import java.util.Scanner;

class anyone49 {

    String id, name;
    int price;

    public anyone49(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name;
    }
}

public class J05069 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<anyone49> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = scanner.nextLine();
            String name = scanner.nextLine();
            int price = scanner.nextInt();
            scanner.nextLine();
            list.add(new anyone49(id, name, price));
        }
        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            String [] id = line.split(" ");
            for (anyone49 anyone49 : list) {
                if (anyone49.id.equals(id[0].substring(1,3))) {
                    System.out.println(id[0] + " " + anyone49 + " " + (Integer.parseInt(id[1]) * anyone49.getPrice()));
                    break;
                }
            }
        }
        scanner.close();
    }
}
