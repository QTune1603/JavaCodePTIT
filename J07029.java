import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J07029 {
    public static final int n = (int)1000006;
    public static int a[] = new int[n+1];
    
    public static void sieve(){
        Arrays.fill(a,1);
        a[0] = a[1] = 0;
        for(int i = 2 ; i <= (int)1000 ; i++){
            if(a[i] == 1){
                for(int j = i*i ; j <= n ; j += i){
                    a[j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> list = (ArrayList<Integer>) ois.readObject();
        int cnt[] = new int[n+1];
        for(Integer i:list){
            cnt[i] += a[i];
        }
        int dem = 0;
        for(int i = n ; i >= 2 ; i--){
            if(cnt[i] > 0){
                System.out.println(i + " " + cnt[i]);
                dem++;
                if(dem == 10){
                    break;
                }
            }
        }
        ois.close();
    }
}
