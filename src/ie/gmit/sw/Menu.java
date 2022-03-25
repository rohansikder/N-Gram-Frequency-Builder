package ie.gmit.sw;

public class Menu {
	void showMenu()throws Exception {
		//You should put the following code into a menu or Menu class
				System.out.println(ConsoleColour.WHITE);
				System.out.println("************************************************************");
				System.out.println("*      GMIT - Dept. Computer Science & Applied Physics     *");
				System.out.println("*                                                          *");
				System.out.println("*                  N-Gram Frequency Builder                *");
				System.out.println("*                                                          *");
				System.out.println("************************************************************");
				System.out.println("(1) Specify Text File Directory");
				System.out.println("(2) Specify n-Gram Size");
				System.out.println("(3) Specify Output File");
				System.out.println("(4) Build n-Grams ");
				System.out.println("(5) Quit");
				
				//Output a menu of options and solicit text from the user
				System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
				System.out.print("Select Option [1-5]>");
				System.out.println();
	}
}
