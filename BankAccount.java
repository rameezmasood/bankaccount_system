package com.company;

import java.util.Scanner;

/**
 * Created by Muhammad on 7/9/2016.
 */
public class BankAccount {

    private double balance;
    private int pin;

    public BankAccount(){
        System.out.println("Welcome to Saylani Bank ATM");
        this.setBalance(1000.50);
        this.pin = 3245;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void deposit(double amount){
        this.balance = this.balance + amount;
        System.out.println("You have successfully cash deposit amount of "+amount+". Your new balance is "+this.balance);
        System.out.println("");
        this.Display();
    }

    private void draw(int amount){
        if(amount > this.balance ){
            System.out.println("Insufficient Balance");
            System.out.println("");
        }else if(amount%500!=0){
            System.out.println("You can withdraw only 500 or 1000 type amount.");
            System.out.println("");
        }else{
          this.balance = this.balance-amount;
            System.out.println("You have successfully cash with draw amount of "+amount+". Your new balance is "+this.balance);
            System.out.println("");
        }
        this.Display();
    }

    public void verifyPin() {
        System.out.println("Please enter your four digit code");
        Scanner input = new Scanner(System.in);
        int user_pin = input.nextInt();
        if (user_pin != this.pin) {
            System.out.println("Invalid pin code. Please try again next time");
        } else {

            this.Display();
        }
    }

    public void Display(){

            System.out.println("For balance info press 1");
            System.out.println("For deposit press 2");
            System.out.println("For withdraw press 3");
            System.out.println("For exit press 4");
            Scanner input = new Scanner(System.in);
            int access_module = input.nextInt();
            if(access_module==1){
                System.out.println("\nYour current balance is: "+this.getBalance()+"\n");
                this.Display();
            }else if(access_module==2){
                System.out.println("");
                System.out.println("Please enter amount you want to deposit");
                double deposit_amount = input.nextDouble();
                this.deposit(deposit_amount);
            }else if(access_module==3){
                System.out.println("");
                System.out.println("Please enter amount you want to draw");
                int draw_amount = input.nextInt();
                this.draw(draw_amount);
            }else{
                System.out.println("");
                System.out.println("Thank you for using saylani bank ATM.");
            }

    }
}
