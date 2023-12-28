import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J02102 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) a.add(scanner.nextInt());
        Collections.sort(a);
        int s = 0, ans[][] = new int[n][n], cur = 0;
        while (s < n && ans[s][s] == 0) {
            int i = s, j = s;
            while (j < n && ans[i][j] == 0) {
                ans[i][j] = a.get(cur);
                ++j;
                ++cur;
            }
            --j;
            ++i;
            while (i < n && ans[i][j] == 0) {
                ans[i][j] = a.get(cur);
                ++i;
                ++cur;
            }
            --i;
            --j;
            while (j >= 0 && ans[i][j] == 0) {
                ans[i][j] = a.get(cur);
                --j;
                ++cur;
            }
            ++j;
            --i;
            while (i >= 0 && ans[i][j] == 0) {
                ans[i][j] = a.get(cur);
                --i;
                ++cur;
            }
            ++s;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) System.out.print(ans[i][j] + " ");
            System.out.println();
        }
        scanner.close();
    }
}
