import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class A {
    int a[] = new int[6], b = 0;
    A(int a[], int b) {
        for (int i = 0; i < 6; ++i) this.a[i] = a[i];
        this.b = b;
    }
}
public class J08025 {
    static int a[];
	static int b[];
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            a = new int[6];
            b = new int[6];
            for (int i = 0; i < 6; ++i) a[i] = scanner.nextInt();
            for (int i = 0; i < 6; ++i) b[i] = scanner.nextInt(); 
            System.out.println(bfs());
        }
        scanner.close();
    }
    public static int bfs() {
        Queue<A> q = new LinkedList<>();
        q.add(new A(a, 0));
        while (!q.isEmpty()) {
            A t = q.peek();
            q.remove();
            boolean same = true;
            for (int i = 0; i < 6; ++i) {
                if (t.a[i] != b[i]) same = false;
            }
            if (same) return t.b;
            int x[] = new int[6];
            x[0] = t.a[3];
            x[1] = t.a[0];
            x[2] = t.a[2];
            x[3] = t.a[4];
            x[4] = t.a[1];
            x[5] = t.a[5];
            q.add(new A(x, t.b + 1));

            x = new int[6];
            x[0] = t.a[0];
            x[1] = t.a[4];
            x[2] = t.a[1];
            x[3] = t.a[3];
            x[4] = t.a[5];
            x[5] = t.a[2];
            q.add(new A(x, t.b + 1));
        }
        return 0;
    }
}
