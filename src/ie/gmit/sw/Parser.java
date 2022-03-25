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
	
	public void process(String file)throws Exception{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] words = line.toLowerCase().trim().split(" ");
				
				//A-z or a-z
				
				for(String word : words) {
					char[] w = word.toCharArray();
					for(int i = 0; i < w.length; i++) {//Loop over word and extract n-gram
						frequency.put(ngram, value);
					}
				}
			}
		}
	}//End of process
	
	private void output(String file) throws Exception{
		FileWriter fw = new FileWriter(new File(file));
		
		Set<Entry<String, Long>> kvs = frequency.entrySet();
		//Loops Over entries and write out....
		fw.write("");
		
		fw.flush();
		fw.close();
	}//End of output
	
}
