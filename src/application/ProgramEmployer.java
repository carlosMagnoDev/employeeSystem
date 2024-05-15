package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class ProgramEmployer {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int num = input.nextInt();
		
		for (int i = 0; i < num; i++) {
			input.nextLine();
			System.out.printf("Employee #%d data:", i + 1);
			
			System.out.print("\nOutsourced (y/n)? ");
			String confirm = input.nextLine().toLowerCase();
			
			System.out.print("Name: ");
			String name = input.nextLine();
			
			System.out.print("Horus: ");
			Integer hours = input.nextInt();
			
			System.out.print("Value per hour: ");
			Double valuePerHour = input.nextDouble();
			
			if (confirm.equals("y")) { 
				System.out.print("Additional charge: ");
				Double additionalCharge = input.nextDouble();
				
				Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(employee);
				
			} else if (confirm.equals("n")) {
				Employee employee = new Employee(name, hours, valuePerHour);
				list.add(employee);
				
			} else {
				System.out.println("Error!");
				
			}
			System.out.println();
		}
		
		System.out.println("PAYMENTS:");
		for (Employee employee : list) {
			System.out.printf("%s - $ %.2f\n",employee.getName(), employee.payment());
		}
		
		input.close();
	}
}
