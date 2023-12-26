import java.util.ArrayList;
import java.util.Scanner;

class phongBan {
    private String Ma, Ten;
    
    public phongBan(String line) {
        this.Ma = line.substring(0, 2);
        this.Ten = line.substring(3);
    }

    public String getMa() {
        return Ma;
    }

    public String getTen() {
        return Ten;
    }
            
}

class nhanVien {
    private String maNv, Ten;
    private int luongCoBan, soNgay;
    private int tongLuong;
    public nhanVien(String maNv, String Ten, int luongCoBan, int soNgay) {
        this.maNv = maNv;
        this.Ten = Ten;
        this.luongCoBan = luongCoBan;
        this.soNgay = soNgay;
        this.tongLuong = findTongLuong();
    }

    public String getMaNv() {
        return maNv;
    }

    public String getTen() {
        return Ten;
    }

    public int getTongLuong() {
        return tongLuong;
    }
    
    public int findTongLuong() {
        int res = 1000;
        int heSo;
        int soNam = Integer.parseInt(maNv.substring(1,3));
        int Nhom = maNv.charAt(0) - 'A' + 1;
        
        int[][] a = new int[15][100];
        for (int j =1;j<=3;j++) {
            a[1][j]= 10;
            a[2][j] = 10;
            a[3][j] = 9;
            a[4][j] = 8;
        }
        for (int j =4;j<=8;j++) {
            a[1][j]= 12;
            a[2][j] = 11;
            a[3][j] = 10;
            a[4][j] = 9;
        }
        
        for (int j =9;j<=15;j++) {
            a[1][j]= 14;
            a[2][j] = 13;
            a[3][j] = 12;
            a[4][j] = 11;
        }
        for (int j =16;j<100;j++) {
            a[1][j]= 20;
            a[2][j] = 16;
            a[3][j] = 14;
            a[4][j] = 13;
        }
            
            
       heSo = a[Nhom][soNam];
       
       return heSo * res * luongCoBan * soNgay;
       
    }
    
  
}
public class TN02012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<phongBan> dsPb = new ArrayList<>();
        ArrayList<nhanVien> dsNv = new ArrayList<>();
        sc.nextLine();
        for (int i=0;i<n;i++) {
            String line = sc.nextLine();
            dsPb.add(new phongBan(line));
        }
        int m = sc.nextInt();
        for (int i =0;i<m;i++) {
            String a = sc.next();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            dsNv.add(new nhanVien(a, b, c, d));
            
            
        }
        
        for (nhanVien x: dsNv) {
            System.out.print(x.getMaNv() + " " + x.getTen() + " ");
            for (phongBan y: dsPb) {
                if (x.getMaNv().substring(3).equals(y.getMa())) {
                    System.out.print(y.getTen() + " ");
                    break;
                }
            }
            System.out.println(x.getTongLuong());
            
        }
        
        sc.close();
    }
}
