import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class J07004 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(sc.hasNext()){
            int x = sc.nextInt();
            if(!map.containsKey(x)){
                map.put(x,1);
            }
            else {
                map.put(x,map.get(x)+1);
            }
        }
        map.forEach((k,v) -> System.out.println(k + " " + v));
    }
}
