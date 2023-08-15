import java.util.*;

class User {
    private String userId;
    private String userPin;
    private double accountBalance;
    private List<String> transactionHistory;

    public User(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.accountBalance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticate(String inputUserId, String inputUserPin) {
        return userId.equals(inputUserId) && userPin.equals(inputUserPin);
    }

    public void deposit(double amount) {
        accountBalance += amount;
        transactionHistory.add("Deposit: +" + amount);
        System.out.println("Money has been successfully deposited to your account.");
        System.out.println("Left amount in your account "+ accountBalance);
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            transactionHistory.add("Withdraw: -" + amount);
            System.out.println("Money has been successfully withdrawn.");
            System.out.println("Left amount in your account "+ accountBalance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(User recipient, double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            recipient.accountBalance += amount;
            transactionHistory.add("Transfer: -" + amount + " to " + recipient.userId);
            System.out.println(amount+" has been successfully transfered to recipient account.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void showTransactionHistory() {
        boolean ans = transactionHistory.isEmpty();
        if (ans == true)
            System.out.println("No transaction has been done yet.");
        
        else{
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    }

    public double getAccountBalance() {
        System.out.println("Balance in your account is:"+ accountBalance);
        return accountBalance;
    }
}

public class ATMApplication{
    public static void main(String[] args) {
         String userID[],userPIN[];
      double BAL[];
        userID=new String[]{"user123","user24","user34","user45","user54"};
        userPIN=new String[]{"1234","234","345","456","549"};
        BAL=new double[]{1000.0,1000.0,1000.0,1000.0,1000.0};
        int pos=-1;
        String userIdInput;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
       userIdInput = scanner.nextLine();
        for(int i=0;i<userID.length;i++)
        {
         if(userID[i].equals(userIdInput))
          pos=i;
          }
    
           while(pos<0){
            System.out.println("Invalid User ID");
        System.out.print("Enter User ID: ");
         userIdInput = scanner.nextLine();
        for(int i=0;i<userID.length;i++)
        {
         if(userID[i].equals(userIdInput))
          pos=i;
          
          }

        }
        User user = new User(userID[pos],userPIN[pos],BAL[pos]);
        
        System.out.print("Enter User PIN: ");
        String userPinInput = scanner.nextLine();

        if (user.authenticate(userIdInput, userPinInput)) {
            System.out.println("Authentication successful. Welcome, " + user.getAccountBalance());

            while (true) {
                System.out.println("\nSelect Operation:");
                System.out.println("1. Transaction History");
                System.out.println("2. Checking Balance");
                System.out.println("3. Withdraw");
                System.out.println("4. Deposit");
                System.out.println("5. Transfer");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                switch (choice) {
                    case 1:
                        user.showTransactionHistory();
                        break;
                    case 2:
                        
                        user.getAccountBalance();
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        user.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        user.deposit(depositAmount);
                        break;
                    case 5:
                        System.out.print("Enter recipient's User ID: ");
                        String recipientId;
                         recipientId= scanner.nextLine();
                        
                        int poa=-1;
                        for(int i=0;i<userID.length;i++)
        {
         if(userID[i].equals(recipientId))
          pos=i;
          }
    while(poa<0){
        
            System.out.println("Invalid User ID");
        System.out.print("Enter User ID: ");
         recipientId = scanner.nextLine();                                
        for(int i=0;i<userID.length;i++)
        {
         if(userID[i].equals(recipientId))
          poa=i;
          
          }
          
}
System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
 
                 
                     User usea = new User(userID[poa],userPIN[poa],BAL[poa]);
               
                        user.transfer(usea,transferAmount);
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }
            }
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
    }
}