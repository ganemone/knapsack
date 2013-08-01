import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * This class contains the methods for determining the knapsack using a Bredth First Knapsack method.
 * 
 * @author Giancarlo Anemone and Caitlin Braun
 * @version 3/12/13
 */
public class BreadthFirstKnapsack {

	int maxProfit;
	Knapsack s;
	/**
	 * Constructor for Breadth First Knapsack. 
	 * @param s, the knapsack that will be determined in the class
	 */
	public BreadthFirstKnapsack(Knapsack s)
    {   
    	this.s = s;
    }
	/**
	 * makeKnapSack method determines the optimal items in a knapsack using the breadth first algorithm.  
	 * makeKnapSack stores each node in a queue that is a linked list of Node objects. While the queue of nodes
	 * is not empty, the children of the node is looked at.  If the profit at the child is better than the current best
	 * profit, the best profit becomes the profit of the child.  If the bound at the child is better than the current best bound,
	 * the child is placed on the queue.
	 * @return the node containing the optimal solution to the knapsack problem
	 */
    public Node makeKnapSack()
    {
    	ArrayList<Item> itemInKnapsack = s.items;
    	maxProfit = 0;
    	int numItems=itemInKnapsack.size();
    	int maxWeight = s.maxWeight;
    	//creates queue using linked list
    	Queue<Node> q = new LinkedList();
    	//creates root node
    	Node v= new Node(0,0,0,new ArrayList<Item>());
    	Node u;
    	//initilizes the max profit, bound, and maxprofit node according to values of node v
    	
    	v.setBound(v.getBound(this.s));
    	Node maxProfitNode = v;
    	//adds top node to queue
    	q.offer(v);
    	//loops until the queue is empty
    	while(!(q.isEmpty()))
    	{
    		//System.out.println("Breadth First");
    		//creates a list of items that are the items contained in the parent node
    		ArrayList<Item> parentList = new ArrayList<Item>();
    		
    		//temporary node that is the node contained in the queue
    		Node tempNode = q.remove();

    		parentList.addAll(tempNode.items);
    	
    		//sets up child node
    		u = new Node(tempNode.level+1,tempNode.weight + itemInKnapsack.get(tempNode.level+1).weight , tempNode.profit + itemInKnapsack.get(tempNode.level+1).profit, new ArrayList<Item>());
    		u.items.addAll(parentList);
 
    		u.setBound(u.getBound(this.s)); 
    		u.items.add(itemInKnapsack.get(u.level));
    		//sets the values of the child node 
    		if(u.weight <= maxWeight && u.profit >= maxProfit)
    		{
    			maxProfit = u.profit;
    			maxProfitNode = new Node(u.level, u.weight, u.profit, u.items);
    		}
    		//adds child to queue if the bound of child is better than the maxprofit and the level is less than the total number of items
    		if(u.bound >= maxProfit && u.level < numItems-1)
    		{
    			q.offer(u);
    		}
    		//tempNode.level++;
    		Node child = new Node(tempNode.level +1,tempNode.weight, tempNode.profit,new ArrayList<Item>());
    		child.items.addAll(parentList);
    		//sets the bound of u's child
    		//tempNode.setBound(tempNode.getBound(this.s));
    		//adds u's child to the queue if it's bound is better than maxprofit and level is less than total number of items
    		
    		if(child.getBound(this.s) > maxProfit && child.level < numItems-1) 
    			q.offer(child);
    	}
    	//returns the maxProfitNode containing the optimal set of items in the knapsack
    	return maxProfitNode;
    }
}
