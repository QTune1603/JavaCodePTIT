import java.util.Scanner;

public class J02023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of digits
        int S = scanner.nextInt(); // Required sum

        // Handle special cases
        if (S == 0 && N == 1) {
            System.out.println("0 0");
            return;
        }

        if (S == 0 || S > 9 * N) {
            System.out.println("-1 -1");
            return;
        }

        // Find the smallest number
        int[] smallestNumber = new int[N];
        int remainingSum = S;
        for (int i = 0; i < N; i++) {
            int digit = Math.min(9, remainingSum);
            smallestNumber[i] = digit;
            remainingSum -= digit;
//            System.out.println(digit);
        }

        // Find the largest number
        int[] largestNumber = new int[N];
        remainingSum = S;
//        largestNumber[0] = 1;
//        remainingSum--;

        for (int i = N - 1; i >= 0; i--) {
            int digit = Math.min(9, remainingSum);
            largestNumber[i] = digit;
//            System.out.println(digit);
            remainingSum -= digit;
        }
        if (largestNumber[0] == 0) {
            largestNumber[0] = 1;
            remainingSum = S - 1;
            for (int i = N - 1; i > 0; i--) {
                int digit = Math.min(9, remainingSum);
                largestNumber[i] = digit;
//            System.out.println(digit);
                remainingSum -= digit;
            }
        }

        // Print the results
        StringBuilder smallest = new StringBuilder();
        StringBuilder largest = new StringBuilder();

        for (int digit : smallestNumber) {
//            System.out.println(digit);
            smallest.append(digit);
        }

        for (int digit : largestNumber) {
            largest.append(digit);
        }

        System.out.println(largest.toString() + " " + smallest.toString());
        scanner.close();
    }
}
