import java.util.ArrayList;
import java.util.Queue;
/**
 * The KnapsackApp class contains the main method that computes Knapsack using three different algorithms for a given set of data.
 * 
 * @author Caitlin Braun and Giancarlo Anemone
 * @version 3/12/13
 * 
 */

public class KnapsackApp {

	/**
	 * The main method of Knapsack Class inputs a data file and then runs the best first implementation, breadth first
	 * implementation, and dynamic programming implementation of the knapsack problem
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ValidatedInputReader r=new ValidatedInputReader();
		String str=r.getString("Please enter the file name: ", "data.dat");
		KnapsackDataReader data=new KnapsackDataReader(str);
		// Defines all items and weight of knapsack;
		Knapsack k = data.readPoints(str);
		//Node n = new Node(2,15,80, k.items);
		//System.out.println(n.getBound(k));
		//RandomSetGeneration random = new RandomSetGeneration();
		//Knapsack k = random.generateKnapsack(100, 100, 100);
		//System.out.println(k.items.size());
		//System.out.println(k.maxWeight);
		//Runs Best first Knapsack
		/*
		for(int i = 500; i < 502; i++)
		{
			System.out.println(i);
			Knapsack a = random.generateKnapsack(i+1, 30, 50);
			BestFirstKnapsack best = new BestFirstKnapsack(a);
			BreadthFirstKnapsack breadth = new BreadthFirstKnapsack(a);
			DynamicKnapsack dynamic = new DynamicKnapsack(a);
			int x = best.makeKnapSack().profit;
			int y = breadth.makeKnapSack().profit;
			//int z = dynamic.makeKnapSack().profit;
			if(!(x == y)) //|| !(y == z) || !(z == x))
			{
				System.out.println("FAILED");
				break;
			}
			System.out.println(x + "=" + y);// + "=" + z);
		}
		*/
		
		long startTime;
		long endTime;
		startTime = System.nanoTime();
		BestFirstKnapsack sack = new BestFirstKnapsack(k);
		Node q = sack.makeKnapSack();
		System.out.println("Best First Knapsack");
		int counter = 0;
		int totWeight=0;
		System.out.print("Items in Knapsack: ");
		for(Item i: q.items)
		{
			System.out.print(" " + i.number);
			counter += i.profit;
			totWeight+=i.weight;
		}
		System.out.println("\nTotal Profit: " + counter);
		System.out.println("Total Weight: " + totWeight);

		endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
		
		//Runs the Breadth first Knapsack
		startTime = System.nanoTime();
		totWeight=0;
		BreadthFirstKnapsack sack1 = new BreadthFirstKnapsack(k);
		System.out.println("\nBreadth First Knapsack");
		Node c = sack1.makeKnapSack();
		int counter1 = 0;
		System.out.print("Items in Knapsack: ");
		//for(int i = 0; i<c.items.size(); i++) 
		for(Item i: c.items)
		{
			System.out.print( " " + i.number);
			counter1 += i.profit;
			totWeight+= i.weight;
			
		}
		System.out.println("\nTotal Profit: " + counter1);
		System.out.println("Total Weight: " + totWeight);
		endTime = System.nanoTime();;
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
		//Runs the Dynamic Knapsack
		startTime = System.nanoTime();
		System.out.println("\nDynamic Knapsack");
		totWeight=0;
		DynamicKnapsack sack3 = new DynamicKnapsack(k);

		Knapsack s = sack3.makeKnapSack();
		System.out.print("Items in Knapsack: ");
		for(Item i: s.items) 
		{
			System.out.print(" "+i.number);
			totWeight+=i.weight;
		}
		System.out.println("\nTotal Profit: " + s.profit);
		System.out.println("Total Weight: "+totWeight );
		endTime = System.nanoTime();;
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	
	}

}
