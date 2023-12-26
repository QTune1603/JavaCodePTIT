import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone77 implements Comparable<anyone77> {
    private String idKv, Name;
    private double m1, m2, m3;
    private double addM;
    private double totalMark;

    public anyone77(String idKv, String Name, double m1, double m2, double m3) {
        this.idKv = idKv;
        this.Name = Name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.addM = findAddM();
        this.totalMark = m1 * 2 + m2 + m3 + addM;
    }
    
    public double findAddM() {
        char c = idKv.charAt(2);
        return c == '1' ? 0.5 : c == '2' ? 1.0 : 2.5;
    }

    public double getTotalMark() {
        return totalMark;
    }
    
    @Override
    public int compareTo(anyone77 other) {
        if (this.totalMark != other.totalMark) {
            if (this.totalMark > other.totalMark) {
                return -1;
            } else 
                return 1;
        }
        return this.idKv.compareTo(other.idKv);
    } 
    
    
    
    @Override
    public String toString() {
        return idKv + " " + Name + " " + new DecimalFormat().format(addM) + " " + new DecimalFormat().format(totalMark) + " ";
    }
}
public class J05059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<anyone77> arr = new ArrayList<>();
        
        for (int i = 0 ; i < n; i++) {
            String idKv = sc.next();
            sc.nextLine();
            String Name = sc.nextLine();
            double m1 =sc.nextDouble();
            double m2= sc.nextDouble();
            double m3= sc.nextDouble();
            
            arr.add(new anyone77(idKv, Name, m1, m2, m3));
        }
        
        Collections.sort(arr);
        
        n = sc.nextInt();
     
        double basedMark = arr.get(n - 1).getTotalMark();
        System.out.printf("%.1f",basedMark);
        System.out.println("");
        for (anyone77 tmp : arr) {
            if (tmp.getTotalMark() >= basedMark) {
                System.out.println(tmp + "TRUNG TUYEN");
                
            } else {
                System.out.println(tmp + "TRUOT");
            }
        }
        sc.close();
        
    }
}
