import java.util.Scanner;


public class Person {
//	class ProjectEntity{
		static String name;
		private String phone;
		private String email;
		private String physicalAddress;
//}
	   
	   public String getName() {
		   return name;
	   }
	   public String getPhone() {
		   return phone;
	   }
	   public String getEmail() {
		   return email;
	   }
	   public String getAddress() {
		   return physicalAddress;
	   }
	   
	   
	   public void setName(String newName) {
		    this.name = newName;
		  }
	   public void setPhone(String newPhone) {
		    this.phone = newPhone;
		  }
	   public void setEmail(String newEmail) {
		    this.email = newEmail;
		  }
	   public void setAddress(String newAddress) {
		    this.physicalAddress = newAddress;
		  }
	   
		public static void inputPersonData() {
			// Enter Architect Details
			Scanner Project = new Scanner(System.in);
			
//			System.out.print("Enter Architect Name: ");
//			this.architect.name = Project.nextLine();
//			
//			System.out.print("Enter Architect Phone Number: ");
//			this.architect.phone = Project.nextLine();
//			
//			System.out.print("Enter Architect Email: ");
//			this.architect.email = Project.nextLine();
//			
//			System.out.print("Enter Architect Physical Address: ");
//			this.architect.physicalAddress = Project.nextLine();
//			
//			// Enter Contractor Details
//			System.out.print("Enter Contractor Name: ");
//			this.contractor.name = Project.nextLine();
//			
//			System.out.print("Enter Contractor Phone Number: ");
//			this.contractor.phone = Project.nextLine();
//			
//			System.out.print("Enter Contractor Email: ");
//			this.contractor.email = Project.nextLine();
//			
//			System.out.print("Enter Contractor Physical Address: ");
//			this.contractor.physicalAddress = Project.nextLine();
			
			// Enter Customer Details
			System.out.print("Enter Customer Name: ");
			name = Project.nextLine();
			
//			System.out.print("Enter Customer Phone Number: ");
//			this.customer.phone = Project.nextLine();
//			
//			System.out.print("Enter Customer Email: ");
//			this.customer.email = Project.nextLine();
//			
//			System.out.print("Enter Customer Physical Address: ");
//			this.customer.physicalAddress = Project.nextLine();
		}
		public String outFilePersonData() {
			String out = name;
			
			return out;
		}
		
}
