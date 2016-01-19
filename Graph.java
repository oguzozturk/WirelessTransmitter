
public interface Graph<V> {
	
	//Return the number of vertices in the graph
	public int getSize();
	
	//Return the vertices in the graph
	public java.util.List<V> getVertices();
	
	//Return the object for the specified vertex index
	public V getVertex(int index);
	
	//Return the index for the specified vertex object
	public int getIndex(V v);
	
	//Return the neighbors of vertex with specified index
	public java.util.List<Integer> getNeighbors(int index);
	
	//Print the edges
	public void printEdges();	

}
