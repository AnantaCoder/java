import java.util.Scanner;

// eception handling in java 
class Factorial {

    public static int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();
            if (n < 0)  throw new Exception("Factorial is not defined for negative numbers");
            int result = fact(n);
            System.out.println("Factorial = " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}