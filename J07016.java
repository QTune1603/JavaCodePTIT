import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class J07016 {
    public static boolean checkSnt(int a) {
        if (a < 2) return false;
        if (a == 2) return true;
        for(int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        FileInputStream fis1 = new FileInputStream("DATA1.in");
        FileInputStream fis2 = new FileInputStream("DATA2.in");

        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        ObjectInputStream ois2 = new ObjectInputStream(fis2);

        ArrayList<Integer> arr1 = (ArrayList<Integer>) ois1.readObject();
        ArrayList<Integer> arr2 = (ArrayList<Integer>) ois2.readObject();

        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int x: arr1) {
            if (checkSnt(x)) {
                set.add(x);
                if (map1.containsKey(x))
                    map1.put(x, map1.get(x) + 1);
                else
                    map1.put(x, 1);
            }
        }

        for(int x: arr2) {
            if (checkSnt(x)) {
                set.add(x);
                if (map2.containsKey(x))
                    map2.put(x, map2.get(x) + 1);
                else
                    map2.put(x, 1);
            }
        }

        for (int x: set) {
            if (map1.containsKey(x) && map1.containsKey(x))
                System.out.println(x + " " + map1.get(x) + " " + map2.get(x));
            else if (map1.containsKey(x))
                System.out.println(x + " " + map1.get(x) + " 0");
            else
                System.out.println(x + " 0 " + map2.get(x));

        }

    }
}
