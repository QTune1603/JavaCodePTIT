import java.util.ArrayList;
import java.util.Scanner;

class giaoVien{
    private String Ma, Ten;
    private double soGio;
    public giaoVien(String Ma, String Ten) {
        this.Ma = Ma;
        this.Ten = Ten;
    }

    public double getSoGio() {
        return soGio;
    }

    public void setSoGio(double soGio) {
        this.soGio = soGio;
    }
    
    @Override
    public String toString () {
        return Ten + " " + String.format("%.2f", soGio);
    }

    public String getMa() {
        return Ma;
    }
}

class monHoc {
    private String Ma, Ten;

    public monHoc(String Ma, String Ten) {
        this.Ma = Ma;
        this.Ten = Ten;
    }
    
}

class hocPhan {
    private String maGv, maMon;
    private double soGio;

    public hocPhan(String maGv, String maMon, double soGio) {
        this.maGv = maGv;
        this.maMon = maMon;
        this.soGio = soGio;
    }

    public String getMaGv() {
        return maGv;
    }

    public double getSoGio() {
        return soGio;
    }
    
}
public class J06007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList <monHoc> dsMh = new ArrayList<>();
        ArrayList <giaoVien> dsGv = new ArrayList<>();
        ArrayList<hocPhan> dsHp = new ArrayList<>();
        sc.nextLine();
        for (int i=0;i<n;i++) {
            
            String line = sc.nextLine();
            String[] words = line.split("\\s+");
            String a = words[0];
            String b = line.substring(a.length() + 1);
            
            dsMh.add(new monHoc(a, b));
        }
        
        int m = sc.nextInt();
        sc.nextLine();
        for (int i =0;i < m;i++) {
          
            String line = sc.nextLine();
            String[] words = line.split("\\s+");
            String a = words[0];
            String b = line.substring(a.length() + 1);
            
            dsGv.add(new giaoVien(a, b));
        }
        
        int p = sc.nextInt();
        
        for (int i=0;i<p;i++) {
            String a = sc.next();
            String b = sc.next();
            double c = sc.nextDouble();
            
            dsHp.add(new hocPhan(a, b, c));
        }
        
        for (giaoVien x: dsGv) {
           double soGio = 0;
            for (hocPhan y: dsHp) {
                if (x.getMa().equals(y.getMaGv())) {
                    soGio += y.getSoGio();
                }
            }
            x.setSoGio(soGio);
        }
        
        for(giaoVien x : dsGv) {
            System.out.println(x);
        }
        sc.close();
    }
}
