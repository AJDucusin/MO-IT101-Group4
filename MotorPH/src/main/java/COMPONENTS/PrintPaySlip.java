package COMPONENTS;
import java.util.Scanner;
import constructor.User;
import com.grou4.services.AdminService;

public class PrintPaySlip {
    
    public static void employeePaySlip(String Username, String Password) throws InterruptedException {
        
        Scanner scanner = new Scanner(System.in);
        AdminService adminService = new AdminService();
        
        User getEmpDetails = adminService.loginUser(Username, Password);
        
        String fullName = getEmpDetails.getFirstName() +" " +getEmpDetails.getLastName();
        String empStatus = getEmpDetails.getStatus();
        String empPosition = getEmpDetails.getDesignation();
        double empMonthlySalary = getEmpDetails.getBasicSalary();
        int empRiceSubsidy = getEmpDetails.getRiceSubsidy();
        int empPhoneAllowance = getEmpDetails.getPhoneAllowance();
        int empClothingAllowance = getEmpDetails.getClothingAllowance();
        
        int empTotalAllowance = empRiceSubsidy+empPhoneAllowance+empClothingAllowance;
        
        
        // Width
        int line10Width = 65;
        
        
        //char singleAll;
        int period = 0;
        String startDate = null;
        String endDate = null;
    
        
        System.out.print("Single Employee? All Employee? S/A: ");
        char singleAll = Character.toUpperCase(scanner.next().charAt(0));
        while (singleAll != 'S' && singleAll != 'A') {
            System.out.println("Please choose between S or A . . .");
            System.out.print("Single Employee? All Employee? S/A: ");
            singleAll = Character.toUpperCase(scanner.next().charAt(0));
        }
        
        // >>>  mag lagay ng option: print current period? <<<
        
        // Ang reason kung bakit puwedeng mamili ng salary period ay;
        // Kapag ang mga employee ay mag rerequest ng copy of payslip, madali nalang mag print.
        System.out.println("******************************************************");
        System.out.println("               Choose a salary period:                ");
        periodMenu();
        period = scanner.nextInt();
        while (period != 3 && period != 4) {
            System.out.println(" ");
            System.out.println("Period out of range. . .");
            System.out.println(" ");
            Thread.sleep(2000);
            periodMenu();
            System.out.print("Please choose a salary period: ");
            period = scanner.nextInt();
            Thread.sleep(2000);
            System.out.println(" ");
        }
        
        if (period == 3) {
            startDate = "2024-02-01";
            endDate = "2024-02-15";
        } else if (period == 4) {
            startDate = "2024-02-16";
            endDate = "2024-02-29";
        }
        
        
        
/*1*/   System.out.println("***************************************************************************************************");
/*2*/   System.out.println("*                                        Employee Pay Slip                                        *");
/*3*/   System.out.println("|                                                                            |");
/*4*/   System.out.println("| MotorPH Corporation  Group 4                                               |");
/*5*/   System.out.println("| " +fullName +"\t\t\tPERIOD: " +startDate +" to " +endDate +"\t|");
/*6*/   System.out.println("|                                                                            | Basic Pay:\t"+empMonthlySalary);
/*7*/   System.out.println("==================================================================================================");
/*8*/   System.out.println("| Employer: MotorPH\t\t\t\tStatus: " +empStatus +"\t\t     | Overtime:\t3,000.00");
/*9*/   System.out.println("|----------------------------------------------------------------------------| 13th Month:\t0.00");
/*10*/  System.out.printf("| Position: %1$-" +line10Width +"s| Allowance:\t%2$s", empPosition, empTotalAllowance);
        System.out.println("");
/*11*/  System.out.println("|----------------------------------------------------------------------------|");
/*12*/  System.out.println("|                        |                        |                          | Gross Pay:\t21,000.00");
/*13*/  System.out.println("| Overtime  Hrs   Pay    | Adjustments   Amount   | Deduction     Amount     | Deduction:\t9,200.00");
/*14*/  System.out.println("|----------------------------------------------------------------------------|");
/*15*/  System.out.println("|  Regular  60    351.00 | 13Month       0.00     | Tax           4,200.00   |");
/*16*/  System.out.println("|                        | Incentive     0.00     | SSS           500.00     | Net Pay:\t14,300.00");
/*17*/  System.out.println("|                        | Paid Leaves   0.00     | Philhealth    500.00     |");
/*18*/  System.out.println("|                        | Holiday Pay   0.00     | Pag-Ibig      500.00     |");
/*19*/  System.out.println("|                        | Others        0.00     | Tirediness    2,500.00   |");
/*20*/  System.out.println("|                        |                        | Loan          0.00       |");
/*21*/  System.out.println("|                        |                        | Others        0.00       |");
/*22*/  System.out.println("|                        |                        |                          |");
/*23*/  System.out.println("|                        |                        |                          |");
/*24*/  System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        
    }
    
    public static void periodMenu() {
        System.out.println("1: 2024 Jan 01-15\t\t\t13: 2024 Jul 01-15");
        System.out.println("2: 2024 Jan 16-31\t\t\t14: 2024 Jul 16-31");
        System.out.println("3: 2024 Feb 01-15\t\t\t15: 2024 Aug 01-15");
        System.out.println("4: 2024 Feb 16-29\t\t\t16: 2024 Aug 16-31");
        System.out.println("5: 2024 Mar 01-15\t\t\t17: 2024 Sep 01-15");
        System.out.println("6: 2024 Mar 16-31\t\t\t18: 2024 Sep 16-30");
        System.out.println("7: 2024 Apr 01-15\t\t\t19: 2024 Oct 01-15");
        System.out.println("8: 2024 Apr 16-30\t\t\t20: 2024 Oct 16-31");
        System.out.println("9: 2024 May 01-15\t\t\t21: 2024 Nov 01-15");
        System.out.println("10: 2024 May 16-31\t\t\t22: 2024 Nov 16-30");
        System.out.println("11: 2024 Jun 01-15\t\t\t23: 2024 Dec 01-15");
        System.out.println("12: 2024 Jun 16-30\t\t\t24: 2024 Dec 16-31");
    }
    
}
