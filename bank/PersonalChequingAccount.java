/* Program Name: PersonalChequingAccount.java
 * Purpose: personal chequing account to be used by the user as main account
 * Coder: Ramon Gnan Garcia - 0926596
 * Date: Feb 06, 2020
 */

package bank;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.DecimalFormat;
import java.time.Month;

public class PersonalChequingAccount extends BankAccount
{
    private String accountNumber;
    private int numberWithdraws;
    private int numberDeposits;
    private double balance;
    private boolean accountActive;
    private final static double INT_RATE = 0.025; // percentage
    private final static double FEE = 0.85;
    private ArrayList<Transaction> record = new ArrayList<Transaction>();

    // default constructor
    public PersonalChequingAccount()
    {
        super();
        accountNumber = null;
        numberWithdraws = 0;
        numberDeposits = 0;
        balance = 0.0;
        accountActive = false;
    }

    // 3 args constructor
    public PersonalChequingAccount(String customerName, String month, double balance)
    {
        super(customerName, "Chequing", month);
        this.balance = balance;
        accountNumber = generateAccountNumber();
        isAccountActive();
    }

    // getter - account number
    public String getAccountNumber()
    {
        return accountNumber;
    }

    // getter - number of withdraws
    public int getNumberWithdraws()
    {
        return numberWithdraws;
    }

    // getter - number of deposits
    public int getNumberDeposits()
    {
        return numberDeposits;
    }

    // getter - balance
    public double getBalance()
    {
        return balance;
    }

    // getter - interest rate
    public double getInterestRate()
    {
        return INT_RATE;
    }

    // getter - service fee
    public double getServiceFee()
    {
        return FEE;
    }

    /*
     * Method Name: isAccountActive()
     * Purpose: set the account to active or inactive depending on the balance
     * Accepts: nothing
     * Returns: boolean
     * Date: Feb 06, 2020
     */
    public boolean isAccountActive()
    {
        if (balance < 25.00)
            accountActive = false;
        else
            accountActive = true;

        return accountActive;
    }

    /*
     * Method Name: generateAccountNumber()
     * Purpose: set a formatted account number for each customer
     * Accepts: nothing
     * Returns: String
     * Date: Feb 06, 2020
     */
    @Override
    public String generateAccountNumber()
    {
        // declaring some variables
        int lowerDigit = 0, upperDigit = 9;
        String bankNumber = "002", transitNumber = "623490", type = "550";
        String accDigits = "";

        // for loop to generate each digit for account number
        for (int i = 0; i < 6; ++i)
            accDigits += (int)(Math.random() * (upperDigit - lowerDigit)) + lowerDigit;

        accountNumber =  bankNumber + "-" + transitNumber + "-" + accDigits + "-" + type;

        return accountNumber;
    }

    /*
     * Method Name: deposit()
     * Purpose: make a deposit in the user's account
     * Accepts: doiuble, int
     * Returns: void
     * Date: Feb 06, 2020
     */
    @Override
    public void deposit(double depositAmount, int day)
    {
        // check if the depositAmount is greater than zero
        // if not, return
        if (depositAmount <= 0)
        {
            System.out.println("Deposit amount must be greater than '0'(zero).");
            return;
        }

        // updating some status
        String transactionMessage = "Deposit:";
        balance += depositAmount;
        numberDeposits += 1;
        isAccountActive();
        recordTransaction(day, transactionMessage, depositAmount, balance);
    }

    /*
     * Method Name: withdraw()
     * Purpose: withdraw an amount of money from the user's account depending on the
     * available balance he/she has
     * Accepts: double, int
     * Returns: void
     * Date: Feb 06, 2020
     */
    @Override
    public void withdraw(double withdrawAmount, int day)
    {
        String transactionMessage;

        // checking values
        if (withdrawAmount > balance)
        {
            transactionMessage = "Transaction cancelled. Insufficient funds:";
        }
        else if (!accountActive)
        {
            transactionMessage = "Transaction cancelled. Account is inactive:";
        }
        else
        {
            // updating some status
            transactionMessage = "Withdraw:";
            balance -= withdrawAmount;
            numberWithdraws += 1;
            isAccountActive();
        }

        recordTransaction(day, transactionMessage, withdrawAmount, balance);
    }

