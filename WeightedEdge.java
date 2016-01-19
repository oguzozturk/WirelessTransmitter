
public class WeightedEdge extends AbstractGraph.Edges 
						implements Comparable <WeightedEdge> {
	
	public double weight;
	
	//Created a weighted  edge on(u,v)
	public WeightedEdge(int u,int v,double weight){
		
		super(u,v);
		this.weight=weight;
		
	}
	
	//Compare two edges on weights
	@Override
	public int compareTo(WeightedEdge edge){
		if(weight> edge.weight)
			return 1;
		else if(weight == edge.weight)
			return 0;
		else
			return -1;
	}

}
