import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class J02005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        TreeMap<Integer,Integer> map2 = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            map.put(a[i], 1);
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            if(map.containsKey(b[i])){
                map2.put(b[i], 1);
            }
        }
        Set<Integer> set = map2.keySet();
        for(Integer key:set){
            System.out.print(key + " ");
        }
        sc.close();
    }
}
