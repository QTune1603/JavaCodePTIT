import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class sinhV implements Comparable<sinhV> {
    private String ma, ten, lop, email;

    public sinhV(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = normal(ten);
        this.lop = lop;
        this.email = email;
    }

    public String normal(String x){
        String res = "";
        String[] words = x.trim().split("\\s+");
        for(String word : words) {
            res += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }

    @Override
    public int compareTo(sinhV other) {
        return this.ma.compareTo(other.ma);
    }

    @Override
    public String toString () {
        return ma + " " + ten + " " +lop;
    }
}

class Dn {
    private String ma, ten;
    private int soSv;
    private ArrayList<String > dsSv;

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getSoSv() {
        return soSv;
    }

    public ArrayList<String> getDsSv() {
        return dsSv;
    }

    public Dn(String ma, String ten, int soSv) {
        this.dsSv = new ArrayList<>();
        this.ma = ma;
        this.ten = ten;
        this.soSv = soSv;
    }

//    @Override
//    public
}

class dangKy {
    private sinhV sinhV;
    private Dn dn;

    public dangKy(sinhV sinhV, Dn dn) {
        this.sinhV = sinhV;
        this.dn = dn;
    }
}

public class J07038 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("DN.in"));
        Scanner sc3 = new Scanner(new File("THUCTAP.in"));
        int n = sc1.nextInt();
        ArrayList<sinhV> arr1 = new ArrayList<>();
        Map<String, sinhV> m1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = sc1.next();
            sc1.nextLine();
            String b = sc1.nextLine();
            String c = sc1.next();
            String d = sc1.next();
            sinhV x = new sinhV(a, b,c,d);
            arr1.add(x);
            m1.put(a, x);
        }



        Collections.sort(arr1);
        int m = sc2.nextInt();
        Map<String, Dn> map1 = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String a = sc2.next();
            sc2.nextLine();
            String b = sc2.nextLine();
            int c = sc2.nextInt();

            Dn x = new Dn(a ,b ,c);
            map1.put(a, x);


        }

        int q = sc3.nextInt();
        sc3.nextLine();
        for (int i = 0; i < q; i++) {
            String line = sc3.nextLine();
            String[] words = line.split("\\s+");

//            if (map1.get(words[1]).getDsSv().size() < map1.get(words[1]).getSoSv())
                map1.get(words[1]).getDsSv().add(words[0]);
        }

        int k = sc3.nextInt();

        for (int i = 0; i < k; i++) {
            String ma = sc3.next();
            System.out.println("DANH SACH THUC TAP TAI " + map1.get(ma).getTen()+":");
            Collections.sort(map1.get(ma).getDsSv());
            int cnt = 0;
            for (String x : map1.get(ma).getDsSv()) {
                if (cnt == map1.get(ma).getSoSv())
                    break;
                System.out.println(m1.get(x));

                cnt++;
            }
        }

    }
}
