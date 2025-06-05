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
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome "+user.getUsername());
            String n = scanner.nextLine();
        }
    }
}
