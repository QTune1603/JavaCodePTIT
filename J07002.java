import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class J07002 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long res = 0;
        while(sc.hasNext()){
            String s = sc.next();
            try {
                int x = Integer.parseInt(s);
                res += x;
            }catch(Exception e){
                
            }
        }
        System.out.println(res);
    }
}
