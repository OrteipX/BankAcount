/* Program Name: Transaction.java
 * Purpose: a support class to record the transactions
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Feb 09, 2020
 */

package bank;

public class Transaction
{
    private String month;
    private String transaction;
    private int day;
    private double amount;
    private double balance;

    public Transaction()
    {
        month = null;
        transaction = null;
        day = 0;
        amount = 0.0;
        balance = 0.0;
    }

    // getter - month
    public String getMonth()
    {
        return month;
    }

    // getter - day
    public int getDay()
    {
        return day;
    }

    // getter - transaction
    public String getTransaction()
    {
        return transaction;
    }

    // getter - amount
    public double getAmount()
    {
        return amount;
    }

    // getter - balance
    public double getBalance()
    {
        return balance;
    }

    // setter - all the parameters
    public void set(String month, String transaction, int day, double amount, double balance)
    {
        this.month = month;
        this.transaction = transaction;
        this.day = day;
        this.amount = amount;
        this.balance = balance;
    }

    /*
     * Method Name: toString()
     * Purpose: over-ridden method to display some useful message to the user
     * Accepts: nothing
     * Returns: String
     * Date: Feb 09, 2020
     */
    @Override
    public String toString()
    {
        return month + " " + day + " " + transaction + ":" + amount + " Balance: " + balance;
    }

}//end of class
