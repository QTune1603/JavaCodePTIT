import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class anyone76 {
    private static int id = 1;
    private String idT;
    private String Name;
    private int timeQuantity, Precipitation;
    private double avgQ;

    public anyone76(String Name) {
        this.Name = Name;
    }

    public anyone76(String Name, int timeQuantity, int Precipitation) {
        this.idT = "T" + (id > 9 ? "" : "0") + String.valueOf(id);
        id++;
        this.Name = Name;
        this.timeQuantity = timeQuantity;
        this.Precipitation = Precipitation;
        
    }

    public String getName() {
        return Name;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        anyone76.id = id;
    }

    public int getTimeQuantity() {
        return timeQuantity;
    }

    public void setTimeQuantity(int timeQuantity) {
        this.timeQuantity = timeQuantity;
    }

    public int getPrecipitation() {
        return Precipitation;
    }

    public void setPrecipitation(int Precipitation) {
        this.Precipitation = Precipitation;
    }
    
    public double findAvgQ() {  
        return (double) Precipitation / ((double)timeQuantity / (double)60);
    }
    
    @Override 
    public String toString () {
        return idT + " " + Name + " " + String.format("%.2f", findAvgQ());
    }
    
}
public class J05019 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<anyone76> arr = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        
        for (int i = 0; i < n;i ++) {
            sc.nextLine();
            String Name = sc.nextLine();
            Date Start = sdf.parse(sc.next());
            Date End = sdf.parse(sc.next());
            int Precipitation = sc.nextInt();
            
            long mili = (End.getTime() - Start.getTime()) / (1000 * 60);
            
            int time = (int) mili;   
            
            boolean d = true;
            for (anyone76 x : arr) {
                if (x.getName().equals(Name)) {
                    x.setPrecipitation(x.getPrecipitation() + Precipitation);
                    x.setTimeQuantity(x.getTimeQuantity() + time);
                    d= false;
                    break;
                }
                
            }
            
            if (d) {
                arr.add(new anyone76(Name, time, Precipitation));
            }
        }
        
       
        
        for (anyone76 tmp: arr) {
            System.out.println(tmp);
        }
        sc.close();
    }
}
