//import required classes and packages   
import java.util.Scanner;  
  
//create ATMExample class to implement the ATM functionality  
public class Atm 
{  
    //main method starts   
    public static void main(String args[] )  
    {  
        //declare and initialize balance, withdraw, and deposit  
        int balance = 100000, withdraw, deposit;  
          
        //create scanner class object to get choice of user  
        Scanner sc = new Scanner(System.in);  
          
        while(true)  
        {  
            System.out.println("ATM-Automated Teller Machine");  
            System.out.println("");  
            System.out.println("Select 1 for Withdraw");  
            System.out.println("Select 2 for Deposit");  
            System.out.println("Select 3 for Check Balance");  
            System.out.println("Select 4 for EXIT");
            System.out.println(""); 
            System.out.print("Choose the operation you want to perform:");  
              
            //get choice from user  
            int choice = sc.nextInt();  
            switch(choice)  
            {  
                case 1:  
        System.out.print("Enter AMOUNT to be withdrawn:");  
                      
        //get the withdrawn money from user  
        withdraw = sc.nextInt();  
                      
        //check whether the balance is greater than or equal to the withdrawal amount  
        if(balance >= withdraw)  
        {  
            //remove the withdrawn amount from the total balance  
            balance = balance - withdraw;  
            System.out.println("Amout withdrwan successfully.Please Collect your Money");  
        }  
        else  
        {  
            //show custom error message   
            System.out.println("Insufficient Balance");  
        }  
        System.out.println("");  
        break;  
   
                case 2:  
                      
        System.out.print("Enter money to be deposited:");  
                      
        //get deposit amount from te user  
        deposit = sc.nextInt();  
                      
        //add the deposit amount to the total balance  
        balance = balance + deposit;  
        System.out.println("Your Money has been successfully deposited");  
        System.out.println("");  
        break;  
   
                case 3:  
        //displaying the total balance of the user  
        System.out.println("Your current Balance is: "+balance);  
        System.out.println("");  
        break;  
   
                case 4:  
        //exit from the menu  
        System.exit(0);  
            }  
        }  
    }  
}  