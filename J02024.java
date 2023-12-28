import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class J02024 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
           

        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            int n = scanner.nextInt();
            Integer a[] = new Integer[n], gen[] = new Integer[n];
            Arrays.fill(gen, 0);
            for (int i = 0; i < n; ++i) a[i] = scanner.nextInt();
            Arrays.sort(a, Collections.reverseOrder());
            boolean stop = false;
            while (!stop) {
                stop = true;
                for (int i = n - 1; i >= 0; --i) {
                    if (gen[i] == 0) {
                        stop = false;
                        gen[i] = 1;
                        break;
                    }
                    else gen[i] = 0;
                }
                int cur = 0;
                for (int i = 0; i < n; ++i) cur += gen[i] * a[i];
                if (cur % 2 == 1) {
                    for (int i = 0; i < n; ++i)
                        if (gen[i] == 1) System.out.print(a[i] + " ");
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}
