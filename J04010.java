import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class J04010 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine()), num = 0;
        while (t-- > 0) {
            Point a = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
            Point b = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
            Point c = new Point(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
            double x = calc_dist(a, b);
            double y = calc_dist(a, c);
            double z = calc_dist(b, c);
            if (x + y <= z || x + z <= y || y + z <= x) {
                System.out.println("INVALID");
                continue;
            }
            double p = (x + y + z) / 2, s = Math.sqrt(p * (p - x) * (p - y) * (p - z));
            System.out.printf("%.3f\n", (x * y * z / (4 * s)) * (x * y * z / (4 * s)) * Math.PI);
        }
        scanner.close();
    }
    public static double calc_dist(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
