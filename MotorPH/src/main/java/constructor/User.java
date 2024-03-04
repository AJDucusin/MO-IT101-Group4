package constructor;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String birthday;
    private String address;
    private String phone;
    private String sss;
    private String tin;
    private String pagibig;
    private String philhealth;
    private String status2;
    private String designation;
    private String supervisor;
    private double basicSalary;
    private int riceSubsidy;
    private int phoneAllowance;
    private int clothingAllowance;
    private double semiMonthlyRate;
    private double hourlyRate;
    
    public User(int userId, String firstName, String lastName, String username, String password, String birthday, String address, String phone, String sss, String tin, String pagibig, String philhealth, String status2, String designation, String supervisor, double basicSalary, int riceSubsidy, int phoneAllowance, int clothingAllowance, double semiMonthlyRate, double hourlyRate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.sss = sss;
        this.tin = tin;
        this.pagibig = pagibig;
        this.philhealth = philhealth;
        this.status2 = status2;
        this.designation = designation;
        this.supervisor = supervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.semiMonthlyRate = semiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getSss() {
        return sss;
    }
    
    public String getTin() {
        return tin;
    }
    
    public String getPagibig() {
        return pagibig;
    }
    
    public String getStatus() {
        return status2;
    }
    
    public String getPhilhealth() {
        return philhealth;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public String getSupervisor() {
        return supervisor;
    }
    
    public double getBasicSalary() {
        return basicSalary;
    }
    
    public int getRiceSubsidy() {
        return riceSubsidy;
    }
    
    public int getPhoneAllowance() {
        return phoneAllowance;
    }
    
    public int getClothingAllowance() {
        return clothingAllowance;
    }
    
    public double getSemiMonthlyRate() {
        return semiMonthlyRate;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
    
}
