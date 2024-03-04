package COMPONENTS;
import java.util.Scanner;

public class PrintPaySlip {
    
    public static void employeePaySlip() {
        Scanner scanner = new Scanner(System.in);
        
        char singleAll;
    
        
        System.out.print("Single Employee? All Employee? S/A: ");
        singleAll = Character.toUpperCase(scanner.next().charAt(0));
//        while (singleAll != 'S' || singleAll != 'A') {
//            System.out.println("Please choose between S or A . . .");
//            System.out.print("Single Employee? All Employee? S/A: ");
//            singleAll = Character.toUpperCase(scanner.next().charAt(0));
//        }
        
        System.out.println(singleAll);
//        if (singleAll != 'S' || singleAll != 'A') {
//            System.out.println("Please choose between S or A . . .");
//            return;
//        }
        System.out.println("Choose a period");
        
        
/*1*/   System.out.println("***************************************************************************************************");
/*2*/   System.out.println("*                                        Employee Pay Slip                                        *");
/*3*/   System.out.println("                                                                         |");
/*4*/   System.out.println("MotorPH Corporation  Group 4                                             |");
/*5*/   System.out.println("Cydney Rosario \t\t\t PERIOD: 2024-02-01 to 2024-02-15 \t |");
/*6*/   System.out.println("                                                                         | Basic Pay:\t21,000.00");
/*7*/   System.out.println("==================================================================================================");
/*8*/   System.out.println("Employer: MotorPH\t\t\t\tStatus: Regular\t\t | Overtime:\t3,000.00");
/*9*/   System.out.println("-------------------------------------------------------------------------| 13th Month:\t0.00");
/*10*/  System.out.println("Position: Account Rank and File                                          | Allowance:\t2,500.00");
/*11*/  System.out.println("-------------------------------------------------------------------------|");
/*12*/  System.out.println("                       |                        |                        | Gross Pay:\t21,000.00");
/*13*/  System.out.println("Overtime  Hrs   Pay    | Adjustments   Amount   | Deduction     Amount   | Deduction:\t9,200.00");
/*14*/  System.out.println("-------------------------------------------------------------------------|");
/*15*/  System.out.println(" Regular  60    351.00 | 13Month       0.00     | Tax           4,200.00 |");
/*16*/  System.out.println("                       | Incentive     0.00     | SSS           500.00   | Net Pay:\t14,300.00");
/*17*/  System.out.println("                       | Paid Leaves   0.00     | Philhealth    500.00   |");
/*18*/  System.out.println("                       | Holiday Pay   0.00     | Pag-Ibig      500.00   |");
/*19*/  System.out.println("                       | Others        0.00     | Tirediness    2,500.00 |");
/*20*/  System.out.println("                       |                        | Loan          0.00     |");
/*21*/  System.out.println("                       |                        | Others        0.00     |");
/*22*/  System.out.println("                       |                        |                        |");
/*23*/  System.out.println("                       |                        |                        |");
/*24*/  System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }
    
}
