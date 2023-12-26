import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone71 implements Comparable<anyone71> {
    private static int id = 1;
    private String idEmployee, Name;
    private double Lt, Th, Avg;
    private String Assessment;
    public anyone71(String Name, String Lt, String Th) {
        this.idEmployee = "TS" + (id > 9 ? "" : "0") + String.valueOf(id);
        id ++;
        this.Name = Name;
        
        double M1 = Double.parseDouble(Lt);
        double M2 = Double.parseDouble(Th);
        
        if (M1 > 10) 
            this.Lt = M1/10;
        else 
            this.Lt = M1;
        if (M2 > 10) 
            this.Th = M2/10;
        else
            this.Th = M2;
        
        this.Avg = (this.Lt + this.Th) / 2;
        this.Assessment = Avg < 5 ? "TRUOT" : Avg < 8 ? "CAN NHAC" : Avg <= 9.5 ? "DAT" : "XUAT SAC";  
        
    }
    
    @Override 
    public int compareTo (anyone71 other) {
        if (this.Avg > other.Avg) 
            return -1;
        else if (this.Avg < other.Avg)
            return 1;
        else 
            return 0;
        
    }
    
    @Override
    public String toString () {
        return idEmployee + " " + Name + " " + String.format("%.2f", Avg) + " " + Assessment;
    }
}
public class J05013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        ArrayList<anyone71> arr = new ArrayList<>();
        
        for (int i = 0;i < n;i ++) {
            sc.nextLine();
            String name = sc.nextLine();
            String Lt = sc.next();
            String Th = sc.next();
            
            arr.add(new anyone71(name, Lt, Th));
        }
        
        Collections.sort(arr);
        
        for (anyone71 tmp : arr) {
            System.out.println(tmp);
        }
        sc.close();
    }
}
