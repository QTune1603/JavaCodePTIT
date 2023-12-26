import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class J07006 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> list = (ArrayList<Integer>) ois.readObject();
        int cnt[] = new int[1000001];
        for(Integer i:list){
            cnt[i]++;
        } 
        for(int i = 0 ; i < 1000000 ; i++){
            if(cnt[i] > 0){
                System.out.println(i + " " + cnt[i]);
            }
        }
        ois.close();
    }
}
