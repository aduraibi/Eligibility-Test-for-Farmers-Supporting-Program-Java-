import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class EligibleCalculator {

	public ArrayList<Farmer> allFarmer = new ArrayList<Farmer>();
	
	public void insertFarmer(Farmer f) 
	{
		allFarmer.add(f);
		
	}
	
	// 1
	public void displayByID(int id) {

		for (int i = 0; i < allFarmer.size(); i++) {
			if (allFarmer.get(i).returnID() == id) {
				System.out.print("------------\nFarmer Information:- \nID: " + id +
						"\nSalary: $" + allFarmer.get(i).getSalary() + 
						"\nAge: " + allFarmer.get(i).getAge());
				if (allFarmer.get(i).getSocialStatus().equalsIgnoreCase("M"))
					System.out.print("\nSocial Status: Married");
				else
					System.out.print("\nSocial Status: Single");
				System.out.print("\nNumber of Children: " + allFarmer.get(i).getNumberOfChild());

				if (allFarmer.get(i).getCitizinAccount().equalsIgnoreCase("Y"))
					System.out.print("\nHas a Citizen Account: Yes");
				else
					System.out.print("\nHas a Citizen Account: No");
				
				if (allFarmer.get(i).getOtherIncome().equalsIgnoreCase("Y"))
					System.out.print("\nHas Other Income: Yes");
				else
					System.out.print("\nHas Other Income: No");
				System.out.print("\nBalance: $" + allFarmer.get(i).getBalance() +
						"\nNumber of Sheeps: " + allFarmer.get(i).getNumberOfSheeps());
					
				if (allFarmer.get(i).isQualified())
					System.out.println("\nThe farmer is eligible");
				else 
				{
					System.out.println("\n___________\nThe farmer is not eligible because:- ");
					if (allFarmer.get(i).getSalary() >= 10000)
						System.out.println("Salary is: $" + allFarmer.get(i).getSalary() + ", and salary must be less than 10000");
					if (allFarmer.get(i).getAge() < 20 || allFarmer.get(i).getAge() > 70)
						System.out.println("Age is: " + allFarmer.get(i).getAge() + ", and age must be between 20 and 70");
					if (allFarmer.get(i).getSocialStatus().equalsIgnoreCase("S"))
						System.out.println("Farmer is Single");
					if (allFarmer.get(i).getNumberOfChild() < 3)
						System.out.println("Childrens is less than 3 Childrens");
					if (allFarmer.get(i).getCitizinAccount().equalsIgnoreCase("N"))
						System.out.println("Farmer has not citizin account");
					if (allFarmer.get(i).getOtherIncome().equalsIgnoreCase("Y"))
						System.out.println("Farmer have other income");
					if (allFarmer.get(i).getBalance() >100000)
						System.out.println("Balance is: $" + allFarmer.get(i).getBalance() + ", and balance more than 100000");
					if (allFarmer.get(i).getNumberOfSheeps() > 50000)
						System.out.println("Farmer have more than 50000 sheeps");
				}
				
				System.out.println("================================================");

			}

		}
	}
	
	// 2
	public void displayAllEligibleFarmers()
	{
		int id;
		int counter = 1 ;
		System.out.println("=============================================================================================================================");
		System.out.println("*- [  ID , salary , age , Social Status , Number Of Child , Citizin Account , Other Income , Balance , Number Of Sheeps ]*\n----------");
		for (int i =0; i < allFarmer.size() ; i++ )
		{
			if (allFarmer.get(i).isQualified())
			{
				System.out.print(counter+++"- [ " +allFarmer.get(i).getId() + " , " +
						"$" + allFarmer.get(i).getSalary()+" , " + 
						 allFarmer.get(i).getAge()+" , ");
					System.out.print("Married , ");
				System.out.print(allFarmer.get(i).getNumberOfChild()+" , ");
					System.out.print("Yes , ");
					System.out.print("No , ");
				System.out.print("$" + allFarmer.get(i).getBalance()+" , " +
						 allFarmer.get(i).getNumberOfSheeps()+ " ]\n");
			}
		}
		System.out.println("============================================================================================================================="
				+ "");

	}
	
	//3
	public void returnElFarmer()
	{
		int tracker1 = 0;
		int tracker2 = 0;
		System.out.println("------------");
		for (int i=0 ; i< allFarmer.size() ; i++) 
		{
				if (allFarmer.get(i).isQualified()) {
					tracker1++;
					if(tracker1 == 1)
						System.out.print("Eligible farmers ID is: [ ");

					System.out.print(allFarmer.get(i).returnID());
					
					tracker2 = 0;
					for (int j=i+1 ; j < allFarmer.size() ; j++) 
					{
							if (allFarmer.get(j).isQualified()) {
									tracker2++;
									break;}
					}	
					if(tracker2 > 0)
						System.out.print(", ");
					else
						System.out.println(" ]");
		}}
		if(tracker1 == 0)
			System.out.println("There is no Eligible farmers.");
		System.out.println("------------");
	}
	
	//4
	public void addNewFarmerByUser(int id, String salary, String age, String socialStatus, String numberOfChild, String citizinAccount, 
			String otherIncome, String balance, String numberOfSheeps) {
		
		String fileName = "Test.csv";
		File file = new File(fileName);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------------ Start Adding Process  ------------");
		
		boolean isString = true;
		//==================================Salary========================================
		System.out.println("A) Enter the salary: ");
		do {
		System.out.print("->");
		salary = scan.next();
		int dotTracker = 0; 
		for(int i = 0 ; i < salary.length(); i++) { 
			if((salary.charAt(i) >= 48 && salary.charAt(i) <= 57) || (salary.charAt(i) == 46 && i > 0 && dotTracker == 0)) 
			{
				if(salary.charAt(i) == 46)
				dotTracker++;
				isString = false;}
			else {
				isString = true;
				break;}}

		if(isString)
			System.out.println("Wrong input, try again");
		}while(isString);
		//==================================Age========================================
		System.out.println("B) Enter the age: ");
		do {
		System.out.print("->");
		age = scan.next();
		for(int i = 0 ; i < age.length(); i++) { 
			if(age.charAt(i) >= 48 && age.charAt(i) <= 57)
				isString = false;
			else {
				isString = true;
				break;}}
		if(isString)
		System.out.println("Invalid input, try again");
		}while(isString);
		//==================================SS========================================
		System.out.println("C) the Social status Married or Single, Enter (M or S):");
		do {
		System.out.print("->");
		socialStatus = scan.next();
		if(!(socialStatus.equalsIgnoreCase("M") || socialStatus.equalsIgnoreCase("S")))
				System.out.println("Unacceptable data, only enter (M or S): ");
		}while(!(socialStatus.equalsIgnoreCase("M") || socialStatus.equalsIgnoreCase("S")));
		//==================================noC========================================
		System.out.println("D) How many children? ");
		do {
		System.out.print("->");
		numberOfChild = scan.next();
		for(int i = 0 ; i < numberOfChild.length(); i++) { 
			if(numberOfChild.charAt(i) >= 48 && numberOfChild.charAt(i) <= 57)
				isString = false;
			else {
				isString = true;
				break;}}
		if(isString)
			System.out.println("Error, the Number must be Positive number or zero.");
		}while(isString);
		//==================================C-A========================================
		System.out.println("E) Is the farmer has citizen account (Y or N)");
		do {
			System.out.print("->");
			citizinAccount = scan.next();
			if(!(citizinAccount.equalsIgnoreCase("Y") || citizinAccount.equalsIgnoreCase("N")))
				System.out.println("Error, Must be the Input \"Yes or No\" enter (Y or N):");
		}while(!(citizinAccount.equalsIgnoreCase("Y") || citizinAccount.equalsIgnoreCase("N")));
		//==================================O-income========================================
		System.out.println("F) Is the farmer has other income (Y or N)");
		do {
			System.out.print("->");
			otherIncome = scan.next();
			if(!(otherIncome.equalsIgnoreCase("Y") || otherIncome.equalsIgnoreCase("N")))
				System.out.println("Error, Must be the Input \"Yes or No\" enter (Y or N):");
		}while(!(otherIncome.equalsIgnoreCase("Y") || otherIncome.equalsIgnoreCase("N")));
		//==================================Balance========================================
		System.out.println("G) How much is the balance of the farmer?");
		do {
			System.out.print("->");
			balance = scan.next();
			int dotTracker = 0; 
			for(int i = 0 ; i < balance.length(); i++) { 
				if((balance.charAt(i) >= 48 && balance.charAt(i) <= 57) || (balance.charAt(i) == 46 && i > 0 && dotTracker == 0)) 
				{
					if(balance.charAt(i) == 46)
					dotTracker++;
					isString = false;}
				else {
					isString = true;
					break;}}
			if(isString)
				System.out.println("Error, The balance must a number with positive or zero number.");
		}while(isString);
		//==================================noS========================================
		System.out.println("H) How many sheep?");
		do {
			System.out.print("->");
			numberOfSheeps = scan.next();
			for(int i = 0 ; i < numberOfSheeps.length(); i++) { 
				if(numberOfSheeps.charAt(i) >= 48 && numberOfSheeps.charAt(i) <= 57)
					isString = false;
				else {
					isString = true;
					break;}}
			if(isString)
				System.out.println("Error, The number of sheeps must be positive number or zero.");
		}while(isString);
		//==========================================================================
		
		this.insertFarmer(new Farmer(id, Double.parseDouble(salary), Integer.parseInt(age), socialStatus.toUpperCase(), Integer.parseInt(numberOfChild), citizinAccount.toUpperCase(), otherIncome.toUpperCase(), 
				Double.parseDouble(balance), Integer.parseInt(numberOfSheeps)));
		
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.println(id+","+ salary+","+ age+","+ socialStatus.toUpperCase()+","+ numberOfChild+","+ citizinAccount.toUpperCase()+","+ otherIncome.toUpperCase()+","+ 
					balance+","+numberOfSheeps);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("Adding complete, ID is: " + allFarmer.size() + " and farmer is: ");
		if (allFarmer.get(allFarmer.size() - 1).isQualified())
			System.out.println("Eligible");
		else
			System.out.println("Not Eligible");
		
	}
}
