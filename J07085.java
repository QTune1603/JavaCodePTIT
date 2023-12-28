import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.ArrayList;
public class J07085 {
    public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException {      
        ObjectInputStream scanner = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) scanner.readObject();
        for (String i : a) {
            String b = "";
            Long c = 0L;
            boolean d = true;
            for (char j : i.toCharArray()) {
                if (j >= '0' && j <= '9') {
                    if (j == '0' && d) continue;
                    if (j != '0') d = false;
                    b += j + "";
                    c += j - '0';
                }
            }
            System.out.println(b + " " + c);
        }
        scanner.close();
    }
}
