/**
 * This class contains the implementation for the object of type item.  The item contains the information
 * about each item in a Knapsack (the number, profit, and weight of that item)
 * 
 * @author Giancarlo Anemone and Caitlin Braun
 * @version 3/12/13
 */
public class Item implements Comparable<Item>
{

	public int number;
	public int profit;
	public int weight;
	/**
	 * Constructor for an Item
	 * @param number defining the item number in the knapsack
	 * @param profit defining the profit of the item in the knapsack
	 * @param weight defining the weight of the item in the knapsack
	 */
	public Item(int number, int profit, int weight)
	{
		this.number=number;
		this.profit=profit;
		this.weight=weight;
	}
	@Override
	/**
	 * Implemented method from interface comparable.  Allows for a list of items
	 * to be sorted by the ratio of their profit to their weight.
	 * @param Item i defining the item to be compared to.
	 * @return int	1 if (this) is > item i
	 * 			   -1 if (this) is < item i
	 * 				0 if (this) is = item i
	 */
	public int compareTo(Item i) {
		float ratio = (float)this.profit/this.weight;
		float secondRatio = (float)i.profit/i.weight;
		if(ratio > secondRatio) {
			return -1;
		}
		else if(ratio < secondRatio) {
			return 1;
		}
		return 0;

	}
	public String toString()
	{
		return "Item: " + this.number + " Profit: " + this.profit + " Weight: " + this.weight;
	}

}
