import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class danhSach  {

    public String ten, mon, last;
    public String id;
    public static int cnt = 1;

    public danhSach(String ten, String mon) {
        this.id = "GV" + String.format("%02d", cnt++);
        this.ten = ten;
        this.mon = chuanHoa(mon);

    }

    public String chuanHoa(String s) {
        StringBuilder sb = new StringBuilder("");
        String a[] = s.trim().split(" ");
        for (String x : a) {
            sb.append(Character.toUpperCase(x.charAt(0)));
            for (int i = 1; i < x.length(); i++) {
                if (x.charAt(i - 1) == ' ') {
                    sb.append(Character.toUpperCase(x.charAt(i)));
                }
            }
        }
        return sb.toString();
    }
    
    public String getTen(String s){
        String a[] = s.trim().split("\\s+");
        return a[a.length-1];
    }
    
   
    @Override
    public String toString() {
        return id + " " + ten + " " + mon;
    }

}

public class J05027 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<danhSach> list = new ArrayList<>();
        while (t-- > 0) {
            String ten = sc.nextLine();
            String mon = sc.nextLine();
            list.add(new danhSach(ten,mon));
        }
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0){
            String s = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + s + ":");
            s = s.toLowerCase();
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i).ten.toLowerCase().contains(s)){
                    System.out.println(list.get(i));
                }
            }
        }
        sc.close();
    }
}
