/* Program Name: BankAccountTester.java
 * Purpose: a tester class to type in values with diffente methods
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Feb 13, 2020
 */
import bank.*;

public class BankAccountTester
{
    public static void main(String []args)
    {
        // create object for Janice's account
        BankAccount janiceAcc = new PersonalChequingAccount("Janice Joplin", "March", 2345);

        // print some info to the user
        System.out.println(janiceAcc.toString());

        // apply some deposits and withdraws
        janiceAcc.deposit(25.98, 5);
        janiceAcc.withdraw(1300, 6);
        janiceAcc.withdraw(1700, 10);
        janiceAcc.deposit(1050, 11);
        janiceAcc.withdraw(1700, 11);
        janiceAcc.deposit(25.98, 25);
        janiceAcc.withdraw(400, 26);
        janiceAcc.withdraw(27, 28);
        janiceAcc.withdraw(7.50, 28);

        // process month info
        janiceAcc.monthlyProcess();

        // print some info to the user
        System.out.println(janiceAcc.toString());

        // create object for Elvis' account
        BankAccount elvisAcc = new SavingAccount("Elvis Presley", "March", 6100);

        // print some info to the user
        System.out.println(elvisAcc.toString());

        // apply some deposits and withdraws
        elvisAcc.deposit(500, 3);
        elvisAcc.withdraw(1000, 6);
        elvisAcc.deposit(250,15);
        elvisAcc.withdraw(3000,21);
        elvisAcc.withdraw(825, 28);
        elvisAcc.deposit(250, 29);

        // process month info
        elvisAcc.monthlyProcess();

        // print some info to the user
        System.out.println(elvisAcc.toString());



    }//end of main

}//end of class
