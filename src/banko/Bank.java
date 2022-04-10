/*
Author: Ramos, Khristiane Ren v.
Project: Simple Bank Application
This is my first java project that handle bank transactions from making account using objects
storing the created instance of the object account into an ArrayList<>
 */
package banko;

import java.util.ArrayList;
import java.util.Scanner;


public class Bank {

    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Account> accounts = new ArrayList<Account>();
    public static int[] pinCode = new int[10];
    public static int acc = 0;
    public static void main (String[] args){
        boolean b;

     int i;
     do {
         System.out.println("---------Welcome to the Bank----------");
         System.out.println("Press the number of the command you'd like to do:");
         System.out.println("[1]Create an Account \n[2]Withdraw  \n[3]Deposit \n[4]View Account Info \n[5]Quit");

         i = scan.nextInt();
         switch(i){
             case 1:
                 createAccount();
                acc++;
                 break;
             case 2:
                 withdrawMoney();
                 break;
             case 3:
                 depositMoney();
                 break;

             case 4:
                   viewAccountInfo();
                  break;

             case 5:
                 System.out.println("\nThank you for using our Bank!");
                 break;
             default:
                 System.out.println("invalid");
         }

     }while(i != 5);
         scan.close();

    }
    public static Account createAccount(){

        System.out.print("Please enter your first name: ");
        String fname = scan.next();


        System.out.print("Please enter your middle initial: ");
        String mname = scan.next();


        System.out.print("Please enter your last name: ");
        String lname = scan.next();


        accounts.add(new Account(fname,mname,lname));

        System.out.print("Enter your 4 digit Pin Code: ");
        int pCode = scan.nextInt();

        pinCode[acc] = pCode;
        accounts.get(acc).setPinCode(pinCode[acc]);


        System.out.print("Enter your first deposit: ");
        int depo = scan.nextInt();
        accounts.get(acc).setMoney(depo);


        System.out.println("Account Created Successfully! ");

        return accounts.get(acc);
    }
  /*  public static boolean pinCodeValidation(){
        System.out.print("Enter 4-digit pin code: ");
        int pin = scan.nextInt();
        boolean t = false;
             for(int i = 0; i< accounts.size(); i++){
                 if(pin == accounts.get(i).getPinCode()) {
                    t = true;
                 }
             }
             return t;
    } */

    public static void withdrawMoney(){
        boolean t = false;
        do {
            System.out.print("Enter 4-digit pin code: ");
            int pin = scan.nextInt();

            for (int i = 0; i < accounts.size(); i++) {
                if (pin == accounts.get(i).getPinCode()) {
                    t = true;
                    System.out.println("Your Balance is " + accounts.get(i).getMoney());
                    System.out.print("Enter amount you want to withdraw: ");
                    int wmoney = scan.nextInt();
                    accounts.get(i).withdraw(wmoney);

                    System.out.println("Withdraw Amount: " + wmoney);
                    System.out.println("Total Account Balance: " + accounts.get(i).getMoney());
                    break;
                }
            }
            if (t == false)
                System.out.println("Wrong pin code input!");
        } while (t == false);
    }
    public static void depositMoney(){
        boolean t = false;
        do {
            System.out.print("Enter 4-digit pin code: ");
            int pin = scan.nextInt();

            for (int i = 0; i < accounts.size(); i++) {
                if (pin == accounts.get(i).getPinCode()) {
                    t = true;
                    System.out.println("Your Balance is " + accounts.get(i).getMoney());
                    System.out.print("Enter amount you want to deposit: ");
                    int dmoney = scan.nextInt();
                    accounts.get(i).deposit(dmoney);

                    System.out.println("Deposit Amount: " + dmoney);
                    System.out.println("Total Account Balance: " + accounts.get(i).getMoney());
                }
            }if (t == false)
                System.out.println("Wrong pin code input!");
        } while (t == false);
    }
    public static void viewAccountInfo(){
        boolean t = false;
        do {
            System.out.print("Enter 4-digit pin code: ");
            int pin = scan.nextInt();

            for (int i = 0; i < accounts.size(); i++) {
                if (pin == accounts.get(i).getPinCode()) {
                    t = true;

                    System.out.println("\n\n");
                    System.out.println(accounts.get(i).toString());
                    System.out.println("\n\n");
                    break;
                }
            }
           if(t == false)
            System.out.println("Wrong pin code input!");
        }while(t == false);
    }


}
