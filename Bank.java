import java.util.Scanner;

public class Bank {
  public static void main(String[] args) {
    BankAcct obj = new BankAcct("Fellow citizen", "12E44FF12");
    obj.showMenu();

  }
}

class BankAcct 
{
  int balance;
  int previousTransaction;
  String customerName;
  String customerId;

  BankAcct(String cname, String cid)
  {
    customerName = cname;
    customerId = cid;
  }

  void deposit(int amount)
  {
    if(amount !=0)
    {
      balance = balance + amount;
      previousTransaction = amount;
    }
  }

  void withdraw(int amount) 
  {
    balance = balance - amount;
    previousTransaction = -amount;
  }

  void getPreviousTransaction()
  {
    if(previousTransaction > 0)
    {
      System.out.println("Deposited: "+previousTransaction);
    }
    else if(previousTransaction < 0) 
    {
      System.out.println("Withdrawn: " +Math.abs(previousTransaction));
    }
    else 
    {
      System.out.println("No transaction occurred.");
    }
  }

  void showMenu()
  {
    char option='\0';
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome "+customerName);
    System.out.println("Your id is: "+customerId);
    // NOTE line break
    System.out.println("\n"); 
    System.out.println("A. check balance");
    System.out.println("B. Deposit");
    System.out.println("C. Withdraw");
    System.out.println("D. Previous Transaction");
    System.out.println("E. Exit");
    System.out.println("O. Options");

    do
    {
      System.out.println("Enter an option");
      option = scanner.next().charAt(0);
      System.out.println("\n");

      switch (option) {
        case 'A':
          System.out.println("Balance = "+balance);
          System.out.println("\n");
          break;
        case 'B':
          System.out.println("Choose an amount to deposit: ");
          int amount = scanner.nextInt();
          deposit(amount);
          System.out.println("Deposited: "+amount);
          System.out.println("\n");
          break;
        case 'C':
          System.out.println("Enter amount to withdraw:");
          int amount2 = scanner.nextInt();
          withdraw(amount2);
          System.out.println("\n");
          break;
        case 'D':
          getPreviousTransaction();
          System.out.println("\n");
          break;
        case 'E':
          System.out.println("*****************************************");
          break;
        case 'O':
          System.out.println("A(balance), B(deposit), C(withdraw), D(previous transaction), E(exit)");
          break;
        default:
        System.out.println("Invalid option. Please enter again.");
          break;
      }
    }
    while(option != 'E');
    System.out.println("Thank you for using my banking service");
    scanner.close();
  }
}