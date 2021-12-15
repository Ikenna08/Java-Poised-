import java.util.Scanner;
import java.util.Arrays;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Poised {
	public static String options;
	public static Scanner Choose = new Scanner(System.in);
	
	public String menuOption() {
		System.out.print("\nWhat would you like to do?\n1. Add New Project \n2. Display All Project \n3. Update Project Completion Date \n4. Update Project Total Amount To Date  \n5. Display Uncompleted Project \n6. Display projects that are past the due date \n7. Find and select a project by project Name or Number \n8. Finalise Project \n9. Exit Program \n\nEnter option between 1 to 9: ");
		options = this.Choose.nextLine();
		return options;
	}
	
	public int inputFileSize(String fn) {
		int lines = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fn));
			while (reader.readLine() != null) lines++;
			reader.close();
		}
		catch (IOException e) {
				System.out.println("File Size Error: "+e);
		}
		return lines;
	}
	
	public static void main(String[] args) {
		Poised p = new Poised();
		int pcnt;
		String pjnumData;
		String fileName = "myprojectfile.txt";
		File projectFile = new File(fileName);
		boolean fileExists = projectFile.exists();
		
		int pjnum = p.inputFileSize(fileName);
		System.out.println("Project File Exist: "+fileExists);
		System.out.println("Project File Count is: "+pjnum);
		Project[] myproject  = new Project[pjnum];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			for(int i=0; i< pjnum;i++){
				String stringLine = reader.readLine();
				String[] parts = stringLine.split(",");
				
				myproject[i] = new Project();
					myproject[i].projectNumber = parts[0];
					myproject[i].projectName = parts[1];
					myproject[i].projectType = parts[2];
					myproject[i].physicalAddress = parts[3];
					myproject[i].ERFnumber = parts[4];
					myproject[i].totalAmountCharged = parts[5];
					myproject[i].totalAmountToDate = parts[6];
					myproject[i].deadlineDate = parts[7];
					myproject[i].status = parts[8];
					
					myproject[i].architect.name = parts[9];
					myproject[i].architect.phone = parts[10];
					myproject[i].architect.email = parts[11];
					myproject[i].architect.physicalAddress = parts[12];
					
					myproject[i].contractor.name = parts[13];
					myproject[i].contractor.phone = parts[14];
					myproject[i].contractor.email = parts[15];
					myproject[i].contractor.physicalAddress = parts[16];
					
					myproject[i].customer.name = parts[17];
					myproject[i].customer.phone = parts[18];
					myproject[i].customer.email = parts[19];
					myproject[i].customer.physicalAddress = parts[20];
					
					if (myproject[i].projectName.equals("") || myproject[i].projectName.equals("null") || myproject[i].projectName.equals(" ")) {
						String namestr = myproject[i].customer.name;
						myproject[i].projectName = myproject[i].projectType +" "+ namestr.substring(namestr.lastIndexOf(" ")+1);
					}
			}
			reader.close();
		}
		catch (IOException e) {
				System.out.println("File Size Error: "+e);
		}
		
		String opt = p.menuOption();
		
		while(!options.equals("9")) {
			switch (opt) {
			  case "1":
			  	int newarrsize = myproject.length;
				pjnum = newarrsize + 1;
				System.out.println("--Add New Project--");
				Project[] newProject = Arrays.copyOf(myproject, pjnum);
				myproject = newProject;
				System.out.println("======= Enter Data For Project "+pjnum+" =======");
				myproject[pjnum-1] = new Project();
				myproject[pjnum-1].inputData();
				
				break;
				
			  case "2":
				System.out.println("--Display All Project--");
				for(int i=0; i< pjnum;i++){
					pcnt = i + 1;
					System.out.println("======= Display Data For Project "+pcnt+" =======");
					myproject[i].displayData();
					System.out.println(" ");
				}
				break;
			  case "3":
				System.out.println("--Update Project Completion Date--");
				System.out.print("Enter project: ");
				pjnumData = Choose.nextLine();
				for(int i=0; i< pjnum;i++){
					if(pjnumData.equals(myproject[i].getProjectNumber())){
						myproject[i].updateDate();
					}
				}
				break;
			  case "4":
				System.out.println("--Update Project Total Amount To Date--");
				System.out.print("Enter project: ");
				pjnumData = Choose.nextLine();
				for(int i=0; i< pjnum;i++){
					if(pjnumData.equals(myproject[i].getProjectNumber())){
						myproject[i].updateAmount();
					}
				}
				break;
			  case "5":
				System.out.println("--Display Uncompleted Project--");
				for(int i=0; i< pjnum;i++){
					if(myproject[i].getProjectStatus().equals("Pending")){
						pcnt = i + 1;
						System.out.println("======= Display Data For Project "+pcnt+" =======");
						myproject[i].displayData();
						System.out.println(" ");
					}
				}
				break;
			  case "6":
				System.out.println("--Display projects that are past the due date--");
				for(int i=0; i< pjnum;i++){
					try
					{
						if (new SimpleDateFormat("dd/MM/yyyy").parse(myproject[i].getDeadlineDate()).before(new Date())) 
						{
							pcnt = i + 1;
							System.out.println("======= Display Data For Project "+pcnt+" =======");
							myproject[i].displayData();
							System.out.println(" ");
						}
					} 
					catch (Exception ex)
					{
						System.out.println("Date format error");
					}
		
				}
				break;
			  case "7":
				System.out.println("--Find and select a project by project Name or Number--");
				System.out.print("Enter Project Name or Number: ");
				String pjnumFindData = Choose.nextLine();
				for(int i=0; i< pjnum;i++){
					if(pjnumFindData.equals(myproject[i].getProjectNumber()) || pjnumFindData.equals(myproject[i].getProjectName())){
						myproject[i].displayData();
					}
				}
				break;
			  case "8":
				System.out.println("--Finalise Project--");
				System.out.print("Enter project: ");
				pjnumData = Choose.nextLine();
				for(int i=0; i< pjnum;i++){
					if(pjnumData.equals(myproject[i].getProjectNumber())){
						myproject[i].finaliseProject();
						String outFileData = myproject[i].outFileData();
						try {
							PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("completed_project.txt", true)));
							out.println(outFileData);
							out.close();
						} 
						catch (IOException e) {
							System.out.println("Error writing finalise project to file");
						}
					}
				}
				break;
			  case "9":
				System.out.println("Option 9 to exit program");
				break;
			  default:
				System.out.println("Invalid Option Entered");
			}
			opt = p.menuOption();
		}
		try {
			PrintWriter clearFileDataOut = new PrintWriter(new BufferedWriter(new FileWriter("myprojectfile.txt")));
			clearFileDataOut.close();
		} 
		catch (IOException e) {
			System.out.println("Error erasing file data");
		}
		for(int i=0; i< pjnum;i++){
			String outFileData = myproject[i].outFileData();
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myprojectfile.txt", true)));
				out.println(outFileData);
				out.close();
			} 
			catch (IOException e) {
				System.out.println("Error writing finalise project to file");
			}
		}
		System.out.println("Project file has been updated...");
		System.out.println("Program Exited. With option "+opt+"... goodbye!");
	}
}