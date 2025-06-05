import java.util.Scanner;

public class Service {
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        BankDB bankDB = new BankDB();
        // Todo: validate user name
        if(bankDB.checkUserame(username)){
            System.out.println("Username already exists!");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        // Todo: validate passowrd & hash password
        bankDB.createUser(username,password);
        User user = bankDB.findByUsername(username);

        System.out.println("Account Number: " + user.getACcountNumber());
        System.out.println("Account created successfully!");
    }
}
