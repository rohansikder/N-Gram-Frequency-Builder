package ie.gmit.sw;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		Menu m = new Menu();
		m.showMenu();
		
		//Keyboard
		Scanner scanner = new Scanner(System.in);

		//Initialise Variables
		int selection = 0;
		String fileDir = null;
		String outputFile = null; 
		int ngramSize = 0;
		
		selection = scanner.nextInt();
		
		//Choose your option from menu
		//Big-O Notation = O(1) : Constant
		while (selection != 5 ) {	 
			 
			 Parser p = new Parser();
			 
			 //Big-O Notation = O(1): Constant
			 if(selection == 1) {
				 System.out.println("Please enter Text File Directory:");
				 System.out.println("E.g, C:\\DSA_Project\\DSA_Project\\bin\\books\\BibleGod.txt");
				 System.out.println("A folder will is included with a few Books in .txt format");

				 fileDir = scanner.next();
				 
				 m.showMenu();
				 selection = scanner.nextInt();
			 }
			 
			//Big-O Notation = O(1): Constant
			 if(selection == 2) {
				 System.out.println("Please enter N-Gram Size:");
				 ngramSize = scanner.nextInt();
				 if(ngramSize > 0) {				 
				 m.showMenu();
				 selection = scanner.nextInt();
				 }
			 }
			 
			//Big-O Notation = O(1): Constant
			 if(selection == 3) {
				 System.out.println("Please enter Output File Name:");
				 outputFile = scanner.next();
				 
				 m.showMenu();
				 selection = scanner.nextInt();
				 
			 }
			 	
			//Big-O Notation = O(1)
			 if(selection == 4) {
				 //Checks if all params are entered before building n gram
				 if(outputFile != null && ngramSize > 0 && fileDir != null) {
				 p.process(fileDir, ngramSize);
				 p.output(outputFile);
				 System.out.println("\n"+outputFile + " has been outputted in CSV format!\n");	 
				 }else {
					 System.out.println("\nPlease enter information into each menu!\n");
				 }
				 m.showMenu();
				 selection = scanner.nextInt();	 
			 }
			 
			 //Exists if any other than 1-5 is selected
			//Big-O Notation = O(1)
			 if(selection > 5 || selection <= 0) {
				 break;
			 }
			 
		}//End Of While
		
		scanner.close();
		
		//You may want to include a progress meter in you assignment!
		System.out.print(ConsoleColour.RED);	//Change the colour of the console text
		int size = 100;							//The size of the meter. 100 equates to 100%
		//Big-O Notation = O(n) : Incrementing Loop
		for (int i =0 ; i < size ; i++) {		//The loop equates to a sequence of processing steps
			printProgress(i + 1, size); 		//After each (some) steps, update the progress meter
			Thread.sleep(10);					//Slows things down so the animation is visible 
		}
	}
	

	
	/*
	 *  Terminal Progress Meter
	 *  -----------------------
	 *  You might find the progress meter below useful. The progress effect 
	 *  works best if you call this method from inside a loop and do not call
	 *  System.out.println(....) until the progress meter is finished.
	 *  
	 *  Please note the following carefully:
	 *  
	 *  1) The progress meter will NOT work in the Eclipse console, but will
	 *     work on Windows (DOS), Mac and Linux terminals.
	 *     
	 *  2) The meter works by using the line feed character "\r" to return to
	 *     the start of the current line and writes out the updated progress
	 *     over the existing information. If you output any text between 
	 *     calling this method, i.e. System.out.println(....), then the next
	 *     call to the progress meter will output the status to the next line.
	 *      
	 *  3) If the variable size is greater than the terminal width, a new line
	 *     escape character "\n" will be automatically added and the meter won't
	 *     work properly.  
	 *  
	 * 
	 */
	public static void printProgress(int index, int total) {
		//Big-O Notation = O(1)
		if (index > total) return;	//Out of range
        int size = 50; 				//Must be less than console width
	    char done = '=';			//Change to whatever you like.
	    char todo = '+';			//Change to whatever you like.
	    
	    //Compute basic metrics for the meter
        int complete = (100 * index) / total;
        int completeLen = size * complete / 100;
        
        /*
         * A StringBuilder should be used for string concatenation inside a 
         * loop. However, as the number of loop iterations is small, using
         * the "+" operator may be more efficient as the instructions can
         * be optimised by the compiler. Either way, the performance overhead
         * will be marginal.  
         */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //Big-O Notation = O(n) : Incrementing Loop
        for (int i = 0; i < size; i++) {
        	sb.append((i < completeLen) ? done : todo);
        }
        
        /*
         * The line feed escape character "\r" returns the cursor to the 
         * start of the current line. Calling print(...) overwrites the
         * existing line and creates the illusion of an animation.
         */
        System.out.print("\r" + sb + "] " + complete + "%");
        
        //Once the meter reaches its max, move to a new line.
      //Big-O Notation = O(1)
        if (done == total) System.out.println("\n");
    }
}