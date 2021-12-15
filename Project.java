import java.util.Scanner;

class ProjectEntity
{
	String name;
	String phone;
	String email;
	String physicalAddress;
}

public class Project{

	// Attributes
   public  String projectNumber;
   public  String projectName;
   public  String projectType;
   public  String physicalAddress;
   public  String ERFnumber;
   public  String totalAmountCharged;
   public  String totalAmountToDate;
   public  String deadlineDate;
   public  String status = "Pending";
   
   ProjectEntity architect = new ProjectEntity();
   ProjectEntity contractor = new ProjectEntity();
   ProjectEntity customer = new ProjectEntity();
   
   // Methods

	public void inputData() {
		//Person.inputPersonData();
		Scanner Project = new Scanner(System.in);
		
		// Enter Project Details
		System.out.print("Enter Project Number: ");
		this.projectNumber = Project.nextLine();
		
		System.out.print("Enter Project Name: ");
		this.projectName = Project.nextLine();
		
		System.out.print("Enter Project Type: ");
		this.projectType = Project.nextLine();
		
		System.out.print("Enter Project Physical Address: ");
		this.physicalAddress = Project.nextLine();
		
		System.out.print("Enter Project ERF Number: ");
		this.ERFnumber = Project.nextLine();
		
		System.out.print("Enter Project Total Amount Charged: ");
		this.totalAmountCharged = Project.nextLine();
		
		System.out.print("Enter Project Total Amount Paid To Date: ");
		this.totalAmountToDate = Project.nextLine();
		
		System.out.print("Enter Project Deadline Date(dd/mm/yyy): ");
		this.deadlineDate = Project.nextLine();
		
		// Enter Architect Details
		System.out.print("Enter Architect Name: ");
		this.architect.name = Project.nextLine();
		
		System.out.print("Enter Architect Phone Number: ");
		this.architect.phone = Project.nextLine();
		
		System.out.print("Enter Architect Email: ");
		this.architect.email = Project.nextLine();
		
		System.out.print("Enter Architect Physical Address: ");
		this.architect.physicalAddress = Project.nextLine();
		
		// Enter Contractor Details
		System.out.print("Enter Contractor Name: ");
		this.contractor.name = Project.nextLine();
		
		System.out.print("Enter Contractor Phone Number: ");
		this.contractor.phone = Project.nextLine();
		
		System.out.print("Enter Contractor Email: ");
		this.contractor.email = Project.nextLine();
		
		System.out.print("Enter Contractor Physical Address: ");
		this.contractor.physicalAddress = Project.nextLine();
		
		// Enter Customer Details
		System.out.print("Enter Customer Name: ");
		this.customer.name = Project.nextLine();
		
		System.out.print("Enter Customer Phone Number: ");
		this.customer.phone = Project.nextLine();
		
		System.out.print("Enter Customer Email: ");
		this.customer.email = Project.nextLine();
		
		System.out.print("Enter Customer Physical Address: ");
		this.customer.physicalAddress = Project.nextLine();
		
		if (this.projectName.equals("") || this.projectName.equals(null) || this.projectName.equals(" ")) {
			String namestr = getProjectName();
			this.projectName = this.projectType +" "+ namestr.substring(namestr.lastIndexOf(" ")+1);
		}
		
	}
	
	public String outFileData() {
		String out = this.projectNumber+","+this.projectName+","+this.projectType+","+this.physicalAddress+","+this.ERFnumber+","+this.totalAmountCharged+","+this.totalAmountToDate+","+this.deadlineDate+","+this.status;
		
		return out;
	}
	
	public void displayData()
	{		
		// Display Project Details
		System.out.println("Project Number: "+this.projectNumber);
		System.out.println("Project Name: "+this.projectName);
		System.out.println("Project Type: "+this.projectType);
		System.out.println("Project Physical Address: "+this.physicalAddress);
		System.out.println("Project ERF Number: "+this.ERFnumber);
		System.out.println("Project Total Amount Charged: "+this.totalAmountCharged);
		System.out.println("Project Total Amount Paid To Date: "+this.totalAmountToDate);
		System.out.println("Project Deadline Date: "+this.deadlineDate);
		System.out.println("Project Status: "+this.status);
		
//		// Display Architect Details
		System.out.println("Architect Name: "+this.architect.name);
		System.out.println("Architect Phone Number: "+this.architect.phone);
		System.out.println("Architect Email: "+this.architect.email);
		System.out.println("Architect Physical Address: "+this.architect.physicalAddress);
		
		// Display Contractor Details
		System.out.println("Contractor Name: "+this.contractor.name);
		System.out.println("Contractor Phone Number: "+this.contractor.phone);
		System.out.println("Contractor Email: "+this.contractor.email);
		System.out.println("Contractor Physical Address: "+this.contractor.physicalAddress);
//		
//		// Display Customer Details
		System.out.println("Customer Name: "+this.customer.name);
		System.out.println("Customer Phone Number: "+this.customer.phone);
		System.out.println("Customer Email: "+this.customer.email);
		System.out.println("Customer Physical Address: "+this.customer.physicalAddress);
		
	}
	
	public void updateAmount()
	{
		Scanner Project = new Scanner(System.in);
		System.out.println("Enter New Total Amount Paid To Date: ");
		
		String PAmount = Project.nextLine();		
		this.totalAmountToDate = PAmount;
		System.out.println("**Project Total Amount Updated**");
	}
	
	public void updateDate()
	{
		Scanner Project = new Scanner(System.in);
		System.out.println("Enter New Deadline Date: ");
		
		String PDate = Project.nextLine();		
		this.deadlineDate = PDate;
		System.out.println("**Project Deadline Date Updated**");
	}
	
	public void finaliseProject()
	{
		try
		{
			int amtCharged = Integer.parseInt(this.totalAmountCharged);
			int amtPaid = Integer.parseInt(this.totalAmountToDate);
			
			int balanceToPay = amtCharged - amtPaid;
		
			if(balanceToPay > 0)
			{
				System.out.println("********* Customer Invoice *********");
				// Display customer details and amount to pay
				System.out.println("Customer Name: "+this.customer.name);
				System.out.println("Customer Phone Number: "+this.customer.phone);
				System.out.println("Customer Email: "+this.customer.email);
				System.out.println("Customer Physical Address: "+this.customer.physicalAddress);
				System.out.println("Total Amount Due = R"+balanceToPay);
			}
			else
			{
				this.status = "Finalised";
				System.out.println("Project has been finalised...");
			}
		} 
		catch (Exception ex)
		{
			System.out.println("Either total amount charged or total amount to date is not number");
		}
		
	}
	
	public String getDeadlineDate()
	{
		return this.deadlineDate;
	}
	
	public String getProjectNumber()
	{
		return this.projectNumber;
	}
	
	public String getProjectName()
	{
		return this.projectName;
	}
	
	public String getProjectStatus()
	{
		return this.status;
	}
	
}