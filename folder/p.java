import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class p
{
	public p()
	{


	}


	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new BufferedReader(new FileReader(args[0]))) ;
		String path = in.nextLine() ;
		
		//while(in.hasNextLine())
		//{
			String fileName = path + in.nextLine() ;
			Scanner in2 = new Scanner(new BufferedReader(new FileReader("1999-W02-5.txt"))) ;
			ArrayList<String> lines = new ArrayList<String>() ;
			ArrayList<String> questions = new ArrayList<String>() ;
			
			while(in2.hasNextLine())
			{
				String temp = in2.nextLine() ;
				
				if(temp.length() != 0)
				{
					if(temp.charAt(0) == '<' && temp.charAt(1) == 'Q')
						questions.add(temp) ;
					else
						lines.add(temp) ;
				}
			}
			
			int[] answerIndex = new int[questions.size()] ;
			
			for(int k = 1; k < questions.size(); k++) //for every question
			{	
				answerIndex[k] = 0 ;
				int[] counts = new int[lines.size()] ;
				for(int i = 0; i < lines.size(); i++)
				{
					counts[i] = 0 ;
				}
			
				for(int j = 0; j < lines.size(); j++) //for every line
				{
					String temp = questions.get(k) ;
					String[] words = temp.split("\\s+");
					
					String[] tempLine = lines.get(j).split("\\s+") ;
					
					for(int i = 1; i < words.length; i++) //for every word in a question
					{
						for(int n = 0; n < tempLine.length; n++) //for every word in the line
						{
							if(words[i].compareTo(tempLine[n]) == 0)
								counts[j]++ ;
						}
					}				
				}
				
				int max = 0;
					 
				for(int i = 0; i < counts.length; i++) // for each of the calculated counts
				{
					if(max < (counts[i])) 
						max = i ;
				}
				answerIndex[k] = max ;
				System.out.println("Q" + k + ": " + lines.get(answerIndex[k]) + "\n") ;
				
			}
		
		
		//}
	
	}
}