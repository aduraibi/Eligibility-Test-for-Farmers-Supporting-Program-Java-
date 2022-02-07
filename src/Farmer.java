public class Farmer {

	private int id;
	private double salary;
	private int age;
	private String socialStatus;
	private int numberOfChild;
	private String citizinAccount;
	private String otherIncome;
	private Double balance;
	private int numberOfSheeps;
	private boolean isQualified;
	
	public Farmer(int id, double salary, int age, String socialStatus, int numberOfChild, String citizinAccount, 
			String otherIncome, Double balance, int numberOfSheeps) {
		this.id = id;
		this.salary = salary;
		this.age = age;
		this.socialStatus = socialStatus;
		this.numberOfChild = numberOfChild;
		this.citizinAccount = citizinAccount;
		this.otherIncome = otherIncome;
		this.balance = balance;
		this.numberOfSheeps = numberOfSheeps;
		isQualified = false;
		
		if ( salary >= 0 && salary < 10000)
		{
			if (age >= 20 && age <= 70)
			{
				if (socialStatus.equals("M"))
				{
					if (numberOfChild > 2)
					{
						if(citizinAccount.equals("Y")) 
						{
							if(otherIncome.equals("N"))
							{
								if(balance >= 0 && balance <= 100000)
								{
									if(numberOfSheeps >= 0 && numberOfSheeps <= 50000)
									{
										isQualified = true;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public int returnID (){
		return id;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	public String getSocialStatus() {
		return socialStatus;
	}

	public int getNumberOfChild() {
		return numberOfChild;
	}

	public String getCitizinAccount() {
		return citizinAccount;
	}

	public String getOtherIncome() {
		return otherIncome;
	}

	public Double getBalance() {
		return balance;
	}

	public int getNumberOfSheeps() {
		return numberOfSheeps;
	}

	public boolean isQualified() {
		return isQualified;
	}

	public void setQualified(boolean isQualified) {
		this.isQualified = isQualified;
	}
	
}
