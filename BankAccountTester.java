package Project1;

import java.util.Scanner;

public class BankAccountTester {
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Hello Welcome! Please Enter your Name:");
        BankAccount gregChecking = new BankAccount(20000);
        BankAccount patelChecking = new BankAccount(10000);
        BankAccount Output = new BankAccount();
        Output.simpleInterest(500, 20, 5);
        String name = keyboard.nextLine();
        System.out.println("Welcome " + name + ", How much would you like start your account with?");
        double startAmount = keyboard.nextDouble();
        BankAccount name_checking = new BankAccount(startAmount);

        System.out.println("Great! "+ name+" Your starting balance is: $"+ name_checking.getBalance());
        
        int menuSelection = BankAccount.menu();
        System.out.println(menuSelection);
        
        if(menuSelection == 1){
            System.out.println("Getting Account Balance...");
            System.out.println("Total Balance: $"+name_checking.getBalance());

        }else if (menuSelection == 2){
            System.out.println("Please enter the amount to deposit");
            double depositAmount = keyboard.nextDouble();
            name_checking.deposit(depositAmount);
            System.out.println("Amount: $"+depositAmount + " Was Deposited");
            System.out.println("Total Balance: $" + name_checking.getBalance());

        }else if (menuSelection == 3){
            System.out.println("Please enter the amount to withdraw");
            double withdrawAmount = keyboard.nextDouble();
            Output.overdraft(name_checking.getBalance(), withdrawAmount);
            name_checking.withdraw(withdrawAmount);
            
            System.out.println("Amount: $"+withdrawAmount + " Was Withdrawn");
            System.out.println("Total Balance: $" + name_checking.getBalance());

        }else if(menuSelection == 4){

            System.out.println("Enter your balance for Bank Account 1:");
            double bank1 = keyboard.nextDouble();
            System.out.println("How much would you like to transfer to Bank Account 2:");
            double transferBank = keyboard.nextDouble();
            System.out.println("Enter your balance for Bank Account 2:");
            double bank2 = keyboard.nextDouble();
            name_checking.transfer(bank1, bank2, transferBank);
        }else if(menuSelection == 5){
            System.out.println("Creating a Savings Account. How much amount would you like to start it:");
            double initialSavings = keyboard.nextDouble();
            name_checking.savingsAccount(initialSavings);

        }else if (menuSelection == 0){
            System.out.println("Have a nice day!");
        }else{
            System.out.println("Error: No Valid Selection");
        }
    }
}
