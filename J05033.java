import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class time implements Comparable<time>{
    private int h,m,s;

    public time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }
    
    @Override
    public int compareTo(time p){
        int s1 = h*3600 + m*60 + s;
        int s2 = p.getH()*3600 + p.getM()*60 + p.getS();
        return s1-s2;
    }

    @Override
    public String toString() {
        return h + " " + m + " " + s;
    }
    
    
}
public class J05033 {
    public static void main(String[] args) throws FileNotFoundException  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<time> list = new ArrayList<>();
        while(t-- > 0){
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            list.add(new time(h,m,s));
        }
        Collections.sort(list);
        for(time x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
