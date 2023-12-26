import java.util.Scanner;

class giaoVien{
    private String ma,ten;
    private long luong,phuCap,tongLuong;
    
    public giaoVien(String ma, String ten,long tongLuong){
        this.ma = ma;
        this.ten = ten;
        this.tongLuong = tongLuong;
        
        phuCap = Long.parseLong(ma.substring(2));
        if(ma.substring(0, 2).equals("HT")){
            luong = 2000000;
        }
        else if(ma.substring(0, 2).equals("HP")){
            luong = 900000;
        }
        else if(ma.substring(0, 2).equals("GV")){
            luong = 500000;
        }
    }
    
    public long getLuong(){
        return tongLuong*phuCap + luong;
    }
    
    public void in(){
        System.out.println(ma + " " + ten + " " + phuCap + " " + luong + " " +  getLuong());
    }
}
public class J04015 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String ma = sc.nextLine();
        String ten = sc.nextLine();
        Long luong = Long.parseLong(sc.nextLine());
        giaoVien a = new giaoVien(ma,ten,luong);
        a.in();
        sc.close();
    }
}
