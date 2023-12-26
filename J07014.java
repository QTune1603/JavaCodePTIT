import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class WordSet {
    Set<String> st = new TreeSet<>();
    public WordSet (String name) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(name));
        while (sc.hasNext()) {
            st.add(sc.next().toLowerCase());
        }
    }

    public String union (WordSet other) {
        Set<String> res = new TreeSet<>();

        for (String x: this.st) {
            res.add(x);
        }

        for (String y: other.st) {
            res.add(y);
        }

        String ans = "";
        for (String x: res)
            ans += x + " ";
        return ans.trim();
    }

    public String intersection(WordSet other) {
        Set<String> res = new TreeSet<>();
        for (String x: this.st) {
            for (String y: other.st) {
                if (x.equals(y)) {
                    res.add(x);
                    break;
                }

            }
        }
        String ans = "";
        for (String x : res)
            ans += x + " ";
        return ans.trim();
    }
    @Override
    public String toString() {
        String res = "";
        for (String x: st)
            res += x + " ";
        return res.trim();
    }
}
public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
    public static void main3273212(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));


    }
}
