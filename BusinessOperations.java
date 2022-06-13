

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.InputStreamReader; //converts bits to strings.
	import java.nio.file.FileAlreadyExistsException;
	import java.util.Arrays;
	import java.util.InputMismatchException;
	import java.util.List;
	public class BusinessOperations extends Application {
		public int displayOperation()
		{
			System.out.println("Business Level Operations : \n");
			System.out.println("Select the operations you want to perform");
			System.out.println("1.Add a file to the existing directory list");
			System.out.println("2.Delete a user specified file from the existing directory list");
			System.out.println("3.Search a file from the main directory");
			System.out.println("4.Navigate to main options");
			try {
			int operation=sc.nextInt();
			//System.out.println("\n--------------------------------------------------------------------------------------");
			return operation;
			}
			catch(InputMismatchException ie)
			{
				System.out.println("Invalid Selection, Select appropriate option");
				return 0;
			}
			catch(Exception e)
			{
				System.out.println(e);
				return 0;
			}
		}

		public void addFile(String path) {
			String filename="";
			try {
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the file name : ");
				
				//reading file
				filename=br.readLine();
				//System.out.println("\n--------------------------------------------------------------------------------------");
				File file=new File(path+File.separator+filename+".txt");
				file.createNewFile();
				System.out.println("File added Successfully");
				System.out.println("\n--------------------------------------------------------------------------------------");
				
			}
			catch(FileAlreadyExistsException x) {
				System.err.format("file name "+filename+" already exist");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
		}
		public void searchFile(String path)
		{
			
			System.out.println("Enter the file name you want to search : ");
			String filename=sc.next();
			//System.out.println("\n--------------------------------------------------------------------------------------");
			filename=filename+".txt";
			File dir=new File(path);
			String files[]=dir.list();
			List<String> list=Arrays.asList(files);
			boolean flag=false;
			
			try
			{
			for(String file:list)
			{
			if(file.equals(filename))
			{
				flag=true;
				
				break;
			}
			
			}
			if(flag)
			{
				System.out.println(filename+" "+"found successfully");
				System.out.println("\n--------------------------------------------------------------------------------------");
			}
			else
			{
				System.out.println(filename+" "+"not found");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);	
			}
			
			
			
		}
		public void deleteFile(String path)
		{
			try {
				
			System.out.println("Enter name of the file to be deleted :");
			String filename=sc.next();
			filename=filename+".txt";
			File file=new File(path+File.separator+filename);
			
			
			File directoryPath=new File(path);
			String list[]=directoryPath.list();
			
			boolean flag=false;
				
			for(String content: list)
			{
				
					if(filename.equals(content))
					{
						
						 flag=file.delete();
						 break;
					}
					else
						flag=false;
						
			}
			if(flag) {
				System.out.println(filename+" successfully Deleted");
				System.out.println("\n--------------------------------------------------------------------------------------");
				
				}
			else
			{
				System.out.println("File Not Found\nFailed to delete file");
			}
			
			
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		public void goBack()
		{
			
			options();//navigating back to main option
		}
	}



