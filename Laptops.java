
public class Laptops {
	private double xCoor;
	private double yCoor;
	private double r;
	
	//Created coordinates and radius
	public Laptops(double xCoor,double yCoor,double r){
		
		this.xCoor=xCoor;
		this.yCoor=yCoor;
		this.r=r;
		
	}
	
	//Return x coordinate
	public double getXCoor(){
		return xCoor;
	}
	//Return y coordinate
	public double getYCoor(){
		return yCoor;
	}
	//Return radius
	public double getR(){
		return r;
	}

}
