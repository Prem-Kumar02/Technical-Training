
public class factorial {
  public static int factorial(int n){
    if(n==0 || n==1) return 1;
    return n*factorial(n-1);
  }
  public static void main(String[] args) {
    int n = 5; // Example input
    System.out.println("Factorial of " + n + " is: " + factorial(n));
  }
}
