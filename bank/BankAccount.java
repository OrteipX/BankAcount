/* Program Name: BankAccount.java
 * Purpose: a abstrat super class to be extended by other classes. It contains generic
 * members
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Feb 06, 2020
 */

package bank;

public abstract class BankAccount implements InterestPayable
{
    private String customerName;
    private String accountType;
    private String month;

    // default constructor
    public BankAccount()
    {
        customerName = null;
        accountType = null;
        month = null;
    }

    // 3 args constructor
    public BankAccount(String customerName, String accountType, String month)
    {
        this.customerName = customerName;
        this.accountType = accountType;
        this.month = month;
    }

    // setter - name
    public void setCustomerName(String customerName)
    {
        // check if the name is empty
        if (customerName == "")
        {
            System.out.println("You cannot set an empty name.");
            return;
        }

        this.customerName = customerName;
    }

    // getter - customer name
    public String getCustomerName()
    {
        return customerName;
    }

    // setter - account type
    public void setAccountType(String accountType)
    {
        // check if account type is empty
        if (accountType == "")
        {
            System.out.println("You cannot set an empty account type.");
            return;
        }

        this.accountType = accountType;
    }

    // getter - account type
    public String getAccountType()
    {
        return accountType;
    }

    // setter - month
    public void setMonth(String month)
    {
        if (month == "")
        {
            System.out.println("You cannot set an empty month.");
            return;
        }

        this.month = month;
    }

    // getter - month
    public String getMonth()
    {
        return month;
    }

    // Abstract methods
    // should be implemented by the sub classes
    public abstract String generateAccountNumber();

    public abstract void deposit(double depositAmount, int day);

    public abstract void withdraw(double withdrawAmount, int day);

    public abstract void recordTransaction(int day, String transaction, double amount, double balance);

    public abstract void monthlyProcess();

    /*
     * Method Name: toString()
     * Purpose: Over-ridden method from object class to print
     * Accepts: nothing
     * Returns: String
     * Date: Feb 06, 2020
     */
    @Override
    public String toString()
    {
        return "****************************************" +
            "\nCustomer Name:\t\t" + customerName +
            "\nAccount Type:\t\t" + accountType +
            "\nCurrent Month:\t\t" + month +
            "\n****************************************";
    }

}//end of class
