import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class anyone46 {
    private String idJob, name;
    private int basicSalary;

    public anyone46 (String idJob, String name, int basicSalary) {
        this.idJob = idJob;
        this.name = name;
        this.basicSalary = basicSalary;

    }

    public int addSalary () {
        if (idJob.substring(0,2).equals("HT"))
            return 2000_000;
        else if (idJob.substring(0,2).equals("HP"))
            return 900_000;
        return 500_000;
    }

    public int sumSalary () {
        return basicSalary * Integer.parseInt(this.idJob.substring(2,4)) + addSalary();
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", idJob, name, Integer.parseInt(idJob.substring(2,4)), this.addSalary(), sumSalary());
    }
}
public class J05064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ArrayList<anyone46> list = new ArrayList<>();
        scanner.nextLine();

        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < t; i++) {
            String idJob = scanner.nextLine();
            if (mp.containsKey(idJob.substring(0,2))) {
                mp.put(idJob.substring(0,2), mp.get(idJob.substring(0,2)) + 1);
            }
            else
                mp.put(idJob.substring(0,2), 1);
            String name = scanner.nextLine();

            int basicSalary = scanner.nextInt();
            scanner.nextLine();
            if ((idJob.substring(0,2).equals("HT") && mp.get(idJob.substring(0,2)) > 1) || (idJob.substring(0,2).equals("HP") && mp.get(idJob.substring(0,2)) > 2))
                continue;
            list.add(new anyone46(idJob, name, basicSalary));

        }

        for (anyone46 anyone46 : list) {
            System.out.println(anyone46);
        }
        scanner.close();
    }
}
