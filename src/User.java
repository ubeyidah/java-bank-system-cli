public class User {
    private final String accountNo;
    private final String username;
    private final String password;
    private double balance;

    public static String generateAccountNo(){
        String[] numbersStr = {"0","1","2","3","4","5","6","7","8","9"};
        StringBuilder accountNo = new StringBuilder();
        int accountNoLen = 0;
        while (accountNoLen <= 8){
            int randomIndex =(int) Math.floor(Math.random() * numbersStr.length);
            accountNo.append(numbersStr[randomIndex]);
            accountNoLen ++;
        }
        return accountNo.toString();
    }

    public User(String username, String password){
        this.accountNo = generateAccountNo();
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }

    public String getUsername(){
        return this.username;
    }

    public String getACcountNumber(){
        return this.accountNo;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public double getBalance(){
        return this.balance;
    }

    private static void checkEmptyAmount(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("action failed: Amount must be positive.");
        }
    }

    public String deposit(double amount){
        checkEmptyAmount(amount);
        this.balance += amount;
        return String.format("Deposit successful! New balance: Birr $%.2f",this.balance);
    }

    public String withdraw(double amount){
        checkEmptyAmount(amount);
        if(amount > this.balance){
            throw new IllegalArgumentException(String.format("Transaction declined. Your account has $%.2f, which is not enough for this withdrawal. Please try a smaller amount.",this.balance));
        }
        this.balance -= amount;
        // Todo: implement real money sending
        return String.format(
                "Withdrawal successful! New balance: Birr $%.2f",
                balance
        );
    }
}