    /*
     * Method Name: calcInterest()
     * Purpose: calc the month interest for the user's account
     * Accepts: nothing
     * Returns: void
     * Date: Feb 06, 2020
     */
    @Override
    public void calcInterest()
    {
        // declaring some variables
        String transactionMessage = "Interest:";
        // get last day of the month
        Calendar cal = Calendar.getInstance();
        String month = getMonth();
        cal.set(0, Month.valueOf(month.toUpperCase()).getValue(), 0);
        int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        double interest = 0.0;

        // if the balance is greater than 1000
        if (balance >= 1000)
        {
            // declaring some variable
            interest = balance * (double)(INT_RATE / 12);
            balance += interest;
        }

        // record transaction
        recordTransaction(lastDayOfMonth, transactionMessage, interest, balance);

    }

    /*
     * Method Name: recordTransaction()
     * Purpose: record each transaction done in the user's account
     * Accepts: int, String, double, double
     * Returns: void
     * Date: Feb 06, 2020
     */
    @Override
    public void recordTransaction(int day, String transaction, double amount, double balance)
    {
        // create a new object of type Transaction
        Transaction trans = new Transaction();
        // set values to transaction
        trans.set(getMonth(), transaction, day, amount, balance);
        // add transaction object to record
        record.add(trans);
    }

    /*
     * Method Name: printTransaction()
     * Purpose: print all the transaction that has been done within a month
     * Accepts: nothing
     * Returns: void
     * Date: Feb 06, 2020
     */
    public void printTransaction()
    {
        // print title
        System.out.println("*********************************************\n" +
                "Transaction Record for the Month of " + getMonth() + "\n" +
                "*********************************************");

        // for each transaction
        // print to user
        for (Transaction t : record)
        {
            System.out.printf("%s\t%d\t%s\t$%s\t\tBalance:\t$%s\n",
                    t.getMonth(), t.getDay(), t.getTransaction(),
                    String.format("%,-8.2f", t.getAmount()), String.format("%,.2f",t.getBalance()));
        }
    }

    /*
     * Method Name: monthlyProcess()
     * Purpose: wrap everything to be displayed to the user
     * Accepts: nothing
     * Returns: void
     * Date: Feb 06, 2020
     */
    @Override
    public void monthlyProcess()
    {
        // declaring some variables
        String transactionMessage = "Service Fee: ";
        // get last day of the month
        Calendar cal = Calendar.getInstance();
        String month = getMonth();
        cal.set(0, Month.valueOf(month.toUpperCase()).getValue(), 0);
        int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // call method to calculate the interest
        calcInterest();

        double serviceFee = 0.0;

        if (numberWithdraws > 4)
        {
            serviceFee = numberWithdraws * FEE;
            balance -= serviceFee;
        }

        recordTransaction(lastDayOfMonth, transactionMessage, serviceFee, balance);

        // call method to print info to the screen
        // update account status
        printTransaction();
        isAccountActive();

    }

    /*
     * Method Name: toString()
     * Purpose: Over-ridden method from the BankAccount class to print
     * Accepts: nothing
     * Returns: String
     * Date: Feb 06, 2020
     */
    @Override
    public String toString()
    {
        DecimalFormat fmt_num = new DecimalFormat("$#,##0.00");
        DecimalFormat fmt_per = new DecimalFormat("#.00%");

        return "\n" + super.toString() +
            "\nAccount Number:\t\t\t" + accountNumber +
            "\nNumber of Withdraws:\t\t" + numberWithdraws +
            "\nNumber of Deposits:\t\t" + numberDeposits +
            "\nBalance:\t\t\t" + fmt_num.format(balance) +
            "\nAccount Active:\t\t\t" + accountActive +
            "\nAnnual Interest Rate:\t\t" + fmt_per.format(INT_RATE) +
            "\nMonthly Service Fee Rate:\t" + fmt_num.format(FEE) + " (applied to no. of withdraws if withdraws are over 4)\n";
    }


}//end of class
