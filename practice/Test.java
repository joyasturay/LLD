
package practice;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        double factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial *= i;
        }
        System.out.println("Factorial is " + factorial);


    }
}
