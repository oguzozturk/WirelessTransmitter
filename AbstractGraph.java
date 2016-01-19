import java.util.*;

public abstract class AbstractGraph<V> implements Graph<V> {
	
	protected List<V> vertices = new ArrayList<V>();
	protected List<List<Integer>> neighbors
	= new ArrayList<List<Integer>>();
	
	//Construct empty graph
	protected AbstractGraph(){
		
	}
	
	//Construct graph from edges and vertices stored in list
	protected AbstractGraph(List<Edges> edges,List<V> vertices){
		
		for(int i=0;i<vertices.size();i++)
			this.vertices.add(vertices.get(i));
		
		createAdjacencyLists(edges,vertices.size());		
	}
	
	protected AbstractGraph(List<Edges> edges,int numberOfVertices){
		for(int i=0;i<numberOfVertices;i++)
			vertices.add((V)(new Integer(i)));
		createAdjacencyLists(edges,numberOfVertices);
		
	}
	
	//Create adjacency List each vertex
	private void createAdjacencyLists(List<Edges> edges,int numberOfVertices){
		
		for(int i=0;i<numberOfVertices;i++){
			neighbors.add(new ArrayList<Integer>());
		}
		for(Edges edge:edges){
			neighbors.get(edge.u).add(edge.v);
		}
		
	}
	
	@Override
	public int getSize(){
		return vertices.size();
	}
	@Override
	public List<V> getVertices(){
		return vertices;
	}
	@Override
	public V getVertex(int index){
		return vertices.get(index);
	}
	@Override
	public int getIndex(V v){
		return vertices.indexOf(v);
	}
	@Override
	public List<Integer> getNeighbors(int index){
		return neighbors.get(index);
	}

	//Print edges
	@Override
	public void printEdges(){
		int count = 0;
		for(int u=0;u<neighbors.size();u++){
			System.out.println(getVertex(u)+" (" +u+"): ");

			for(int j=0;j<neighbors.get(u).size();j++){
				System.out.println(" ("+u+", "+
			neighbors.get(u).get(j)+") ");
				count++;
			}
			System.out.println();
		}
	}

	//Inner class inside the abstractgraph class
	public static class Edges {
	
		int u;
		int v;
	
		public Edges(int u,int v){
			this.u=u;
			this.v=v;		
		}
	}
	
	//Laptops2 inner class inside the abstractgraph class
	public class Laptops2 {
		private int root;
		private int[] parent;
		private List<Integer> searchOrder;
	
		//Construct a laptop with root ,parent and searchorder 
		public Laptops2(int root,int[] parent,List<Integer> searchOrder){
			this.root=root;
			this.parent=parent;
			this.searchOrder=searchOrder;
		}
	
		//Return the root of laptop
		public int getRoot(){
			return root;
		}
		//Return the parent of vertex v
		public int getParent(int v){
			return parent[v];
		}
		//Return an array representing searchorder
		public List<Integer> getSearchOrder(){
			return searchOrder;
		}
		//Return number of vertices found
		public int getNumberOfVerticesFound(){
			return searchOrder.size();
		}
		//Return the path of vertices from a vertex to the root 
		public List<V> getPath(int index){
			ArrayList<V> path = new ArrayList<V>();
		
			do{
				path.add(vertices.get(index));
				index=parent[index];
			}
			while(index!= -1);
			return path;
		}
		//Print a path from the root to vertex v
		public void printPath(int index){
		List<V> path=getPath(index);

		System.out.println("A path from "+vertices.get(root)+" to "+vertices.get(index)+": ");
		for(int i=path.size()-1;i>=0;i--)
			System.out.print(path.get(i)+" ");

		}
		
		//Print the all laptops
		public void printLaptops(){
		System.out.println("Root is: "+vertices.get(root));
		System.out.println("Edges: ");
		for(int i=0;i<parent.length;i++){
			if(parent[i] != -1){
				System.out.print("("+vertices.get(parent[i])+", "+
			vertices.get(i)+") ");
			}
		}
		System.out.println();
		}
	

}


}
