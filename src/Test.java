import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		EligibleCalculator EC = new EligibleCalculator();
		String fileName = "Test.csv";
		File file = new File(fileName);
		 Scanner scan = new Scanner(System.in);
		 
		try 
		{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] sentence = data.split(",");
				try 
				{
				EC.insertFarmer(new Farmer(Integer.parseInt(sentence[0]),
						Double.parseDouble(sentence[1]),
						Integer.parseInt(sentence[2]),
						sentence[3], 
						Integer.parseInt(sentence[4]), 
						sentence[5],
						sentence[6], 
						Double.parseDouble(sentence[7]), 
						Integer.parseInt(sentence[8])));
				} catch (Exception e) 
				{
					
				}
						
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("What do you want to do?\n1- Display farmer information by ID."
				+ "\n2- Display information of all eligible farmers."
				+ "\n3- Display eligible farmers IDs."
				+ "\n4- Add new farmer. " );
		
		String choice = "0";
		
		do {
			
			 System.out.print("Enter a number -> ");
			 choice = scan.next();
			if(!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equals("3") || choice.equals("4")))
				System.out.println("------------\nError, try again\n------------");
			
		}while(!(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equals("3") || choice.equals("4")));
		
		String YorN = "Q";
		boolean option = true;
		//============================================
		while(option) 
		{
			
		if(YorN.equalsIgnoreCase("Y")) {
			System.out.println("What do you want to do?\n1- Display farmer information by ID."
					+ "\n2- Display information of all eligible farmers."
					+ "\n3- Display eligible farmers IDs."
					+ "\n4- Add new farmer. " );
			do {
				
				System.out.print("Enter a number -> ");
				choice = scan.next();
				if(!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")))
					System.out.println("------------\nError, try again\n------------");
				
			}while(!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")));
		}
		
		if(choice.equalsIgnoreCase("3"))
		EC.returnElFarmer();
		
		if(choice.equalsIgnoreCase("1")) 
		{
			if(EC.allFarmer.size() == 0) 
				System.out.println("There is no farmers to search.");
				
			else {
				boolean isString = true;
				String selectedID = null;

				System.out.println("Enter ID from "+1+" to "+EC.allFarmer.size());
				do {
		   System.out.print("->"); 
		   selectedID = scan.next();
		   
			for(int i = 0 ; i < selectedID.length(); i++) 
			{ 
				if(selectedID.charAt(i) >= 48 && selectedID.charAt(i) <= 71)
					isString = false;
				else 
				{
					isString = true;
					break;
			}
				}
							
			   if(isString || Integer.parseInt(selectedID) > EC.allFarmer.size()) 
			   {
				System.out.println("Wrong ID,try again from "+1+" to "+EC.allFarmer.size());
				isString = true;
			   }
			   
				}while(isString);
			
			EC.displayByID(Integer.parseInt(selectedID));
				
		}
			}
		
		if(choice.equalsIgnoreCase("2")) 
		{
			if(EC.allFarmer.size() == 0) 
				System.out.println("There is no farmers to search.");			
			EC.displayAllEligibleFarmers();
		}
		
		if(choice.equalsIgnoreCase("4")) 
		{
			
			String salary = null; 
			String age = null; 
			String socialStatus = null; 
			String numberOfChild = null; 
			String citizinAccount = null; 
			String otherIncome = null;
			String balance = null;
			String numberOfSheeps = null;
			 
			EC.addNewFarmerByUser(EC.allFarmer.size()+1, salary, age, socialStatus, numberOfChild, citizinAccount, otherIncome, 
					balance, numberOfSheeps);
		}
		
		
		
		System.out.print("Do you want another service? (Y / N)? ");
		int tracker = 0;
		do {
		 tracker = 0;
		YorN = scan.next();
		
		if(YorN.equalsIgnoreCase("Y")) {
			tracker = 1;
			option = true;}
		else if(YorN.equalsIgnoreCase("N")) {
			tracker = 2;
			option = false;}
		else {
			System.out.println("Wrong Input, try Again (Y or N). ");
			tracker = 3;
		}
		}while(tracker == 3);
		}
		//============================================

		System.out.println("\nDone.");
		scan.close();
		System.exit(0);
	}
	
}
