import java.util.*;

class baseAccount {
    public String FNAME = "";
    public String LNAME = "";
    public double BALANCE = 0;
    public String accnum = "NONE"; //none by default 
    public baseAccount(String fname, String lname, double b, String num)
    {
        this.FNAME = fname;
        this.LNAME = lname;
        this.BALANCE = b;
        this.accnum = num;
    }
    public baseAccount(){}
    public void Withdraw(double a)
    {
        if (a <= BALANCE)
        {
            BALANCE -= a; 
            System.out.println("You withdrew $" + a + "\nYou have $" + BALANCE + " remaining.");
        } else {
            System.out.println("Insufficient Funds, you have $" + BALANCE);
        }
    }
    public void Deposit(double a)
    {
        this.BALANCE += a;
        System.out.println("Updated balance to " + this.BALANCE);
    }
    public void dataView()
    {
        System.out.println("First Name: " + this.FNAME + "\nLast Name: " + this.LNAME + "\nBalance: " + this.BALANCE + "\nAccount Number: " + this.accnum);
    }
}

public class Bank {
    public static List<baseAccount> accnts = new ArrayList<baseAccount>();
    public static boolean accExists(String num)
    {
        for (baseAccount b : accnts)
        {
            if (b.accnum.equals(num))
            {
                return(true);
            }
        }
        return(false);
    }
    public static baseAccount getAccount(String num)
    {
        for (baseAccount b : accnts)
        {
            if (b.accnum.equals(num))
            {
                return(b);
            }
        }
        return(new baseAccount());
    }
    public static void showHelp()
    {
        System.out.println("Enter 1 to create new account\nEnter 2 to access an existing account");
    }
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        accnts.add(new baseAccount("Bob", "Jones", 1.53, "329"));
        while (true)
        {
            showHelp();
            String input = console.nextLine();
            if (input.equals("1"))
            {
                System.out.print("Enter First Name: ");
                String fn = console.nextLine();
                System.out.print("Enter Last Name: ");
                String ln = console.nextLine();
                String acn = "";
                while (true)
                {
                    System.out.print("Create your account number: ");
                    acn = console.nextLine();
                    if (accExists(acn)) 
                    {
                        System.out.println("An account with this number already exists, please pick a different one.");
                    }
                    else {
                        accnts.add(new baseAccount(fn, ln, 0, acn));
                        break;
                    }
                }
            }
            else if (input.equals("2"))
            {
                System.out.print("Enter Account Number: ");
                String acn = console.nextLine();
                baseAccount temp; 
                if (!accExists(acn))
                {
                    System.out.println("No account at this bank has that number");
                } else {
                    temp = getAccount(acn);
                    int nn = accnts.indexOf(temp);
                    temp.dataView();
                    System.out.println("\nMake Deposit: 1\nMake Withdrawal: 2\n");
                    while (true)
                    {
                        String acca = console.nextLine();
                        if (acca.equals("1"))
                        {
                            System.out.print("Enter Ammount: ");
                            String amt = console.nextLine();
                            temp.BALANCE += Double.parseDouble(amt);
                            accnts.set(nn, temp);
                            break;
                        }
                        else if (acca.equals("2"))
                        {
                            System.out.print("Enter Ammount: ");
                            String amt = console.nextLine();
                            temp.BALANCE -= Double.parseDouble(amt);
                            accnts.set(nn, temp);
                            break;
                        }
                    }
                }
            }
        }
    }
}