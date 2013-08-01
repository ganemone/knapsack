import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * This class contains the methods for determining the knapsack using a Best First Knapsack method.
 * 
 * @author Giancarlo Anemone and Caitlin Braun
 * @version 3/12/13
 */

public class BestFirstKnapsack {
	PriorityQueue<Node> q;
	Knapsack s;
	public BestFirstKnapsack(Knapsack sack) {
		this.q = new PriorityQueue<Node>();
		this.s = sack;
	}
	/**
	 * makeKnapSack method determines the optimal items in a knapsack using the best first algorithm.  
	 * makeKnapSack stores each node in a priority queue of node objects. While the queue of nodes
	 * is not empty, the current node is removed.  The bound of the node is checked and if it is better than the current best bound.
	 * If it is each child of the current node is looked at.  When the profit of the child is better than the current best profit the
	 * best profit is changed to that of the child.  If the bound of the child is better than the highest bound, then the child is added
	 * to the priority queue
	 * @return the node containing the optimal solution to the knapsack problem
	 */
	public Node makeKnapSack()
	{
		ArrayList<Item> itemInKnapsack = s.items;
		int numItems=itemInKnapsack.size();
		int maxWeight = s.maxWeight;
		int maxProfit = 0;
		//creates root node
		Node v= new Node(0,0,0,new ArrayList<Item>());
		Node u;
    	//initilizes the max profit, bound, and maxprofit node according to values of node v
		v.setBound(v.getBound(this.s));
		Node maxProfitNode = v;
		//adds root to the queue
		q.add(v);
		while(!(q.isEmpty()))
		{
			ArrayList<Item> parentList = new ArrayList<Item>();
			//creates a temp node that refers to the first item in the priority queue and then removes that item
			Node tempNode = q.peek();
			q.remove();
			//checks if the bound is greater than the current maximum profit
			if(tempNode.bound > maxProfit)
			{
				//adds the items of the parent node to the temp node
				parentList.addAll(tempNode.items);
				//creates a new node that is the child of the temp node
				u = new Node(tempNode.level+1,tempNode.weight + itemInKnapsack.get(tempNode.level+1).weight , tempNode.profit + itemInKnapsack.get(tempNode.level+1).profit, parentList);
				//sets the bound
				u.setBound(u.getBound(this.s));  	
				//determines if the childs weight is less than max and profit is greater than current max and adds it to the list of items
				//changes the maxProfit, and sets the child to be the node at which the best profit is determined at
				u.items.add(itemInKnapsack.get(u.level));
				if(u.weight <= maxWeight && u.profit > maxProfit)
				{
					
					maxProfit = u.profit;
					maxProfitNode = u;
				}
				//if the bound at child is better than the max profit and it is not the last item the child is added to the queue
				if(u.bound > maxProfit && u.level < numItems-1)
				{
					q.add(u);
				}
				//the temporary node level is incremented and bound is set to the new bound of the incramented temp node
				tempNode.level++;
				tempNode.setBound(tempNode.getBound(this.s));
				//if the temp node's bound is higher than the max profit and it is not the last item it is added to the queue
				if(tempNode.bound > maxProfit && u.level < numItems-1) {
					q.add(tempNode);
				}
			}
		}
		//the node contianing the maxProfit is returned.  Also contains the optimal solution to the knapsack problem
		return maxProfitNode;
	}
}
