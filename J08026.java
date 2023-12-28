import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class A {
    int a, b;
    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class J08026 {
    static int a, b;
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();  
            System.out.println(bfs());          
        }
        scanner.close();
    }
    public static int bfs() {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        Queue<A> q = new LinkedList<>();
        q.add(new A(a, 0));
        while (!q.isEmpty()) {
            A t = q.peek();
            q.remove();
            if (t.a == b) return t.b;
            if (!vis.containsKey(t.a - 1) && t.a > 0) {
                q.add(new A(t.a - 1, t.b + 1));
                vis.put(t.a - 1, true);
            }
            if (!vis.containsKey(t.a * 2) && t.a < b) {
                q.add(new A(t.a * 2, t.b + 1));
                vis.put(t.a * 2, true);
            }
        }
        return 0;
    }
}
