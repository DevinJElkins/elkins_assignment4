package elkins_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class DuplicateCounter {
	//Set of strings in map
	private Map<String,Integer> wordCounter;
	//Instance method called remove that takes a single parameter called dataFile
	public void count1(String dataFile) throws FileNotFoundException
	{
		String words;
		wordCounter = new HashMap<String,Integer>();
		//Create scanner class
		Scanner sc=new Scanner(new File(dataFile));
		//Only stores the unique words
		while(sc.hasNext())
		{
			words=sc.next();
			if (wordCounter.containsKey(words)) {
				wordCounter.put(words, wordCounter.get(words) + 1);
			}
			else {
				wordCounter.put(words, 1);
			}
		}
		sc.close();
	}
	//An instance method called write that takes a single parameter called outputFile.
	public void write(String outputFile) throws IOException
	{
		File f1;
		FileWriter fw = null;
		f1 = new File(outputFile);
		if(!f1.exists()) {
			f1.createNewFile();
		}
		fw=new FileWriter(f1);
		for (Map.Entry entry : wordCounter.entrySet()) {
			fw.write(entry.getKey() + " " + entry.getValue()+"\n");
		}
		//Close the file.
		fw.close();
		System.out.println("Successful");
	}
}