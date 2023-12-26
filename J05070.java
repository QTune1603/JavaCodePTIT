import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class doiTuyen {
    private String id;
    private String Ten;
    
    private int gia;

    public doiTuyen(String id, String Ten, int gia) {
        this.id = id;
        this.Ten = Ten;
        this.gia = gia;
    }

    public String getId() {
        return id;
    }

    public String getTen() {
        return Ten;
    }

    public int getGia() {
        return gia;
    }
    
}

class tranDau implements Comparable<tranDau>{
    private String maTran;
    private int soCDV;
    private doiTuyen x;
    private int Gia;
    public tranDau(String line) {
       String[] words = line.split("\\s+");
       
       this.maTran = words[0];
       this.soCDV = Integer.parseInt(words[1]);
       
       String k = maTran.substring(1, 3);
       
       
    }

    public void setX(doiTuyen x) {
        this.x = x;
    }

    public String getMaTran() {
        return maTran;
    }

    public int getSoCDV() {
        return soCDV;
    }

    public doiTuyen getX() {
        return x;
    }

    public void findGia() {
        int res = 0;
        res = soCDV * x.getGia();
        this.Gia = res;
    }
    
    @Override
    public int compareTo(tranDau other) {
        return other.Gia - this.Gia;
    }
    
    @Override
    public String toString () {
        return maTran + " " + x.getTen() + " " + Gia;
    }
}
public class J05070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<doiTuyen> arr = new ArrayList<>();
        
        for (int i =0;i<n;i++) {
            String a = sc.next();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            
            arr.add(new doiTuyen(a, b, c));
        }
        
        int m = sc.nextInt();
        
        ArrayList<tranDau> trandau = new ArrayList<>();
        sc.nextLine();
        for (int i = 0;i<m;i++) {
            String line = sc.nextLine();
            trandau.add(new tranDau(line));
        }
        
        for (tranDau x : trandau) {
            String ma = x.getMaTran().substring(1,3);
            
            for (doiTuyen y: arr) {
                if (ma.equals(y.getId())) {
                    x.setX(y);
                    x.findGia();
                    break;
                }
            }
            
        }
        Collections.sort(trandau);
        
        for (tranDau x: trandau) {
            System.out.println(x);
        }
        sc.close();
        
    }
}
