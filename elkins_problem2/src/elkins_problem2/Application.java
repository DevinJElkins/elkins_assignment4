package elkins_problem2;

import java.io.IOException;
public class Application {

	public static void main(String[] args) throws IOException
	{
		DuplicateCounter dp=new DuplicateCounter();
		dp.count1("problem2.txt");
		dp.write("unique_word_counts.txt");
	}

}