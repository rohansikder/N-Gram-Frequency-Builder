package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Parser {
	private Map<String, Long> frequency = new HashMap<>();
	
	public void parse(String dir) throws Exception{
		
		String[] files = new File(dir).list();
		for(String f : files) {
			parse(f);
		}
		
	}//End of Parse
	
	public void process(String file, int ngramSize)throws Exception{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
			String line = null;
			
			//C:\DSA_Project\DSA_Project\bin\books\BibleGod.txt
			
			//Big-O Notation = O(n^2)
			while((line = br.readLine()) != null) {
				//Get rid of all ASCII characters other than the alphabet
				//A-z or a-z
				line = line.trim().replaceAll("[^a-zA-Z]", "");
				String[] words = line.toLowerCase().split(" ");
				//Big-O Notation = O(n)
				for(String word : words) {
					char[] w = word.toCharArray();
					int p = ngramSize;
					
					//Big-O Notation = O(n) : Incrementing Loop
					for(int i = 0 ; i < (w.length+1-p); i++) {
						//Loop over word and extract n-gram
						String charNum = String.copyValueOf(w, i, p);
						Long wordsFound = frequency.get(charNum);
						if(wordsFound == null) {
							wordsFound = Long.valueOf(1);
						}
						else {
							Long value = wordsFound.longValue();
							wordsFound = Long.valueOf(value+1);
						}
						
						frequency.put(charNum, wordsFound); //frequency.put(ngram, value);
					}
				}//End of for loop
			}
		}
	}//End of process
	
	public void output(String file) throws Exception{
		//Automatically creates a csv file
		FileWriter fw = new FileWriter(new File(file+".csv"));
		//Loops Over entries and write out....
		
		//Big-O Notation = O(1)	 :  Hashmaps
		 for (Map.Entry<String, Long> entry : frequency.entrySet()) {
			   String key = (String) entry.getKey();
			   Long value = entry.getValue();
			   
			   //System.out.println(key);
			   //System.out.println(value1);
			   
			   //Separates ngram and value with comma
			   fw.write(key+","+value+"\n");   
		 }
		
		fw.flush();
		fw.close();
	}//End of output
	
}
