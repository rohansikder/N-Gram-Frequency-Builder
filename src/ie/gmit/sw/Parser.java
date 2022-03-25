package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Parser {
	private Map<String, Long> frequency = new HashMap<>();
	
	public void parse(String dir) throws Exception{
		
		String[] files = new File(dir).list();
		for(String f : files) {
			parse(f);
		}
		
	}//End of Parse
	
	public void process(String file, int ngramSize)throws Exception{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\DSA_Project\\DSA_Project\\bin\\books\\" + file)))){
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] words = line.toLowerCase().trim().split(" ");
				//A-z or a-z			
				for(String word : words) {
					char[] w = word.toCharArray();
					int p = ngramSize;
					for(int i = 0 ; i < (w.length+1-p); i++) {//Loop over word and extract n-gram1
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
				}
			}
			output(file);//To stop weird infinite loop
		}
	}//End of process
	
	public void output(String file) throws Exception{
		FileWriter fw = new FileWriter(new File(file));
		
		Set<Entry<String, Long>> kvs = frequency.entrySet();
		//Loops Over entries and write out....
				
		System.out.println(kvs.size());
		
		 for (Map.Entry<String, Long> entry : frequency.entrySet()) {
			   String key = (String) entry.getKey();
			   Long value1 = entry.getValue();
			   //System.out.println(key);
			   //System.out.println(value1);
			   
			   fw.write(key+","+value1+"\n");
		 }
		
		fw.flush();
		fw.close();
	}//End of output
	
}
