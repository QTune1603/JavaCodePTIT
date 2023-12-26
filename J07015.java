import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class J07015 {
    public static int a[] = new int[10000];
    
    public static void sieve(){
        Arrays.fill(a,1);
        a[0] = a[1] = 0;
        for(int i = 2 ; i <= 100 ; i++){
            if(a[i] == 1){
                for(int j = i*i ; j < 10000 ; j += i){
                    a[j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        List<Integer> list = (List<Integer>) ois.readObject();
        int cnt[] = new int[10000];
        for(Integer i:list){
            cnt[i] += a[i];
        }
        for(int i = 2 ; i < 10000 ; i++){
            if(cnt[i] > 0){
                System.out.println(i + " " + cnt[i]);
            }
        }
        ois.close();
    }
}
