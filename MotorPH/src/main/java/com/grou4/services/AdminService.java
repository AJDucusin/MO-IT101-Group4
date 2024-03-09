package com.grou4.services;
import DB.DatabaseConnection;
import constructor.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminService {
    
    public static User loginUser(String username, String password) {
        
        User user = null;
        try (Connection connection = DatabaseConnection.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
        
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("birthday"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getString("sss"),
                            resultSet.getString("tin"),
                            resultSet.getString("pagibig"),
                            resultSet.getString("philhealth"),
                            resultSet.getString("status"),
                            resultSet.getString("designation"),
                            resultSet.getString("supervisor"),
                            resultSet.getDouble("basic_salary"),
                            resultSet.getInt("rice_subsidy"),
                            resultSet.getInt("phone_allowance"),
                            resultSet.getInt("clothing_allowance"),
                            resultSet.getDouble("gross_semi_monthly_rate"),
                            resultSet.getDouble("hourly_rate")
                    );
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static User getUserByID(int userId) {
        User user = null;
        try (Connection connection = DatabaseConnection.connect(); 
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            
            preparedStatement.setInt(1, userId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("birthday"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getString("sss"),
                            resultSet.getString("tin"),
                            resultSet.getString("pagibig"),
                            resultSet.getString("philhealth"),
                            resultSet.getString("status"),
                            resultSet.getString("designation"),
                            resultSet.getString("supervisor"),
                            resultSet.getDouble("basic_salary"),
                            resultSet.getInt("rice_subsidy"),
                            resultSet.getInt("phone_allowance"),
                            resultSet.getInt("clothing_allowance"),
                            resultSet.getDouble("gross_semi_monthly_rate"),
                            resultSet.getDouble("hourly_rate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public static boolean createUser(int userId, String firstName, String lastName, String username, String password, String birthday, String address, String phone, String sss, String tin, String pagibig, String status, String position, String supervisor, double basicSalary, int riceSubsidy, int phoneAllowance, int clothingAllowance, double grossSemiMonthlyRate, double hourlyRate, String philhealth) {
        try (Connection connection = DatabaseConnection.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (id, first_name, last_name, username, password, birthday, address, phone, sss, tin, pagibig, status, designation, supervisor, basic_salary, rice_subsidy, phone_allowance, clothing_allowance, gross_semi_monthly_rate, hourly_rate, philhealth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, birthday);
            preparedStatement.setString(7, address);
            preparedStatement.setString(8, phone);
            preparedStatement.setString(9, sss);
            preparedStatement.setString(10, tin);
            preparedStatement.setString(11, pagibig);
            preparedStatement.setString(12, status);
            preparedStatement.setString(13, position);
            preparedStatement.setString(14, supervisor);
            preparedStatement.setDouble(15, basicSalary);
            preparedStatement.setInt(16, riceSubsidy);
            preparedStatement.setInt(17, phoneAllowance);
            preparedStatement.setInt(18, clothingAllowance);
            preparedStatement.setDouble(19, grossSemiMonthlyRate);
            preparedStatement.setDouble(20, hourlyRate);
            preparedStatement.setString(21, philhealth);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateUser(int empID, String firstName, String lastName, String username, String password, String birthday, String address, String phone, String sss, String tin, String pagibig, String status, String designation, String supervisor, double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate, double philhealth ) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.users\n" +
            "	SET first_name=?, last_name=?, username=?, password=?, birthday=?, address=?, phone=?, sss=?, tin=?, pagibig=?, status=?, designation=?, supervisor=?, basic_salary=?, rice_subsidy=?, phone_allowance=?, clothing_allowance=?, gross_semi_monthly_rate=?, hourly_rate=?, philhealth=?\n" +
            "	WHERE id = ?");
        
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, username);
        preparedStatement.setString(4, password);
        preparedStatement.setString(5, birthday);
        preparedStatement.setString(6, address);
        preparedStatement.setString(7, phone);
        preparedStatement.setString(8, sss);
        preparedStatement.setString(9, tin);
        preparedStatement.setString(10, pagibig);
        preparedStatement.setString(11, status);
        preparedStatement.setString(12, designation);
        preparedStatement.setString(13, supervisor);
        preparedStatement.setDouble(14, basicSalary);
        preparedStatement.setDouble(15, riceSubsidy);
        preparedStatement.setDouble(16, phoneAllowance);
        preparedStatement.setDouble(17, clothingAllowance);
        preparedStatement.setDouble(18, grossSemiMonthlyRate);
        preparedStatement.setDouble(19, hourlyRate);
        preparedStatement.setDouble(20, philhealth);
        preparedStatement.setInt(21, empID);
        
        int rowsAffected = preparedStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("User with ID: " +empID +" updated successfully.");
        } else {
            System.out.println("No user fount with ID: " +empID);
            return false;
        }
        return true;
    }
    
    public static boolean updateUser2(int empID, String firstName, String lastName, String username, String password, String birthday, String address, String phone, String sss, String tin, String pagibig, String status, String position, String supervisor, double basicSalary, int riceSubsidy, int phoneAllowance, int clothingAllowance, double grossSemiMonthlyRate, double hourlyRate, String philhealth) {
        try (Connection connection = DatabaseConnection.connect();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.users SET id=?, first_name=?, last_name=?, username=?, password=?, birthday=?, address=?, phone=?, sss=?, tin=?, pagibig=?, status=?, designation=?, supervisor=?, basic_salary=?, rice_subsidy=?, phone_allowance=?, clothing_allowance=?, gross_semi_monthly_rate=?, hourly_rate=?, philhealth=? WHERE id = ?")) {
            
            preparedStatement.setInt(1, empID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, birthday);
            preparedStatement.setString(7, address);
            preparedStatement.setString(8, phone);
            preparedStatement.setString(9, sss);
            preparedStatement.setString(10, tin);
            preparedStatement.setString(11, pagibig);
            preparedStatement.setString(12, status);
            preparedStatement.setString(13, position);
            preparedStatement.setString(14, supervisor);
            preparedStatement.setDouble(15, basicSalary);
            preparedStatement.setInt(16, riceSubsidy);
            preparedStatement.setInt(17, phoneAllowance);
            preparedStatement.setInt(18, clothingAllowance);
            preparedStatement.setDouble(19, grossSemiMonthlyRate);
            preparedStatement.setDouble(20, hourlyRate);
            preparedStatement.setString(21, philhealth);
            preparedStatement.setInt(22, empID);
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Changes applied to employee " +empID);
            } else {
                System.out.println("No user fount with ID: " +empID);
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public static int getLastID() {
        
        int lastEmpID = -1;
        
        try (Connection connection = DatabaseConnection.connect(); 
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) AS last_id FROM users");
                ResultSet resultSet = preparedStatement.executeQuery()) {
            
            if (resultSet.next()) {
                lastEmpID = resultSet.getInt("last_id");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lastEmpID;
    }
    
    
}
