package COMPONENTS;
import com.grou4.services.AdminService;
import java.util.Scanner;

public class CreateNewUser {
    
    public static void addNewUser() {
    
        AdminService adminService = new AdminService();
        Scanner scanner = new Scanner(System.in);
        
        int lastID = adminService.getLastID()+1;
        
        System.out.println("******************************************************");
        System.out.println("*                  Create New Employee               *");
        System.out.println("Enter fields.");
        int userId = lastID;
        System.out.print("Last name:\t\t");
        String lastName = scanner.nextLine();
        System.out.print("First name:\t\t");
        String firstName = scanner.nextLine();
        System.out.print("Username:\t\t");
        String username = scanner.nextLine();
        System.out.print("Password:\t\t");
        String password = scanner.nextLine();
        System.out.print("Birthday:\t\t");
        String birthday = scanner.nextLine();
        System.out.print("Address:\t\t");
        String address = scanner.nextLine();
        System.out.print("Phone number:\t\t");
        String phone = scanner.nextLine();
        System.out.print("SSS number:\t\t");
        String sss = scanner.nextLine();
        System.out.print("Philhealth number:\t");
        String philhealth = scanner.nextLine();
        System.out.print("TIN number:\t\t");
        String tin = scanner.nextLine();
        System.out.print("Pagibig number:\t\t");
        String pagibig = scanner.nextLine();
        System.out.print("Employment status:\t");
        String status = scanner.nextLine();
        System.out.print("Position:\t\t");
        String designation = scanner.nextLine();
        System.out.print("Supervisor:\t\t");
        String supervisor = scanner.nextLine();
        System.out.print("Salary rate:\t\t");
        double basicSalary = scanner.nextDouble();
        System.out.print("Rice subsidy allowance:\t");
        int riceSubsidy = scanner.nextInt();
        System.out.print("Phone allowance:\t");
        int phoneAllowance = scanner.nextInt();
        System.out.print("Clothing allowance:\t");
        int clothingAllowance = scanner.nextInt();
        // SemiMonthly = basicSalary/2
        double semiMonthlyRate = basicSalary/2;
        // HourlyRate = (basicSalary/2)/8
        double hourlyRate = (basicSalary/21)/8;
        
        adminService.createUser(userId, firstName, lastName, username, password, birthday, address, phone, sss, tin, pagibig, status, designation, supervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, semiMonthlyRate, hourlyRate, philhealth);
        System.out.println(" ");
        System.out.println("Successfully created a new employee! ");
        System.out.println("******************************************************");
        
    }
    
}
