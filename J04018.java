import java.util.Scanner;

class soPhuc{
    private int real,imaginary;

    public soPhuc(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public static soPhuc sum(soPhuc a, soPhuc b){
        return new soPhuc(a.real + b.real, a.imaginary + b.imaginary );
    }
    
    public static soPhuc mul(soPhuc a,soPhuc b){
        return new soPhuc(a.real * b.real - a.imaginary * b.imaginary,a.imaginary * b.real + a.real*b.imaginary);
    }
    
    @Override
    public String toString(){
        String res = "";
        res += real + " ";
        if(imaginary >= 0){
            res += "+ " + imaginary + "i";
        }
        else {
            res += "- " + (-imaginary) + "i";
        }
        return res;
    }
}

public class J04018 {
    static Scanner sc = new Scanner(System.in);
    public static void solve(){
        soPhuc a = new soPhuc(sc.nextInt(),sc.nextInt());
        soPhuc b = new soPhuc(sc.nextInt(), sc.nextInt());
        
        soPhuc sumid = soPhuc.sum(a, b);
        
        soPhuc c = soPhuc.mul(sumid,a);
        
        soPhuc d = soPhuc.mul(sumid, sumid);
        
        System.out.println(c+ ", " + d);
    }
    
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0){
            solve();
        }
    }
}
