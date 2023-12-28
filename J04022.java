import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


class WordSet {
    SortedSet<String> a = new TreeSet<>();
    WordSet(String a) {
        String b[] = a.trim().toLowerCase().split("\\s+");
        for (String i : b) this.a.add(i);
    }
    public String union(WordSet a) {
        String b = "";
        SortedSet<String> c = new TreeSet<>(this.a);
        for (String i : a.a) c.add(i);
        for (String i : c) b += i + " ";
        return b;
    }
    public String intersection(WordSet a) {
        String b = "";
        SortedSet<String> c = new TreeSet<>();
        for (String i : a.a) 
            if (this.a.contains(i)) c.add(i);
        for (String i : c) b += i + " ";
        return b;
    }
}
public class J04022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
        in.close();
    }
    public static void main2473570(String[] args) {
        Scanner in = new Scanner(System.in);
      
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
        in.close();
    }
}
