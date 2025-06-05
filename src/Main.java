import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        welcomeText();
        Scanner scanner = new Scanner(System.in);
        Service accountService = new Service();

        while (true) {
            try{
                System.out.print("Choose: ");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        try{
                            accountService.createAccount();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try{
                            accountService.login();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Thanks for using the bank.");
                        return;
                    default:
                        System.out.println("Invalid choice.");

                }

            }catch (Exception err){
                System.out.println("Invalid choice. only integer is accepted!");
            }


        }
    }

    public static void welcomeText() {
        System.out.println("--- Welcome to Simple Bank System ---");
        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }
}