import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone70 implements Comparable<anyone70>{

    private String idMh, nameMh;
    private long number, basedVal, discount;
    private long Price;

    public anyone70(String idMh, String nameMh, long number, long basedVal, long discount) {
        this.idMh = idMh;
        this.nameMh = nameMh;
        this.number = number;
        this.basedVal = basedVal;
        this.discount = discount;
        this.Price = findPrice();
    }
    
    public long findPrice() {
        long res = 0;
        res = number * basedVal - discount;
        return res;
    }
    
    @Override
    public int compareTo(anyone70 other) {
        if (other.Price > this.Price)
            return 1;
        else if (other.Price < this.Price)
            return -1;
        else 
            return 0;
    }
    
    @Override
    public String toString () {
        return idMh + " " + nameMh + " " + number + " " + basedVal + " " + discount+ " " + Price;
    }
    
}
public class J05012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        ArrayList<anyone70> arr = new ArrayList<>();
        
        for (int i = 0 ; i < n;i ++) {
            String idMh = sc.next();
            sc.nextLine();
            String nameMh = sc.nextLine();
            long Number = sc.nextLong();
            long basedVal = sc.nextLong();
            long Discount = sc.nextLong();
            
            arr.add(new anyone70(idMh, nameMh, Number, basedVal, Discount));
        }
        
        Collections.sort(arr);
        
        for (anyone70 tmp: arr) {
            System.out.println(tmp);
        }
        sc.close();
    }
}
