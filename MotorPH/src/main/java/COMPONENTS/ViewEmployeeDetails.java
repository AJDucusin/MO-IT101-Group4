package COMPONENTS;

import DB.DatabaseConnection;
import com.grou4.services.AdminService;
import constructor.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewEmployeeDetails {
    
    
    public static void fullDetails(int id) {
        User employeeDetail = AdminService.getUserByID(id);

        System.out.println("ID: " + employeeDetail.getUserId());
        System.out.println("First Name: " + employeeDetail.getFirstName());
        System.out.println("Last Name: " + employeeDetail.getLastName());
        //System.out.println("Usernaem: " + employeeDetail.getUsername());
        //System.out.println("Password: " + employeeDetail.getPassword());
        System.out.println("Birthday: " + employeeDetail.getBirthday());
        System.out.println("Address: " + employeeDetail.getAddress());
        System.out.println("Phone Number: " + employeeDetail.getPhone());
        System.out.println("SSS Number: " + employeeDetail.getSss());
        System.out.println("TIN Number: " + employeeDetail.getTin());
        System.out.println("Pag-ibig Number: " + employeeDetail.getPagibig());
        System.out.println("Philhealth Number: " + employeeDetail.getPhilhealth());
        System.out.println("Position: " + employeeDetail.getDesignation());
        System.out.println("Supervisor: " + employeeDetail.getSupervisor());
        System.out.println("Monthly Salary: " + employeeDetail.getBasicSalary());
        System.out.println("Rice Subsidy: " + employeeDetail.getRiceSubsidy());
        System.out.println("Phone Allowance: " + employeeDetail.getPhoneAllowance());
        System.out.println("Clothing Allowance: " + employeeDetail.getClothingAllowance());
        System.out.println("Semi Monthly Salary: " + employeeDetail.getSemiMonthlyRate());
        System.out.println("Hourly Rate: " + employeeDetail.getHourlyRate());
    }
    
    
    
    // Legaspi A. | Task 2.3 | Code Employee's  Personal Detail's Page (View)
    public static void getEmployeePersonalDetail() {
        Connection connection = DatabaseConnection.connect();
        Scanner userInput = new Scanner(System.in);
        
        if(connection != null){
            try (Statement statement = connection.createStatement()){
                
                int searchByID = 0;
                System.out.println("*                View Employee's Detail              *");
                System.out.print("Enter employee ID: ");
                searchByID = userInput.nextInt();
                
                String query = "SELECT * FROM users WHERE ID =" + searchByID;
                ResultSet resultSet = statement.executeQuery(query);
                
                while (resultSet.next()){
                    searchByID = resultSet.getInt("ID");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String birthday = resultSet.getString("birthday");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String sss = resultSet.getString("sss");
                    String tin = resultSet.getString("tin");
                    String pagibig = resultSet.getString("pagibig");
                    String philhealth = resultSet.getString("philhealth");
                    String designation =  resultSet.getString("designation");
                    String supervisor = resultSet.getString("supervisor");
                    System.out.println("\n");
                    System.out.println("ID: "+searchByID);
                    System.out.println("First Name: \t"+firstName);
                    System.out.println("Last Name: \t"+lastName);
                    System.out.println("Birthday: \t"+birthday);
                    System.out.println("Address: \t"+address);
                    System.out.println("Phone: \t\t"+phone);
                    System.out.println("SSS: \t\t"+sss);
                    System.out.println("TIN: \t\t"+tin);
                    System.out.println("Pag-ibig: \t"+pagibig);
                    System.out.println("Philhealth: \t" +philhealth);
                    System.out.println("Designation: \t"+designation);
                    System.out.println("Supervisor: \t"+supervisor);
                }
                System.out.println("******************************************************");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static void getMyPersonalDetail(int logInUserID) {
        Connection connection = DatabaseConnection.connect();
        Scanner userInput = new Scanner(System.in);
        
        if(connection != null){
            try (Statement statement = connection.createStatement()){
                
                int searchByID = 0;
                System.out.println("*                View Employee's Detail              *");
                
                String query = "SELECT * FROM users WHERE ID =" + logInUserID;
                ResultSet resultSet = statement.executeQuery(query);
                
                while (resultSet.next()){
                    searchByID = resultSet.getInt("ID");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String birthday = resultSet.getString("birthday");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    String sss = resultSet.getString("sss");
                    String tin = resultSet.getString("tin");
                    String pagibig = resultSet.getString("pagibig");
                    String philhealth = resultSet.getString("philhealth");
                    String designation =  resultSet.getString("designation");
                    String supervisor = resultSet.getString("supervisor");
                    System.out.println("\n");
                    System.out.println("ID: "+searchByID);
                    System.out.println("First Name: \t"+firstName);
                    System.out.println("Last Name: \t"+lastName);
                    System.out.println("Birthday: \t"+birthday);
                    System.out.println("Address: \t"+address);
                    System.out.println("Phone: \t\t"+phone);
                    System.out.println("SSS: \t\t"+sss);
                    System.out.println("TIN: \t\t"+tin);
                    System.out.println("Pag-ibig: \t"+pagibig);
                    System.out.println("Philhealth: \t" +philhealth);
                    System.out.println("Designation: \t"+designation);
                    System.out.println("Supervisor: \t"+supervisor);
                }
                System.out.println("******************************************************");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
}
