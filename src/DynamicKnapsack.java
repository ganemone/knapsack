import java.util.ArrayList;
/**
 * This class contains the methods for determining the knapsack using a dynamic programming method.
 * 
 * @author Giancarlo Anemone and Caitlin Braun
 * @version 3/12/13
 */
public class DynamicKnapsack 
{
	public Knapsack s;
	/**
	 * Constructor for Dynamic Knapsack. 
	 * @param s, the knapsack that will be determined in the class
	 */
    public DynamicKnapsack(Knapsack s)
    {   
    	this.s = s;
    }
    /**
     * makeKnapSack method creates a Knapsack using the dynamic programming approach
     * It begins by forming an array that will hold all of the best solutions to the sub problems 
     * of the knapsack problem by finding the maximum profit of each item at each weight. The
     * value in the bottom right of the array is the maximum profit that can be attained as it
     * takes into account all of the subproblems to the knapsack.
     * @return a Knapsack containing the optimal solution 
     */
    public Knapsack makeKnapSack()
    {
    	//creates arraylist of items in the data set
    	ArrayList<Item> items = s.items;
    	s.items = new ArrayList<Item>();
    	//creates array that will contain the optimal solution as well as the solution to the sub problems
    	int[][] array = new int[items.size()][s.maxWeight+1];
    	//creates an array containing the items that are in the optimal solution
    	int[][] itemsToKeep = new int[items.size()][s.maxWeight+1];
    	
    	//sets all items of item number 0 to 0 for all weights up to the max weight
    	array[0][0] = 0;
    	for(int a = 0; a < s.maxWeight; a++) {
    		array[0][a] = 0;
    	}
    	//loops through the item numbers
    	for(int i = 1; i < array.length; i++)
    	{
    		//loops through the item weights - finds the optimal solution for the given item and the given weight in the array
    		for(int j = 1; j < array[i].length; j++)
    		{
    			if(items.get(i).weight <= j && items.get(i).profit + array[i-1][j-items.get(i).weight] >= array[i-1][j])
    			{
    				array[i][j] = (items.get(i).profit + array[i-1][j-items.get(i).weight]);
    				itemsToKeep[i][j] = 1;
    			}
    			else {
    				array[i][j] = array[i-1][j];
    				itemsToKeep[i][j] = 0;
    			}
    		}
    	}
    	int weight = s.maxWeight;
    	int counter = 0;
    	//Determines which items were kept in the optimal solution of the knapsack problem
    	for(int i = items.size()-1; i >= 0 ; i--) {
    		if(itemsToKeep[i][weight] == 1) 
    		{
    			s.items.add(items.get(i));
    			weight-=items.get(i).weight;
    			counter += items.get(i).weight;
    		}
    	}
    	//sets the total profit to the item in the bottom right corner of the array which is the optimal solution ot the problem
    	s.setProfit(array[items.size()-1][s.maxWeight]);
    	//returns the optimal solution in the form of a knapsack  
    	return s;
    }
}
