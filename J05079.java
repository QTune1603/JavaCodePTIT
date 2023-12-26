import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class hoc_phan<T1> implements Comparable<hoc_phan> {
    
    private T1 codeSub, groupClass, nameSub, nameTeacher;
    
    
    public hoc_phan (T1 codeSub, T1 nameSub, T1 groupClass, T1 nameTeacher) {
        this.codeSub = codeSub;
        this.nameSub = nameSub;
        this.groupClass = groupClass;
        this.nameTeacher = nameTeacher;
    }
    
    public T1 getCodeSub() {
        return this.codeSub;
    }
    
    public T1 getNameSub() {
        return this.nameSub;
    }
    
    public int compareTo (hoc_phan other) {
        String s1 = (String) this.groupClass;
        String s2 = (String) other.groupClass;
        return s1.compareTo(s2);
    }
    
    @Override
    public String toString() {
        return this.groupClass + " " + this.nameTeacher;
    }
}

public class J05079 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<hoc_phan> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String codeSub = scanner.nextLine();
            String nameSub = scanner.nextLine();
            String groupClass = scanner.nextLine();
            String nameTeacher = scanner.nextLine();
            
            list.add(new hoc_phan<>(codeSub,nameSub, groupClass, nameTeacher));
            
        }
        
        Collections.sort(list);
        
        int m = scanner.nextInt();
        
        for (int i = 0; i < m; i++) {
            String codeSub = scanner.next();
            System.out.print("Danh sach nhom lop mon ");
            boolean d = true;
            for (hoc_phan<String> x : list) {
                
                if (x.getCodeSub().equals(codeSub)) {
                    if (d) {
                        System.out.println(x.getNameSub() + ":");
                        d = false;
                    }
                    System.out.println(x);
                }
            }
            
        }
        scanner.close();
    }
    
}
