import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class A {
    int a, b;
    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int first() {
        return a;
    }
    public int second() {
        return b;
    }
}
public class J08029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String x = scanner.next();
            String y = scanner.next();
            System.out.println(f(x, y));
        }
        scanner.close();
    }
    
    private static int f(String x, String y) {
        A goal = new A(y.charAt(0) - 'a' + 1, y.charAt(1) - '0');
        Queue<A> q = new LinkedList<>();
        int vis[][] = new int[9][9];
        for (int i = 0; i < 9; ++i) 
            Arrays.fill(vis[i], 0);
        q.add(new A(x.charAt(0) - 'a' + 1, x.charAt(1) - '0'));
        while (!q.isEmpty()) {
            A t = q.remove();
            if (t.first() == goal.first() && t.second() == goal.second()) return vis[goal.first()][goal.second()];
            if (t.first() >= 3 && t.second() >= 2) {
                A cell = new A(t.first() - 2, t.second() - 1);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
            if (t.first() >= 3 && t.second() <= 7) {
                A cell = new A(t.first() - 2, t.second() + 1);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
            if (t.first() >= 2 && t.second() <= 6) {
                A cell = new A(t.first() - 1, t.second() + 2);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
            if (t.first() <= 7 && t.second() <= 6) {
                A cell = new A(t.first() + 1, t.second() + 2);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
            if (t.first() <= 6 && t.second() <= 7) {
                A cell = new A(t.first() + 2, t.second() + 1);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
            if (t.first() <= 6 && t.second() >= 2) {
                A cell = new A(t.first() + 2, t.second() - 1);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
            if (t.first() <= 7 && t.second() >= 3) {
                A cell = new A(t.first() + 1, t.second() - 2);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
            if (t.first() >= 2 && t.second() >= 3) {
                A cell = new A(t.first() - 1, t.second() - 2);
                if (vis[cell.first()][cell.second()] == 0) {
                    q.add(cell);
                    vis[cell.first()][cell.second()] = vis[t.first()][t.second()] + 1;
                }
            }
        }
        return -1;
    }
}
