import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class J03038 {
    public static void main(String args[]) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {
        Scanner sc = new Scanner(System.in);  
        String s = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ;i++){
            map.put(s.charAt(i), 1);
        }
        System.out.println(map.size());
        sc.close();
    }
}
