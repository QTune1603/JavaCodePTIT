import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class anyone40 {
    private static int id = 1;
    private int idHS;
    private String name;
    private double avgMark;

    public anyone40(String name, double avgMark) {
        this.idHS = id++;
        this.name = name;
        this.avgMark = avgMark;
    }

    public String assessment () {
        if (this.avgMark >= 9)
            return "Gioi";
        else if (this.avgMark >= 7)
            return "Kha";
        else if (this.avgMark >= 5)
            return "Trung Binh";
        else
            return "Yeu";
    }

    public int getIdHS() {
        return idHS;
    }

    public double getAvgMark() {
        return avgMark;
    }

    @Override
    public String toString() {
        if (idHS < 10)
            return "HS0" + idHS + " " + name + " " + avgMark + " " + assessment();
        else
            return "HS" + idHS + " " + name + " " + avgMark + " " + assessment();
    }
}
public class J05054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<anyone40> list = new ArrayList<>();
        List<Double> lst = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double avgMark = scanner.nextDouble();
            lst.add(avgMark);
            scanner.nextLine();
            list.add(new anyone40(name, avgMark));
        }

        Collections.sort(lst,Collections.reverseOrder());
        int[] rank = new int[105];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            rank[i] =  lst.indexOf(list.get(i - 1).getAvgMark()) + 1;
        }

        for (anyone40 x : list) {
            System.out.println(x + " " + rank[x.getIdHS()]);
        }
        scanner.close();
    }
}
