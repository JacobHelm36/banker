import java.util.Scanner;

class QuickStart {
  public static void main(String[] args) {
    System.out.println("Hello, world.");
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter a number");
    int a = scanner.nextInt();
    System.out.println("value = "+a);
  }
}