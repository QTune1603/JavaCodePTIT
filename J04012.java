import java.util.Scanner;

class tinhCong{
    private String id,ten,chucVu;
    private int luong,phuCap,luongThuong;

    public tinhCong(String ten, String chucVu, int luongCoBan, int soNgay) {
        this.ten = ten;
        this.id = "NV01";
        
        this.luong = luongCoBan * soNgay;
        if(soNgay >= 25){
            this.luongThuong = (int)(luong * 0.2f);
        }
        else if(soNgay >= 22 && soNgay <= 25){
            this.luongThuong = (int)(luong * 0.1f);
        }
        else {
            this.luongThuong = 0;
        }
        if(chucVu.equals("GD")){
            phuCap = 250000;
        }
        else if(chucVu.equals("PGD")){
            phuCap = 200000;
        }
        else if(chucVu.equals("TP")){
            phuCap = 180000;
        }
        else if(chucVu.equals("NV")){
            phuCap = 150000;
        }
    }
    
    public int getLuong(){
        return luong + luongThuong + phuCap;
    }
    public void in(){
        System.out.println(id + " " + ten + " " + luong + " " + luongThuong + " " + phuCap + " " + getLuong());
    }
    
}
public class J04012 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String ten = sc.nextLine();
        int luongCoBan = Integer.parseInt(sc.nextLine());
        int soNgay = Integer.parseInt(sc.nextLine());
        String chucVu = sc.nextLine();
        tinhCong a = new tinhCong(ten,chucVu,luongCoBan,soNgay);
        a.in();
        sc.close();
    }
}
