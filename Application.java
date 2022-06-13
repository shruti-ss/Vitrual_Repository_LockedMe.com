import java.util.*;
import java.io.*;
public class Application {
	
	Scanner sc=new Scanner(System.in);
	public static String directory="D:\\LockedMe";
	public void welcome()
	{
		
		System.out.println("\t\t#####  Welcome to Lockme.com  #####\n");
		System.out.println("**********************************************************************************");
		System.out.println("Developer : Shruti Salunkhe\nContact : er.shrutisalunkhe@gmail.com");
	}
	//method display to ask user if they want to proceed with the application
	public void display(char ch)
	{
		
		try
		{
			if(ch=='Y'||ch=='y')
			{
				System.out.println("\n--------------------------------------------------------------------------------------");
				options();
			}
			else if(ch=='N'||ch=='n')
			{
				    System.out.println("**********************************************************************************");
					System.out.println("\t\tThanks for visiting our Application!!Visit again!!");
					System.out.println("**********************************************************************************");
					System.exit(0); 
			}
			
			else 
			{
				throw new UserException();
				
			}
			
		}
		catch(Exception ime)
		{
	 	System.out.println("Please enter valid value (Y/N)");
		}
	}
	
	public void options()
	{
		System.out.println("Please select action you want to perform :\n");
		System.out.println("1.View the files in directory");
		System.out.println("2.Business level Operation");
		System.out.println("3.Close the Application");
		
		try
		{
		int option=sc.nextInt();
		System.out.println("\n--------------------------------------------------------------------------------------");
		option_selection(option);
		}
		catch(InputMismatchException ie)
		{
			System.out.println("Invalid Selection, Select appropriate option");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	public static void option_selection(int option)
	{
		switch(option)
		{
		
		case 1:
			System.out.print("Here are the files in directory : ");
			viewFile();
			System.out.println("\n--------------------------------------------------------------------------------------");
			
			
		break;
		
		case 2:
			
			BusinessOperations bo=new BusinessOperations();
			while(true)
			{
				
			int operation=bo.displayOperation();
			System.out.println("\n--------------------------------------------------------------------------------------");
			switch(operation)
			{
			case 1:
				bo.addFile(directory);
				break;
			case 2:
				bo.deleteFile(directory);
				break;
			case 3:
				bo.searchFile(directory);
				break;
			case 4:
				bo.goBack();
				break;
			default:
				System.out.println("Enter valid value");
				break;
			}
			
			}
			
		case 3:
			System.out.println("**********************************************************************************");
			System.out.println("\t\tThanks for visiting our Application!!Visit again!!");
			System.out.println("**********************************************************************************");
			System.exit(0); 
		default:
			System.out.println("Enter valid value");
			break;
		}
	}
	
	public static void viewFile()
	{
		
		
		
		System.out.println(directory+"\n");
		File directoryPath=new File(directory);
		String list[]=directoryPath.list();
		if(directory.length()>0)
		{
			insertionSort(list);
			for(String content: list)
			{
				System.out.println(content);
			}
		}
		else
		{
		System.out.println("The directory "+directoryPath.getPath()+" is empty");
		}
		
	}
	public static void insertionSort(String list[]) {
		int list_length=list.length;
		String key;
		
		if(list_length<=1)
		{
			return;
		}
		else
		{
			for(int j=1;j<list_length;j++)
			{
				key=list[j];
				int i=j-1;
				while(i>=0)
				{
					if(key.compareToIgnoreCase(list[i])>0)
					{
						break;
					}
					list[i+1]=list[i];
					i--;
				}
				list[i+1]=key;
			}
		}
		
		
		
		
		
	}
	

}
