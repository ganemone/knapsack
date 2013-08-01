import java.util.ArrayList;
/**
 * This class contains the implementation for the object of type node.  The node contains the information
 * about each item in a Knapsack when implemented in a tree (the level of the node, the bound, profit, and weight at that node, as well as
 * an arrayList containing the items used in calculating the profit and weight for the given node)
 * 
 * @author Giancarlo Anemone and Caitlin Braun
 * @version 3/12/13
 */
public class Node implements Comparable<Node> {

	//Instance variables
	public int level;
	public ArrayList<Item> items;
	public float bound;
	public int profit;
	public int weight;
	/**
	 * Node constructor creates a node object containing the level, weight, profit, 
	 * and an ArrayList containing items that would be contained in knapsack at that node
	 * @param level, an integer determining the level of the node in the tree
	 * @param weight, an integer determining the weight of the items in the arrayList of items
	 * @param profit, an integer determining the profit of the items in the arrayList of items 
	 * @param items, the list of items that would be contained in a knapsack at that node
	 */
	public Node(int level, int weight, int profit, ArrayList<Item> items)
	{	
		this.profit = profit;
		this.weight = weight;
		this.level=level;
		this.items = items;
	}
	/**
	 * Node constructor creates a node object containing the level, weight, profit, an ArrayList containing
	 * items that would be contained in knapsack at that node, and the bound at the current node.
	 * @param level, an integer determining the level of the node in the tree
	 * @param weight, an integer determining the weight of the items in the arrayList of items
	 * @param profit, an integer determining the profit of the items in the arrayList of items 
	 * @param Bound, an integer determining the best case profit at the current node
	 */
	public Node(int level,int weight, int profit, ArrayList<Item> items, float Bound) {
		this(level,weight, profit,items);
		this.bound = Bound;
	}
	@Override
	/**
	 * CompareTo method compares a node to other nodes based on the value of each nodes bound.
	 * @param Node, the node that is being compared
	 * @return int that is -1 when the bound of the node is less than the bound it is being compared to,
	 * 1 when the bound is greater than the bound it is being compared to, and 0 when the bounds are equal
	 */
	public int compareTo(Node n) {
		if(this.bound > n.bound)
			return 1;
		else if(this.bound < n.bound)
			return -1;
		return 0;
	}
	/**
	 * setBound sets the bound of a particular node to the value of the paramater 
	 * @param b, the value of the bound
	 */
	public void setBound(float b) {
		this.bound = b;
	}
	/**
	 * getCurrentItem returns the item that is at the current node
	 * @return Item, the item at the current node
	 */
	public Item getCurrentItem()
	{
		return this.items.get(this.level);
	}
	/**
	 * toString returns a string that displays the level, profit, weight, and bound of the node
	 * @return String displaying the level, profit, weight and bound of the node
	 */
	public String toString()
	{
		String s = "Level: " + this.level + "Profit: " + this.profit + "Weight: " + this.weight + "Bound: " + this.bound;
		return s;
	}
	/**
	 * getBound calculates the bound, or the best case profit at a particular node. Calculates the bound by taking the profit
	 * of the current node, and adding the profit of all items that will fit in the knapsack with a item number greater than the item 
	 * number of the current node.  
	 * @param s, the knapsack that
	 * @return a float that is the value of the bound
	 */
	public float getBound(Knapsack s) 
	{
		int j;
		int k;
		int totalWeight;
		float result;
		int maxWeight = s.maxWeight;
		ArrayList<Item> itemInKnapsack = s.items;
		if(this.level < 0)
			this.level = 0;
		
		//if(itemInKnapsack.get(this.level).weight>=maxWeight) {
		if(this.weight >= maxWeight) {
			return 0;
		}

		else
		{
			result = this.profit;
			j=this.level+1;
			totalWeight = this.weight;
			//while the counter is less than the size of the knapsack and the total weight and the weight of the item at the counter j is
			//less than that of the max weight allowed in the knapsack, adds the weight at the level of the counter, and incraments the 
			//result by the profit of the item j in the knapsack
			while( j<itemInKnapsack.size() && ((totalWeight + itemInKnapsack.get(j).weight)<=maxWeight))
			{
				totalWeight += itemInKnapsack.get(j).weight;
				result += itemInKnapsack.get(j).profit;
				j++;
			}
			k=j;
			//when the counter is the same as the size of the knapsack, adds the profit to weight ratio of the last item and 
			//returns the result
			if(k<itemInKnapsack.size())
				result+=(maxWeight-totalWeight)*itemInKnapsack.get(k).profit/itemInKnapsack.get(k).weight;
			return result;
		}
	}
}


