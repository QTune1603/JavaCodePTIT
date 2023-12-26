import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class thiSinh implements Comparable<thiSinh>{
    private String Ten, diaChi;
    private Date d1;
    private int vantoc;
    private String ma;

    public thiSinh(String ten, String diaChi, Date d1) throws Exception {
        this.Ten = ten;
        this.diaChi = diaChi;
        this.d1 = d1;
        this.ma = findMa();
        this.vantoc = findVanToc();
    }

    public String findMa() {
        String res = "";
        String tmp = diaChi + " " + Ten;

        String[] words = tmp.split("\\s+");
        for (String word: words) {
            res += word.charAt(0);
        }
        return res;
    }

    public int findVanToc () throws Exception {

        Date d0 = new SimpleDateFormat("h:mm").parse("6:00");
        double diff = (double) (d1.getTime() - d0.getTime()) / (double) (1000 * 60 * 60);
//        System.out.println(diff);
        double tmp = (double)120 / diff;
        return (int) Math.round(tmp);
    }
    @Override
    public int compareTo (thiSinh other) {
        return this.d1.compareTo(other.d1);
    }

    @Override
    public String toString () {
        return ma + " " + Ten + " " + diaChi + " " + vantoc + " Km/h";
    }
}
public class J05015 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<thiSinh > arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String a = sc.nextLine();
            String b = sc.nextLine();
            Date c = new SimpleDateFormat("h:mm").parse(sc.next());

            arr.add(new thiSinh(a, b,c));
        }

        Collections.sort(arr);

        for(thiSinh x : arr) {
            System.out.println(x);
        }
        sc.close();
    }
}
