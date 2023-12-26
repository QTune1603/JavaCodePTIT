import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class WordSet {
    private Set<String> set = new TreeSet<>();

    public WordSet(String file) throws IOException {
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext()) {
            this.set.add(sc.next().toLowerCase());
        }
    }

    public String difference (WordSet other) {
        String res = "";
        for (String x : this.set) {
            if (!other.set.contains(x))
                res += x + " ";
        }
        return res.trim();
    }
}
public class J07024 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
    public static void main7774986(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
