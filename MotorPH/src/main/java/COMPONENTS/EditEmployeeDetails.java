package COMPONENTS;
import com.grou4.services.AdminService;
import constructor.User;
import java.util.Scanner;

public class EditEmployeeDetails {
    
    public static void editEmpByID() {
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService();
        
        System.out.println("*               Edit Employee's Details              *");
        System.out.print("Enter employee ID: ");
        int userEnteredID = scanner.nextInt();
        String salo = scanner.nextLine();
        
        User employee = adminService.getUserByID(userEnteredID);
        
        if (employee != null) {

            String currentFirstName = employee.getFirstName();
            String currentLastName = employee.getLastName();
            String currentBirthday = employee.getBirthday();
            String currentPhone = employee.getPhone();
            String currentAddress = employee.getAddress();
            
            int currentWidth = Math.max(currentFirstName.length(), Math.max(currentLastName.length(), Math.max(currentBirthday.length(), Math.max(currentPhone.length(), currentAddress.length()))));
            System.out.printf("Field:   \t%-" +currentWidth +"s","Current: ");
            System.out.println("Changes: ");
            //System.out.printf("%-" + currentWidth + "s\t%-" + currentWidth + "s\t%-" + currentWidth + "s\n", "Field:", "Current:", "Changes:");

            System.out.printf("Firstname: \t%-" +currentWidth +"s",currentFirstName);
            System.out.print(" ");
            String newFirstname = scanner.nextLine();
            
            System.out.printf("Lastname: \t%-" +currentWidth +"s",currentLastName);
            System.out.print(" ");
            String newLastname = scanner.nextLine();
            
            System.out.printf("Birthday: \t%-" +currentWidth +"s",currentBirthday);
            System.out.print(" ");
            String newBirthday = scanner.nextLine();
            
            System.out.printf("Phone Num.: \t%-" +currentWidth +"s",currentPhone);
            System.out.print(" ");
            String newPhone = scanner.nextLine();

            System.out.printf("Address: \t%-" +currentWidth +"s",currentAddress);
            System.out.print(" ");
            String newAddress = scanner.nextLine();
            
            
            String unchangeUsername = employee.getUsername();
            String unchangePassword = employee.getPassword();
            String unchangeSss = employee.getSss();
            String unchangeTin = employee.getTin();
            String unchangePagibig = employee.getPagibig();
            String unchangeStatus = employee.getStatus();
            String unchangePosition = employee.getDesignation();
            String unchangeSupervisor = employee.getSupervisor();
            double unchangeBasicSalary = employee.getBasicSalary();
            int unchangeRiceSubsidy = employee.getRiceSubsidy();
            int unchangePhoneAllowance = employee.getPhoneAllowance();
            int unchangeClothingAllowance = employee.getClothingAllowance();
            double unchangeGrossSemiMonthlyRate = employee.getSemiMonthlyRate();
            double unchangeHourlyRate = employee.getHourlyRate();
            String unchangePhilhealth = employee.getPhilhealth();
            
            boolean statusOfUpdate = adminService.updateUser2(userEnteredID, newFirstname, newLastname, unchangeUsername, unchangePassword, newBirthday, newAddress, newPhone, unchangeSss, unchangeTin, unchangePagibig, unchangeStatus, unchangePosition, unchangeSupervisor, unchangeBasicSalary, unchangeRiceSubsidy, unchangePhoneAllowance,unchangeClothingAllowance, unchangeGrossSemiMonthlyRate, unchangeHourlyRate, unchangePhilhealth);
            
            if (statusOfUpdate) {
                System.out.println("Employee details updated successfully.");
                System.out.println("******************************************************");
            } else {
                System.out.println("Failed to update employee details.");
            }
        } else {
            System.out.println("Employee not found.");
        }
        
    }
    
}
