import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

class anyone64 implements Comparable<anyone64> {
    private static int id = 1;
    private int idvdv;
    private String name;
    private Date dob;
    private Date begin;
    private Date end;
    private int tguutien;
    private String tgChay;
    private String  tgTinh;
    private int rank;




    public anyone64(String name, String dob, String date1, String date2) throws Exception {

        this.idvdv = id++;
        this.name = name;
        this.dob = standardlizeDate(dob);
        this.begin = standardLizeTime(date1);
        this.end  = standardLizeTime(date2);
        this.tguutien = getTguutien();
        this.tgChay = getTgchay();
        this.tgTinh= getTgTinh();
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
    public Date standardlizeDate (String dob) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(dob);
    }


    public Date standardLizeTime (String time) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.parse(time);
    }

    public int getTguutien() {
        int age = 121 - dob.getYear();
        if(age < 18)
            return 0;
        else if (age < 25)
            return 1;
        else if (age < 32)
            return 2;
        else
            return 3;
    }

    private String formatTime(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
    }

    public String getTgchay() {
         long actualTimeInSeconds = (end.getTime() - begin.getTime()) / 1000;
         return formatTime((int) actualTimeInSeconds);
    }

    public String getTgTinh() {
        long actualTimeInSeconds = (end.getTime() - begin.getTime()) / 1000;
        return formatTime((int) (actualTimeInSeconds - tguutien));
    }

    @Override
    public int compareTo(anyone64 other) {
        return this.tgTinh.compareTo(other.tgTinh);
    }


    @Override
    public String toString() {
        if (idvdv > 9)
            return "VDV" + idvdv + " " + name  + " " + tgChay + " " + formatTime(tguutien) + " " + tgTinh + " " + rank;
        else
            return "VDV0" + idvdv + " " + name + " " + tgChay + " " + formatTime(tguutien) + " " + tgTinh + " " + rank;
    }

}
public class J05055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<anyone64> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String dob = scanner.nextLine();
            String date1 = scanner.nextLine();
            String date2 = scanner.nextLine();
            try {
                arr.add(new anyone64(name, dob, date1, date2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ArrayList<anyone64> arr1 = new ArrayList<>(arr);

        Collections.sort(arr);

        int cnt = 1;
        int ind = 1;
        for (anyone64 x: arr) {
            x.setRank(cnt);
            if (ind < arr.size() && !x.getTgTinh().equals(arr.get(ind++).getTgTinh()))
                cnt = ind;

        }

        for (anyone64 x: arr1) {
            x.setRank(arr.get(arr.indexOf(x)).getRank());
            System.out.println(x);
        }

        scanner.close();
    }
}
