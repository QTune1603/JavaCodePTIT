import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class nobody implements Comparable<nobody> {
    private static int id = 1;
    private int IdKH;
    private String Name;
    private int type;

    private int quantity;

    private int limitFee;
    private int overLimitFee;
    private int fee;

    public nobody(String name, String data) {
        this.IdKH = id++;
        this.Name = normalizeName(name);
        String[] arr = data.split("\\s+");
        if (arr[0].equals("A"))
            this.type = 100;
        else if (arr[0].equals("B"))
            this.type = 500;
        else
            this.type = 200;
        this.quantity = Integer.parseInt(arr[2]) - Integer.parseInt(arr[1]);
        this.limitFee = findLimitFee(this.quantity);
        this.overLimitFee = findOverLimitFee(this.quantity);
        this.fee = (int) (this.limitFee + this.overLimitFee + this.overLimitFee * 0.05);
    }

    public int findLimitFee(int quantity) {
        if (quantity < this.type) {
            return quantity * 450;
        } else {
            return this.type * 450;
        }
    }

    public int findOverLimitFee(int quantity) {
        if (quantity < this.type) {
            return 0;
        } else {
            return (quantity - this.type) * 1000;
        }
    }

    public String normalizeName(String name) {
        String[] words = name.trim().split("\\s+");
        String result = "";
        for (String word : words) {
            result += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
        }
        return result.trim();
    }

    @Override
    public int compareTo(nobody other) {
        return other.fee - this.fee;
    }

    @Override
    public String toString() {
        int vat = (int) ((int) this.overLimitFee * 0.05);

        if (IdKH < 10)
            return "KH0" + this.IdKH + " " + this.Name + " " + this.limitFee + " " + this.overLimitFee + " " + vat + " "
                    + this.fee;
        else
            return "KH" + this.IdKH + " " + this.Name + " " + this.limitFee + " " + this.overLimitFee + " " + vat + " "
                    + this.fee;
    }

}

public class J07056 {
    public static void main(String[] args) throws Exception {
        File file = new File("KHACHHANG.in");
        Scanner sc = new Scanner(file);

        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<nobody> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String data = sc.nextLine();
            nobody kh = new nobody(name, data);
            list.add(kh);
        }

        Collections.sort(list);

        for (nobody kh : list) {
            System.out.println(kh);
        }
        sc.close();
    }
}
