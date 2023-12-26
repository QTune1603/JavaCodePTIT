import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class DaThuc {
    private Map<Long, Long> map;
    
    
    public DaThuc () {
        map = new HashMap<>();
    }
    public DaThuc (String line) {
        map = new HashMap<>();
        
        String[] words = line.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("+")) 
                continue;
            long key, val;
            int ind = 0;
            String tmp = "";
            while (Character.isDigit(words[i].charAt(ind))) {
                tmp = tmp + words[i].charAt(ind);
                ind++;
            }
            val = Long.parseLong(tmp);
            
            key = Long.parseLong(words[i].substring(ind + 3));
            map.put(key, val);
        }                
    }
    
    public DaThuc cong(DaThuc other) {
        DaThuc res = new DaThuc();
        for (Map.Entry<Long, Long> entry : this.map.entrySet()) {
            Long key = entry.getKey();
            if (other.map.containsKey(key)) {
                res.map.put(key, this.map.get(key)+ other.map.get(key));
                
            } else {
                res.map.put(key, this.map.get(key));
            }
        }
        for (Map.Entry<Long, Long> entry : other.map.entrySet()) {
            Long key = entry.getKey();
            if (!this.map.containsKey(key)) {
                res.map.put(key, other.map.get(key));
            }
        }
        return res;
    }
    
        public static <K extends Comparable<K>, V> Map<K, V> sortByKeys(Map<K, V> map) {
        Map<K, V> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.putAll(map);
        return treeMap;
    }

    
    @Override
    public String toString () {
        Map<Long, Long> mapp = sortByKeys(map);
        int ind = 0;
        for (Map.Entry<Long, Long> entry : mapp.entrySet()) {
            System.out.print(entry.getValue() + "*x^" + entry.getKey());
            if (ind != mapp.size() - 1) {
                System.out.print(" + ");
            } 
            ind++;
        }
        return "";
    }
    
    
    
}
public class J05063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
    public static void main7757794(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
        sc.close();
    }
}
