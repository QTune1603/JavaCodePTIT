import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class sv1 {
    private static int id = 0;
    private int idv = 0;
    private String name,cls,dob;
    private double gpa;

    public sv1(String name, String cls, String dob, double gpa) {
        this.idv = ++id;
        this.name = name;
        this.cls = cls;
        this.dob = standardlizeDob(dob);
        this.gpa = gpa;
    }
    
    public String standardlizeDob(String dob){
        StringBuilder sb = new StringBuilder(dob);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }
    
    public String toString(){
        if(idv > 9){
            return "B20DCCN0" + idv + " " + name + " " + cls + " " + dob + " " + String.format("%.2f",gpa);
        }
        else {
            return "B20DCCN00" + idv + " " + name + " " + cls + " " + dob + " " + String.format("%.2f",gpa);
        }
    }
}
public class J07010 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SV.in"));
        int n = sc.nextInt();
        ArrayList<sv1> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            sc.nextLine();
            String name = sc.nextLine();
            String cls = sc.next();
            String dob = sc.next();
            double gpa = sc.nextDouble();
            list.add(new sv1(name,cls,dob,gpa));
        }
        for(sv1 x:list){
            System.out.println(x);
        }
    }
}
