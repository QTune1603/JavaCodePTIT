import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone75 implements Comparable<anyone75>{
    
    private static int id = 1;
    private String idKh;
    private String Name;
    private int cu, moi;
    private long Price;
    
    public anyone75(String Name, int cu, int moi) {
        this.idKh = "KH" + (id > 9 ? "" : "0") + String.valueOf(id);
        id++;
        this.Name = Name;
        this.cu = cu;
        this.moi = moi;
        this.Price = findPrice();
    }
    
    public long findPrice() {
        long chiSo = moi - cu;
        long res;
       
        if (chiSo <= 50) res = chiSo * 100 + chiSo * 2;
        else if (chiSo <= 100) res = Math.round((5000 + (chiSo -50) * 150) + (5000 + (chiSo - 50)* 150) *0.03);
        else res = Math.round((12500 + (chiSo  - 100) * 200) + (12500 + (chiSo - 100) * 200) * 0.05);
        return res;
    }
    
    @Override
    public int compareTo (anyone75 other) {
        if (this.Price > other.Price)
            return -1;
        else if (this.Price < other.Price)
            return 1;
        return 0;            
                    
        
    }
    
    @Override
    public String toString () {
        return idKh + " " + Name + " " + Price;
    }
    
}
public class J05017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<anyone75> arr = new ArrayList<>();
        
        for (int i = 0;i < n; i++) {
            sc.nextLine();
            String Name = sc.nextLine();
            int cu = sc.nextInt();
            int moi = sc.nextInt();
            
            arr.add(new anyone75(Name, cu, moi));
        }
        
        Collections.sort(arr);
        
        for (anyone75 tmp: arr) {
            System.out.println(tmp);
        }
        sc.close();
    }
}
