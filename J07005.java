import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class J07005 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));
        int cnt[] = new int[100000];
        for(int i = 0 ; i < 100000 ; i++){
            cnt[dis.readInt()]++;
        }
        for(int i = 0 ; i < 1000 ; i++){
            if(cnt[i] > 0){
                System.out.println(i + " " + cnt[i]);
            }
        }
        dis.close();
    }
}
