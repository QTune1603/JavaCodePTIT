import java.util.Scanner;
import java.util.Stack;

public class J08023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n + 5];

            for (int i = 0; i < n; i++) {
                a[i]= sc.nextLong();
            }

            Stack<Integer> queue = new Stack<>();

            queue.add(0);
            long res  =0;
            int i = 1;
            while (i < n) {
                int cur = queue.peek();
                if (a[cur] > a[i]) {
                    queue.pop();
                    if (queue.size() == 0) {
                        res = Math.max(res,(long) i * a[cur]);
                        queue.add(i);
                        i++;
                    } else {
                        res = Math.max(res,(long) (i - queue.peek() - 1) * a[cur]);
//                        System.out.println(cur + " " +i);
                    }
                } else {
                    queue.add(i);
                    i++;
                }
            }
//            System.out.println(res);
            while (queue.size() != 0) {
                int cur = queue.pop();

                if (queue.size() == 0) {
                    res = Math.max(res,(long) a[cur] * i);
                } else {
                    res = Math.max(res,(long) a[cur] * (i - queue.peek() - 1));
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}
