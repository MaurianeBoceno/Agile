package main;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Reader 
{
	public HashMap<String, Person> people = new HashMap<String, Person>();
	private Scanner scan;
	
	public Reader()
	{
	}
	
	public void readTextFile(String url) throws Exception
	{
		scan = new Scanner(new File(url));
		String separator = " "; //separer par un espace
		String temp;
		while (scan.hasNextLine())
		{ 	
			temp = scan.nextLine();
			String[] lineSplits = temp.split(separator); //separer les termes par un espace;
			if(lineSplits.length==5)
			{
				people.put(lineSplits[0],new Person(lineSplits[0],temp, lineSplits[1].charAt(0), Integer.parseInt(lineSplits[2]), 0, lineSplits[3], lineSplits[4])); //ajouter a une array list
			}
			else
			{
				 throw new Exception("Invalid member length: "+lineSplits.length);
			}
		}
		scan.close();
	}
	
	public HashMap<String,Person> getPeople()
	{
		return people;
	}
}
