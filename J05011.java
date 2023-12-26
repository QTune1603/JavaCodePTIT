import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class tinhTien implements Comparable<tinhTien>{
    public String ma,ten,gioVao,gioRa;
    public int time;

    public tinhTien(String ma, String ten, String gioVao, String gioRa) {
        this.ma = ma;
        this.ten = ten;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        
        time = 60 * (Integer.parseInt(gioRa.substring(0,2)) - Integer.parseInt(gioVao.substring(0,2)))+ (Integer.parseInt(gioRa.substring(3)) - Integer.parseInt(gioVao.substring(3)));
    }
    
    public String getTime() {
        int h = time / 60;
        int m = time % 60;
        return String.format("%d gio %d phut", h, m);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + getTime();
    }

    @Override
    public int compareTo(tinhTien o) {
        return -(this.time - o.time);
    }
    
}

public class J05011 {
    public static void main(String[] args) throws FileNotFoundException, ParseException  {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<tinhTien> list = new ArrayList<>();
        while(t-- > 0){
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String gioVao = sc.nextLine();
            String gioRa = sc.nextLine();
            list.add(new tinhTien(ma,ten,gioVao,gioRa));
        }
        Collections.sort(list);
        for(tinhTien x:list){
            System.out.println(x);
        }
        sc.close();
    }
}
