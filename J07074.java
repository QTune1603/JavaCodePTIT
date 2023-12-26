import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class anyone69 {
    private String idSub, nameSub;
    private int credit;

    private ArrayList<anything43> ds;
    
    public anyone69(String idSub, String nameSub, int credit) {
        this.ds = new ArrayList<>();
        this.idSub = idSub;
        this.nameSub = nameSub;
        this.credit = credit;
    }
    

    public String getIdSub() {
        return idSub;
    }

    public void setIdSub(String idSub) {
        this.idSub = idSub;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public void setDs(anything43 x) {
        ds.add(x);
    }
    
   
    public void printString () {
        for (anything43 x : ds)  {
            System.out.println(x);
        }
    }
    
}

class anything43 implements Comparable<anything43> {
    private static int id = 1;
    private int idHp;
    private String idSub;
    private int thu, kip;
    private String nameTeacher, Room;

    public anything43(String idSub, int thu, int kip, String nameTeacher, String Room) {
        this.idHp= id++;
        this.idSub = idSub;
        this.thu = thu;
        this.kip = kip;
        this.nameTeacher = nameTeacher;
        this.Room = Room;
    }

    public String getIdSub() {
        return idSub;
    }

    public void setIdSub(String idSub) {
        this.idSub = idSub;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getKip() {
        return kip;
    }

    public void setKip(int kip) {
        this.kip = kip;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String Room) {
        this.Room = Room;
    }
    
   
    @Override
    public int compareTo(anything43 other) {
        if (this.thu == other.thu) {
            if (this.kip == other.kip)
                return this.nameTeacher.compareTo(other.nameTeacher);
            return this.kip - other.kip;
        }
        return this.thu - other.thu;
    }
    
    @Override
    public String toString () {
        if (idHp > 99)
            return "HP" + idHp + " " + this.thu + " " + this.kip + " " + this.nameTeacher + " " + this.Room;
        if (idHp > 9)
            return "HP0" + idHp + " " + this.thu + " " + this.kip + " " + this.nameTeacher + " " + this.Room;
        return "HP00" + idHp + " " + this.thu + " " + this.kip + " " + this.nameTeacher + " " + this.Room;
 
                
    }
}
public class J07074 {
    public static void main(String[] args)throws Exception {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        Scanner sc2 = new Scanner(new File("LICHGD.in"));
        
        ArrayList<anyone69> arr1 = new ArrayList<>();
        ArrayList<anything43> arr2 = new ArrayList<>();
        
        int n = sc1.nextInt();
        int m = sc2.nextInt();
        
        for (int i = 0; i < n; i++) {
            String id = sc1.next();
            sc1.nextLine();
            String name = sc1.nextLine();
            int credit = sc1.nextInt();
            
            arr1.add(new anyone69(id, name, credit));
        }
        
        for (int i = 0; i < m; i++) {
            String id = sc2.next();
            int thu = sc2.nextInt();
            int kip = sc2.nextInt();
            sc2.nextLine();
            String nameTeacher = sc2.nextLine();
            String Room = sc2.next();
            
            arr2.add(new anything43(id, thu, kip, nameTeacher, Room));
        }
        
        Collections.sort(arr2);
        
        for (anyone69 tmp1 : arr1) {
            for (anything43 tmp2 : arr2) {
                if (tmp1.getIdSub().equals(tmp2.getIdSub())) {
                    tmp1.setDs(tmp2);
                }
            }
        }
        
        String idSub = sc2.next();
        
        System.out.print("LICH GIANG DAY MON ");
        
        for(anyone69 tmp : arr1) {
            if (tmp.getIdSub().equals(idSub)) {
                    System.out.println(tmp.getNameSub() + ":");
                    tmp.printString();
                    break;              
            }
        }
        
        
    }
}
