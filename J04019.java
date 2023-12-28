import java.util.Scanner;

class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static Point nextPoint(Scanner sc) {
        return new Point(sc.nextDouble(), sc.nextDouble()); 
    }
}
class Triangle {
    Point a, b, c;
    Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    double calc_dist(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
    public boolean valid() {
        double x = calc_dist(a, b);
        double y = calc_dist(a, c);
        double z = calc_dist(b, c);
        return (x + y > z && x + z > y && y + z > x);
    }
    public String getPerimeter() {
        double x = calc_dist(a, b);
        double y = calc_dist(a, c);
        double z = calc_dist(b, c);
        return String.format("%.3f", x + y + z);
    }
}
public class J04019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
        sc.close();
    }
    public static void main9379834(String[] args) {
        Scanner sc = new Scanner(System.in); 

        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
        sc.close();
    }
}
