import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph<V> extends AbstractGraph<V> {
	
	private List<PriorityQueue<WeightedEdge>> queues
	= new ArrayList<PriorityQueue<WeightedEdge>>();
	
	//Construct a weighted graph from edges and vertices
	public WeightedGraph(){
		
	}
	
	//Construct a weightedgraph for vertices and edge list
	public WeightedGraph(List<WeightedEdge> edge,List<V> vertices){
		super((List)edge,vertices);
		createQueues(edge,vertices.size());
	}
	
	public WeightedGraph(List<WeightedEdge> edge,int numberOfVertices){
		super((List)edge,numberOfVertices);
		createQueues(edge,numberOfVertices);
	}
	
	//Create priority adjacency list from edge lists
	private void createQueues(List<WeightedEdge> edge,int numberOfVertices){
		
		for(int i=0;i<numberOfVertices;i++){
			queues.add(new PriorityQueue<WeightedEdge>());
		}
		for(WeightedEdge edges:edge){
			queues.get(edges.u).offer(edges);
		}
		
	}
	
	//Display edges with weights
	public void printWeightedEdges(){
		for(int i=0;i<queues.size();i++){
			System.out.println(getVertex(i)+" (" +i+"): ");
			for(WeightedEdge edges : queues.get(i)){
				System.out.println(" ("+edges.u+", "+
						edges.v+", "+edges.weight+") ");	
			}
			System.out.println();
		}
	}
	
	//Get the edges from the weighted graph
	public List<PriorityQueue<WeightedEdge>> getWeightedEdges(){
		return queues;
		
	}

	//Clone an array of queues
	private List<PriorityQueue<WeightedEdge>> deepClone(
			List<PriorityQueue<WeightedEdge>> queues){
		List<PriorityQueue<WeightedEdge>> copiedQueues =
				new ArrayList<PriorityQueue<WeightedEdge>>();
		
		for(int i=0;i<queues.size();i++){
			copiedQueues.add(new PriorityQueue<WeightedEdge>());
			for(WeightedEdge e:queues.get(i)){
				copiedQueues.get(i).add(e);
			}
		}
		return copiedQueues;
	}
	
	//Find single-source shortest path
	public ShortesPathLaptops2 getShortestPath(int sourceVertex){
		List<Integer>T=new ArrayList<Integer>();
		T.add(sourceVertex);
		
		int numberOfVertices=vertices.size();
		int[] parent = new int[numberOfVertices];
		parent[sourceVertex] = -1;
		double[] cost=new double[numberOfVertices];
		for(int i=0;i<cost.length;i++){
			cost[i]=Double.MAX_VALUE;
		}
		cost[sourceVertex] =0;
		
		List<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);
					
		while(T.size()<numberOfVertices){
			int v=-1;
			double smallestCost = Double.MAX_VALUE;
			for(int u:T){
				while(!queues.get(u).isEmpty()&&T.contains(queues.get(u).peek().v)){
					queues.get(u).remove();
				}
				if(queues.get(u).isEmpty()){
					continue;
				}
				WeightedEdge e= queues.get(u).peek();
				if(cost[u]+e.weight<smallestCost){
					v=e.v;
					smallestCost =cost[u]+e.weight;
					parent[v]=u;
				}
			}
			T.add(v);
			cost[v]=smallestCost;
		
		}
		return new ShortesPathLaptops2(sourceVertex,parent,T,cost);
	}
	
	//ShortestPathLaptops2 is inner class in WeightedGraph
	public class ShortesPathLaptops2 extends Laptops2{
		private double[] cost;
		
		public ShortesPathLaptops2(int source,int[] parent,List<Integer> searchOrder,double[] cost){
			super(source,parent,searchOrder);
			this.cost=cost;
		}
		
		public double getCost(int v){
			return cost[v];
		}
		public void printAllPaths(){
			
			System.out.println("All shortest path from "+vertices.get(getRoot())+" are :");
			for(int i=0;i<cost.length;i++){
				printPath(i);
				System.out.println("(cost: "+cost[i]+")");
			}
		}
	}

}

