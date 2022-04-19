package Project1;

import java.util.Scanner;

public class BankAccount {
    private double balance;
    private static Scanner entry;
    public BankAccount(){
        balance = 0;
    }

    public BankAccount(double initalBalance){
        balance = initalBalance;
    }

    public double getBalance(){
        return balance;
    }

 //test
    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdraw(double amount){
        balance = balance - amount;
    }


    public void monthlyfee(){
        withdraw(10);
    }
    public void overdraft(double balance, double amount){
    double feeBalance;
    double feeBalance2;
    
    if(balance>0){
        double withdrawAmount = balance - amount;
        withdraw(amount);
        if(withdrawAmount<=0){
            System.out.println("Alerting: The withdrawal balance will be $0 or less...a $35 fee will be applied following the withdrawal");
            int select; 
            System.out.println("Choose 1 to continue with the withdrawal or Choose 2 to cancel.");
            System.out.println("1: Choose");
                System.out.println("2: Cancel");
                select = entry.nextInt();
                
            if(select == 1){
                feeBalance = withdrawAmount - 35;
            System.out.println("Balance after withdrawal: " + feeBalance);
            }
            else if(select == 2){
            System.out.println("Withdrawal cancelled. Balance: " + balance);
            }
            else{
            System.out.println("Invalid entry");
            }
        }
    else if(withdrawAmount>=0){
            System.out.println("Balance after withdrawal: " + withdrawAmount);
        }
    }
    else if(balance<=0){
        feeBalance2 = balance - 35;
        System.out.println("If your balance is $0 or less, you will be charged a $35 fee.");
        System.out.println("Balance: " + feeBalance2);
        }
        else{
        System.out.println("Invalid entry");
        }
    }
    public void transfer(double bankAccount1, double bankAccount2, double transferAmount){
        double balance1 = bankAccount1 - transferAmount;
        double balance2 = bankAccount2 + transferAmount;

        System.out.println("Bank Account 1 Balance: " + balance1);
        System.out.println("Bank Account 2 Balance: " + balance2);
    }
            
    // P(1+ R/n)^(nt) - P 
    // P = principal
    // t = years
    // R = annual interest rate
    // n = # of times its compunded
    // PEMDAS 
    public void calcInterest(double p, int t, double r, int n){
        double amount =  p * Math.pow(1 + (r/n), n*t);
        double compinterest = amount - p;
        System.out.println("Compund Interest after "+ t + " years: "+ compinterest);
        System.out.println("Amount after "+ t +" years: "+ amount);
    }
    public void simpleInterest(double p, int t, double r){
        double simpleInt = (p * r* t*1/100);
        System.out.println("Simple Interest after "+ t + " years: "+ simpleInt);
    }
    public void investment(double balance, double r, double targetBalance){
        int year = 0; 
        while(balance<= targetBalance){
            year++;
            double interest = balance * r / 100;
            balance = balance + interest;
        }
        System.out.println("Total Balance: $"+ balance);
        System.out.println("Investment doubled After "+ year + " years.");
    }
    public void savingsAccount(double initialValue){
        if(initialValue>=1000){
        int value;
        System.out.println("Please choose whether you want compound or flat-rate interest:");
        System.out.println("1- Compound Interest");
            System.out.println("2- Flat Rate Interest");
            value = entry.nextInt();
            if(value == 1){
                System.out.println("Enter the principle amount:");
                double principal = entry.nextDouble();
                System.out.println("Enter the amount of years:");
                int years = entry.nextInt();
                double rate = 0.0001;
                int nValue = 4;
                calcInterest(principal, years, rate, nValue);
            } if(value == 2){
                System.out.println("Enter the principle amount:");
                double principal2 = entry.nextDouble();
                System.out.println("Enter the amount of years:");
                int years2 = entry.nextInt();
                double rate2 = 0.001;
                simpleInterest(principal2, years2, rate2);
            }
        }
        else if(initialValue<1000){
            System.out.println("It is not possible to calculate interest on a value smaller than $1000");
        }
        else{
            System.out.println("Invalid");
        }
  
    }
    public static int menu(){
        int selection;
        Scanner input = new Scanner(System.in);

        /************************ */
        System.out.println("Please select and option:");
        System.out.println("-------------------------");
        System.out.println("1: Get Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Transfer");
        System.out.println("5: Setting up a Savings Account");
        System.out.println("0: Quit");
        System.out.println("-------------------------");

        selection = input.nextInt();


        return selection;


    }





}
