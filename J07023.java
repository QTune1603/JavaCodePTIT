import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class J07023 {
    public static boolean checkPalin(int x) {
        String tmp = String.valueOf(x);
        int len = tmp.length();
        for (int i = 0; i < tmp.length()/2; i++) {
            if (tmp.charAt(i) != tmp.charAt(len- i -1))
                return false;
        }
        return true;
    }

    public static boolean checkPr(int x) {
        if (x < 2) return false;
        if (x == 2) return true;

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));

        ArrayList<Integer> arr1 = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> arr2 = (ArrayList<Integer>) ois2.readObject();

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        for(int x: arr1) {
            if (checkPr(x) && checkPalin(x))
                arrayList1.add(x);
        }

        for(int x: arr2) {
            if (checkPr(x) && checkPalin(x))
                arrayList2.add(x);
        }

        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int x: arrayList1) {
            set.add(x);
            if (map1.containsKey(x))
                map1.put(x, map1.get(x) + 1);
            else
                map1.put(x, 1);
        }

        for(int x: arrayList2) {
            set.add(x);
            if (map2.containsKey(x))
                map2.put(x, map2.get(x) + 1);
            else
                map2.put(x, 1);
        }

        for (int x : set) {
            if (map1.containsKey(x) && map2.containsKey(x))
                System.out.println(x + " " + map1.get(x) + " " + map2.get(x));
            else if (map1.containsKey(x))
                System.out.println(x + " " + map1.get(x) + " " + 0);
            else
                System.out.println(x + " " + 0 + " " + map2.get(x));

        }
        ois1.close();
        ois2.close();
    }
}
