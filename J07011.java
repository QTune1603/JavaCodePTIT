import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class pr implements Comparable<pr> {
    private String fi;
    private int se;

    public pr(String fi, int se) {
        this.fi = fi;
        this.se = se;
    }

    public String getFi() {
        return fi;
    }

    public int getSe() {
        return se;
    }

    @Override
    public int compareTo(pr o) {
        if (o.getSe() != this.getSe())
            return o.getSe() - this.getSe();
        return this.getFi().compareTo(o.getFi());
    }
}
public class J07011 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("VANBAN.in"));
        int t = scanner.nextInt();
        scanner.nextLine();
        StringBuilder sum = new StringBuilder("");
        while(t-- > 0) {
            String line = scanner.nextLine().toLowerCase();
            sum.append(line + " ");


        }

        for (int i = 0;i<sum.length();i++) {
            if (!Character.isDigit(sum.charAt(i)) && !Character.isLetter(sum.charAt(i))) {
                sum.replace(i,i  +1, " ");
            }
        }
//        System.out.println(sum.toString());
        String[] words = sum.toString().split("\\s+");
        Map<String, Integer> map = new TreeMap<>();
        for (String word : words) {

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else
                map.put(word, 1);
        }
        ArrayList<pr> arr = new ArrayList<pr>();
//        map.forEach((k , v) -> System.out.println(k + " " + v));
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            arr.add(new pr(entry.getKey(), entry.getValue()));
        }

        Collections.sort(arr);

        for(pr x: arr) {
            System.out.println(x.getFi() + " " + x.getSe());
        }
    }
}
