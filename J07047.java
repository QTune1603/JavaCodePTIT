import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class A {
    String id, name;
    long dongia;
    double service;

    public A(String id, String name, long dongia, double service) {
        this.id = id;
        this.name = name;
        this.dongia = dongia;
        this.service = service;
    }
    
}

class B implements Comparable<B> {
    String name, room, id;
    Date x, y;
    static int count = 0;
    long day;

    public B(String name, String room, Date x, Date y) {
        this.name = name;
        this.room = room;
        this.x = x;
        this.y = y;
        this.id = String.format("KH%02d", ++count);
        this.day = Math.max((y.getTime() - x.getTime()) / (1000 * 60 * 60 * 24), 1L);
    }
    @Override
    public int compareTo(B a) {
        return Long.compare(a.day, this.day);
    }
}

public class J07047 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("DATA.in"));

        ArrayList<A> a = new ArrayList<>();
        ArrayList<B> b = new ArrayList<>();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String x[] = scanner.nextLine().split("\\s+");
            String id = x[0];
            String name = x[1];
            long dongia = Long.parseLong(x[2]);
            double service = Double.parseDouble(x[3]);
            a.add(new A(id, name, dongia, service));
        }
        
        t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String name = scanner.nextLine();
            String room = scanner.nextLine();
            Date x = s.parse(scanner.nextLine());
            Date y = s.parse(scanner.nextLine());
            b.add(new B(name, room, x, y));
        }
        
        Collections.sort(b);
        for (B i : b) {
            String id = i.room.substring(2, 3);
            for (A j : a) {
                if (id.equals(j.id)) {
                    double cost = i.day * j.dongia * (1 + j.service) * 1.0  ;
                    cost -= (i.day > 30 ? cost * 0.06 : i.day >= 20 ? cost * 0.04 : i.day >= 10 ? cost * 0.02 : 0);
                    System.out.println(i.id+ " " + i.name + " " + i.room + " " + (i.day == 1 ? (i.x.equals(i.y) ? "0" : "1") : i.day) + " " + String.format("%.2f", cost));
                }
            }   
        }
    }    
}
