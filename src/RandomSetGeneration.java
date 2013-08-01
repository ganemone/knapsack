import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class RandomSetGeneration {
	
	public RandomSetGeneration()
	{
	}
	public Knapsack generateKnapsack(int numberOfItems, int weightRange, int profitRange)
	{
		Random generator = new Random();
		ArrayList<Item> items = new ArrayList<Item>();
		for(int i = 1; i <= numberOfItems; i++)
		{
			items.add(new Item(i, generator.nextInt(weightRange)+1, generator.nextInt(profitRange)+1));
		}
		Collections.sort(items);
		items.add(0,new Item(0,0,0));
		return new Knapsack(generator.nextInt(weightRange)+1, items);
		
		
	}

}
