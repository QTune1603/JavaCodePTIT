import java.util.Scanner;

class Rectange{
    private double width,height;
    private String color;
    
    public Rectange(){
        width = 1;
        height = 1;
    }

    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public String getColor() {
        return color.substring(0,1).toUpperCase() + color.substring(1).toLowerCase();
    }

    public double findArea(){
        return width*height;
    }
    
    public double findPerimeter(){
        return (width+height)*2;
    }

    @Override
    public String toString() {
        return String.format("%d %d %s",(int)findPerimeter(), (int)findArea(), getColor());
    }
    
    
}

public class J04002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        String s = sc.next();
        if(x > 0 && y > 0){
            Rectange a = new Rectange(x,y,s);
            System.out.println(a);
        }
        else System.out.println("INVALID");
        sc.close();
    }
}
