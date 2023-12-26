import java.util.Scanner;

class Matrix {
    private int row, col;
    private int [][] mt;

    public Matrix(int row, int col) {
        this.mt = new int[row + 5][col + 5];
        this.row = row;
        this.col = col;
    }
    
    public void nextMatrix(Scanner sc) {
        for (int i = 0;i< row ;i++) {
            for(int j = 0; j< col;j++) {
                mt[i][j] = sc.nextInt();
            }
        }
    }
    
    public Matrix trans() {
        Matrix res = new Matrix(col, row);
        
        for (int i = 0; i < col;i++)
            for (int j = 0; j< row;j++)
                res.mt[i][j] = this.mt[j][i];
        
        return res;
    }
    
    public Matrix mul(Matrix other) {
        int n = this.row;
        int m = this.col;
        int p = other.col;
        Matrix res = new Matrix(n, n);
        
        for (int i = 0; i< n;i++) {
            for (int j = 0;j < p;j++) {
                for(int k = 0; k < m;k ++) {
                    res.mt[i][j] += this.mt[i][k] * other.mt[k][j];
                }
            }
        }
        
        return res;
    }
    
    
    @Override
    public String toString () {
        String res = "";
        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j< col;j++) {
                res += mt[i][j] + " ";
            }
            res += "\n"; 
        }
        return res;
    }
}
public class J04017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
             int n = sc.nextInt(), m = sc.nextInt();
             Matrix a = new Matrix(n,m);
             a.nextMatrix(sc);
             Matrix b = a.trans();
             System.out.println(a.mul(b));
        }
    }
    public static void main2796655(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
             int n = sc.nextInt(), m = sc.nextInt();
             Matrix a = new Matrix(n,m);
             a.nextMatrix(sc);
             Matrix b = a.trans();
             System.out.println(a.mul(b));
        }
    }
}
