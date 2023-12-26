import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone78 implements Comparable<anyone78> {
    private String Name;
    private double gpa;
    private int renLuyen;
    private String Assessment;

    public anyone78(String Name , String line) {
        this.Name = Name;
        String[] mark = line.split("\\s+");
        this.gpa = Double.parseDouble(mark[0]);
        this.renLuyen = Integer.parseInt(mark[1]);
        this.Assessment = gpa >= 3.6 && renLuyen >= 90 ? "XUATSAC": gpa >= 3.2 && renLuyen >= 80 ? "GIOI" : gpa >= 2.5 && renLuyen >= 70 ? "KHA" : "KHONG";
        
        
    }

    public double getGpa() {
        return gpa;
    }
    
    @Override
    public int compareTo ( anyone78 other) {
        if (this.gpa > other.gpa) {
            return -1;
        } else if (this.gpa < other.gpa) {
            return 1;
        }
        return 0;
    }

    public String getAssessment() {
        return Assessment;
    }
    
    
    @Override
    public String toString () {
        return Name + ": ";
    }
}
public class J05062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        ArrayList<anyone78> arr = new ArrayList<>();
        ArrayList<anyone78> arrayList = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String Name = sc.nextLine();
            String line = sc.nextLine();
            
            arr.add(new anyone78(Name, line));
            arrayList.add(new anyone78(Name, line));
        }
        
        Collections.sort(arrayList);
        double basedMark = arrayList.get(m-1).getGpa();
//        System.out.println(basedMark);
        for (anyone78 tmp : arr) {
            if (tmp.getGpa() >= basedMark) {
                System.out.println(tmp + tmp.getAssessment());
            } else {
                System.out.println(tmp + "KHONG");
            }
        }
        sc.close();
    }
}
