import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem2 {

	static BufferedReader br;
	static ArrayList<String> laptops = new ArrayList<String>();
	
   public static void main(String[] args) throws Exception {
      
      String  thisLine = null;
      int numbOfLaptops;
      double x,y,r;
    
      try{
    	  
    	 //Read file 
    	 //File file = new File("C:\\Users\\Oguz's pc\\Desktop\\problem2_test_cases\\test4.dat");
    	  File file = new File(args[0]);
    	  br = new BufferedReader(new FileReader(file));
    	  
         while ((thisLine = br.readLine()) != null) {
        	 //Ignore comments
        	 if(thisLine.contains("##")){
        		 continue;
        	 }
        	 //Add numbers to arraylist
            laptops.add(thisLine);
         }
         //First element of the arraylist number of laptops
         numbOfLaptops = Integer.parseInt(laptops.get(0));
         
         //Split array and obtain coordinates,radius
         String array;
         Laptops[] l1 = new Laptops[numbOfLaptops];
         
         for(int a=1;a<laptops.size();a++){
        	 
        	 array=laptops.get(a);
        	 String split[] = array.split("\\s+");
        	 x =Double.parseDouble(split[0]);
        	 y =Double.parseDouble(split[1]);
        	 r =Double.parseDouble(split[2]);
        	 l1[a-1] = new Laptops(x,y,r);      	
        	 
         }
         
         //Create vertices
         ArrayList<String> vertices = new ArrayList<String>();

         for(int i=1;i<numbOfLaptops+1;i++){
        	 vertices.add("Vertices"+i);
        	 
         }
         ArrayList<Integer> count=new ArrayList<Integer>();
         //Create edges according to conditions
         List<WeightedEdge> edges = new ArrayList<WeightedEdge>();
         for(int i=0;i<numbOfLaptops-1;i++){
             for(int j=1;j<numbOfLaptops;j++){
            	 
            	 if(i>j){
            		 continue;
            	 }	
            	 
   				if(l1[i].getR()+l1[j].getR()>=Math.sqrt(Math.abs(Math.pow(l1[i].getXCoor()-l1[j].getXCoor(),2)+Math.pow(l1[i].getYCoor()-l1[j].getYCoor(),2)))){					
   					edges.add(new WeightedEdge(i,j,1)); 
   					edges.add(new WeightedEdge(j,i,1));
   					count.add(i);
   				}
   				
   				else if(l1[i].getR()+l1[j].getR()<Math.sqrt(Math.abs(Math.pow(l1[i].getXCoor()-l1[j].getXCoor(),2)+Math.pow(l1[i].getYCoor()-l1[j].getYCoor(),2)))){					 
   					 continue;
   				}

              }           	
         }
         
         //If Vertices1 have edges
         if(count.get(0)==0){
         //Calculate costs from first laptop to the other laptops
         //and also find paths
         WeightedGraph<String> graph1= 
        		 new WeightedGraph<String>(edges,vertices);

         WeightedGraph<String>.ShortesPathLaptops2 laptop1=
        		 graph1.getShortestPath(graph1.getIndex(vertices.get(0)));
         laptop1.printAllPaths();    	 
        		 
         }
         
         //If Vertices1 have no edge
         else if(count.get(0)!=0){
        	 System.out.println("All shortest path from Vertices1 are :");
        	 for(int u=0;u<count.size();u++)
        		 //System.out.println();
        	 	 System.out.println("A path from Vertices"+(int)(u+1)+" to "+"Vertices 1:\n(Cost=0)"); 
         }
      }catch(Exception e){
         e.printStackTrace();
      }
      
   }
   
   

   
}
