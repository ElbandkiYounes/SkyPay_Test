import com.bank.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Welcome to SkyPay Banking System ===\n");
        
        while (true) {
            System.out.println("\nCurrent Balance: " + account.getBalance());
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Statement");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        int depositAmount = scanner.nextInt();
                        account.deposit(depositAmount);
                        System.out.println("Successfully deposited " + depositAmount);
                        break;
                        
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = scanner.nextInt();
                        account.withdraw(withdrawAmount);
                        System.out.println("Successfully withdrawn " + withdrawAmount);
                        break;
                        
                    case 3:
                        System.out.println("\n=== Account Statement ===");
                        account.printStatement();
                        break;
                        
                    case 4:
                        System.out.println("Thank you for using SkyPay Banking System!");
                        scanner.close();
                        return;
                        
                    default:
                        System.out.println("Invalid choice. Please select 1-4.");
                }
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}