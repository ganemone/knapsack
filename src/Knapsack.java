import java.util.ArrayList;

/**
 * This class contains the implementation for the object of type Knapsack.  The knapsack contains max weight
 * an array list of items in the knapsack, the profit of the knapsack items, and the weight of the knapsack items.
 * 
 * @author Giancarlo Anemone and Caitlin Braun
 * @version 3/12/13
 */
public class Knapsack 
{

	public int maxWeight;
	public int weight;
	public ArrayList<Item> items;
	public int profit;
	/**
	 * Constructor of Knapsack creates a knapsack
	 * @param maxWeight, the maximum weight that can be placed in the knapsack
	 */
	public Knapsack(int maxWeight)
	{
		this.maxWeight = maxWeight;
		this.items=new ArrayList<Item>();
		this.profit = 0;
	}
	public Knapsack(int maxWeight, ArrayList<Item> i)
	{
		this.maxWeight = maxWeight;
		this.items = i;
		this.profit = 0;
	}
	/**
	 * setProfit sets the profit of the knapsack
	 * @param profit, an int determining the profit.
	 */
	public void setProfit(int profit) {
		this.profit = profit;
	}
	/**
	 * setProfit sets the weight of the knapsack
	 * @param profit, an int determining the weight.
	 */
	public void setWeight(int w) {
		this.weight = w;
	}
	/**
	 * CalculateWrofit determines the total profit of the items in the knapsack and stores
	 * it as the profit of the knapsack.
	 */
	public void calculateProfit() {
		int counter = 0;
		for(Item i: items)
			counter+=i.profit;
		this.profit = counter;
	}
	/**
	 * CalculateWeight determines the total weight of the items in the knapsack and stores
	 * it as the weight of the knapsack.
	 */
	public void calculateWeight() {
		int counter = 0;
		for(Item i: items) 
			counter+=i.weight;
		this.weight = counter;
	}
	

}
