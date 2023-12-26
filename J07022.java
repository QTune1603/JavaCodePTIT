import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J07022 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<String> a = new ArrayList<>();
        while(sc.hasNext()){
            String tmp = sc.next();
            try{
                int x = Integer.parseInt(tmp);
            }catch(Exception e){
                a.add(tmp);
            }
        }
        Collections.sort(a);
        for(String x:a){
            System.out.print(x + " ");
        }
        sc.close();
    }
}
