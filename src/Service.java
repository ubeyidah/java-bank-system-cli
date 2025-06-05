import java.util.Scanner;

public class Service {
    public void createAccount(){
        System.out.println("--- Create New Account ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        // Todo: validate user name
        if(BankDB.checkUserame(username)){
            throw new IllegalArgumentException("failed: Username already exists!");
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        // Todo: validate passowrd & hash password
        BankDB.createUser(username,password);
        User user = BankDB.findByUsername(username);

        System.out.println("Account Number: " + user.getACcountNumber());
        System.out.println("Account created successfully!");
    }
    public void login(){
        System.out.println("--- Login To Your Account ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user =  BankDB.findByUsername(username);
        if(user == null || !user.checkPassword(password)){
            throw new IllegalArgumentException("Login failed: Invalid username or password. Please try again.");
        }
        userDashboard(user);

    }
    public static  void userDashboard(User user){
        dashboardText(user.getUsername());
        while (true){
            System.out.println("-------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.print("$: ");
            try{
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Your balance: Birr "+ user.getBalance());
                        break;
                    case 2:
                       deposit(user);
                        break;
                    case 3:
                        withdraw(user);
                        break;
                    case 4:
                        System.out.println("Logged out.");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
            catch (Exception err){
                System.out.println("Invalid choice. only integer is accepted!");
            }
        }


    }

    public static void dashboardText(String username) {
        System.out.println("\nWelcome, " + username + "!");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Logout");
    }

    public static void deposit(User user){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            user.deposit(amount);
            System.out.println("Deposited.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void withdraw(User user){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            boolean canWithdraw = user.checkPassword(password);
            if(!canWithdraw){
                throw new IllegalArgumentException("withdraw failed: incorrect password");
            }
            user.withdraw(amount);
            System.out.println("Withdrawn.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
