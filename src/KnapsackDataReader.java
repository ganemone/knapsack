import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;
/**
 * This class contains the methods for reading in the data in the file containing knapsack information
 * 
 * @author Giancarlo Anemone and Caitlin Braun
 * @version 3/12/13
 */

public class KnapsackDataReader 
{
	public String filename;
	/**
	 * Constructor for KnapsackDataReader sets the filename passed to the instance of filename in the class
	 * @param filename, the file containing the knapsack information
	 */
	public KnapsackDataReader(String filename)
	{
		this.filename=filename;
	}
	//Create scanner object to read in the data from file
	private Scanner s;
	/**
	 * readPoints method reads in the information in the data file.  It sets the first number to the number of items, the next number
	 * to the maximum weight, and then creates an arraylist of items for the numbers in the rest of the data file.  If the file cannot
	 * be the user is notified that the file cannot be opened
	 * @param filename, the name of the file containing the knapsack data
	 * @return, Knapsack that has all of the information contained in the file in the form of a knapsack
	 */
	public Knapsack readPoints(String filename)
	{
		//Makes sure the file can be opened
		try
		{
			this.s = new Scanner(new BufferedReader(new FileReader(filename)));
		}
		catch (IOException e)
		{
			System.err.println("Cannot open file");
		}
		int numItems=0;
		//sets num items to the first int in the file
		if(s.hasNext())
		{
			numItems=s.nextInt();
		}
		int totalWeight=0;
		//sets total weight to the next int in the file
		if(s.hasNext())
		{
			totalWeight=s.nextInt();
		}
		//creates a knapsack object
		Knapsack knapsack=new Knapsack(totalWeight);
		for(int j=0; j<numItems; j++)
		{
			// adds all the items to the knapsack list of items
			knapsack.items.add(new Item(s.nextInt(), s.nextInt(),s.nextInt()));
		}
		// Sorts the items by the ratio of their profit to weight
		Collections.sort(knapsack.items);
		// adds the object representing the "top" of the tree
		knapsack.items.add(0,new Item(0,0,0));
		return knapsack;
	}
	
}
