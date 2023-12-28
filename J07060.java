import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class A {

    public A(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    String id, name, type;

}
class B implements Comparable<B> {
    String time, room, id;
    Date date;
    public B(Date date, String time, String room, int count) {
        this.date = date;
        this.time = time;
        this.room = room;
        this.id = "C" + (count < 10 ? "00" : count < 100 ? "0" : "") + count;
    }
    @Override
    public int compareTo(B a) {
        if (!this.date.equals(a.date)) {
            return Long.compare(this.date.getTime(), a.date.getTime());
        }
        return this.time.compareTo(a.time);
    }
}
class C implements Comparable<C> {
    String idca, idmon, group;
    int num;

    public C(String idca, String idmon, String group, int num) {
        this.idca = idca;
        this.idmon = idmon;
        this.group = group;
        this.num = num;
    }
    @Override 
    public int compareTo(C a) {
        return this.idca.compareTo(a.idca);
    }
}

public class J07060 {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(new File("MONTHI.in"));
        Scanner scanner2 = new Scanner(new File("CATHI.in"));
        Scanner scanner3 = new Scanner(new File("LICHTHI.in"));        
        
        int t = Integer.parseInt(scanner1.nextLine());
        ArrayList<A> a = new ArrayList<>();
        ArrayList<B> b = new ArrayList<>();
        ArrayList<C> c = new ArrayList<>();

        while(t-- > 0) {
            String id = scanner1.nextLine();
            String name = scanner1.nextLine();
            String type = scanner1.nextLine();
            a.add(new A(id, name, type));
        }
        
        t = Integer.parseInt(scanner2.nextLine());
        int count = 0;
        while(t-- > 0) {
            Date date = new SimpleDateFormat("dd/mm/yyyy").parse(scanner2.nextLine());
            String time = scanner2.nextLine();
            String room = scanner2.nextLine();
            b.add(new B(date, time, room, ++count));
        }
        
        t = Integer.parseInt(scanner3.nextLine());
        while (t-- > 0) {
            String idca = scanner3.next();
            String idmon = scanner3.next();
            String group = scanner3.next();
            int num = Integer.parseInt(scanner3.next());
            c.add(new C(idca, idmon, group, num));
        }
        Collections.sort(b);
//        Collections.sort(c);
        for (int i = 0; i < b.size(); ++i) {
           B ca = b.get(i);
           for (C j : c) {
                if (j.idca.equals(ca.id)) {
                    for (A k : a) {
                        if (k.id.equals(j.idmon)) {
                            System.out.println(new SimpleDateFormat("dd/mm/yyyy").format(ca.date) + " " + ca.time + " " + ca.room + " " + k.name + " " + j.group + " " + j.num);
//                            break;
                        }
                    }
//                    break;
                }
           }
        } 
    }    
}
