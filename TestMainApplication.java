import java.util.Scanner;
public class TestMainApplication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("*************************************************************************************");
		Application app=new Application();  //creating object of Application class.
		app.welcome();
		System.out.println("*************************************************************************************");
		
		while(true)
		{
			System.out.println("\nDo you want to Proceed ? (Y/N)");
			char ch=sc.next().charAt(0);
			
			app.display(ch);
				
		}
		
		
	}

}
