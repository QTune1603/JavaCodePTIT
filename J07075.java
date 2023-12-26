import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class mon {
    String maMon, tenMon;
    int soTinChi;

    public mon(String maMon, String tenMon, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getMaMon() {
        return maMon;
    }
    
    
}


class lich implements Comparable<lich> {
    static int id = 1;
    String idLich;
    String maMon;
    int thu, kip;
    String ten, phongHoc;
    String tenMon;

    public lich(String maMon, int thu, int kip, String ten, String phongHoc) {
        this.idLich = "HP" + (id < 10 ? "00" : id < 100 ? "0" : "") + String.valueOf(id);
        id++;
        this.maMon = maMon;
        this.thu = thu;
        this.kip = kip;
        this.ten = ten;
        this.phongHoc = phongHoc;
    }

    public String getMaMon() {
        return maMon;
    }
    
    public void setTenMon(mon x) {
        this.tenMon = x.getTenMon();
    }

//    Sắp xếp theo thời gian giảng dạy, từ đầu tuần đến cuối tuần. Nếu cùng kíp học thì sắp xếp theo họ tên giảng viên (thứ tự từ điển).

    @Override
    public int compareTo(lich o) {
        if (this.thu != o.thu)
            return this.thu - o.thu;
        if (this.kip != o.kip)
            return this.kip - o.kip;
        return this.ten.compareTo(o.ten);
    }

    public String getTen() {
        return ten;
    }
//HP002 Phat trien ung dung cho cac thiet bi di dong 2 2 105-A2
    @Override
    public String toString() {
        
        return idLich + " " + tenMon + " " + thu + " " + kip + " " + phongHoc;

        
    }
}
public class J07075 {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("LICHGD.in"));

        int n = sc1.nextInt();
        ArrayList<mon> monhocs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String maMon = sc1.next();
            sc1.nextLine();
            String tenMon = sc1.nextLine();
            int soTinChi = sc1.nextInt();
            monhocs.add(new mon(maMon, tenMon, soTinChi));
        }

        int m = sc2.nextInt();
        ArrayList<lich> lichs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String maMon = sc2.next();
            int thu = sc2.nextInt();
            int kip = sc2.nextInt();
            sc2.nextLine();
            String ten = sc2.nextLine();
            String phongHoc = sc2.nextLine();
            lichs.add(new lich(maMon, thu, kip, ten, phongHoc));
        }


        String name = sc2.nextLine();

        System.out.print("LICH GIANG DAY GIANG VIEN ");
        System.out.println(name + ":");
        
        Collections.sort(lichs);
        
        for (lich x: lichs) {
            for(mon y: monhocs) {
                if (x.getMaMon().equals(y.getMaMon())) {
                    x.setTenMon(y);
                }
            }
        }
        
        for (lich x: lichs) {
            if (x.getTen().equals(name)) {
                System.out.println(x);
            }
        }
        
    }
}
