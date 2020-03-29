package elkins_problem1;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    Set<String> uniqueWords;
    void remove(String dataFile) //The method to eliminate the duplicate words
    {
        Scanner input=null;
        try {
            uniqueWords = new LinkedHashSet<>(); //Set to store strings from the file
            input = new Scanner(new File(dataFile)); //Scanner object. Used to read file.
            while(input.hasNextLine()) //While loop for reading the entire file
            {
                String line=input.nextLine(); //Reading a line from the file.
                String[] words=line.split(" "); //Clarifies where the words are separate using a space.
                for(int i=0;i<words.length;i++) {
                    String str=words[i].toLowerCase(); //Converts the words to lowercase.
                    uniqueWords.add(str); 
                }
            }

        }
        catch(Exception e)
        {
            System.out.println("Error while opening file: "+dataFile);
        }
        if(input!=null)
            input.close();


    }
    void write(String outputFile) //Method to write uniqueWords to the designated output file.
    {
        FileWriter output=null;
        try {
            output = new FileWriter(outputFile); //Opens file.
            for(String s:uniqueWords) //Iterating through uniqueWords set.
                output.write(s+"\n"); //Writing the words to the output file.
            output.close(); //Closes the output file
        }
        catch(Exception e) 
        {
            System.out.println("Error while writing to file: "+outputFile);
        }

    }

}