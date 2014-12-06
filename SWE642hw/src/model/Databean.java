package model;

public class Databean {
	
private	double mean;
private	double deviation;


	public Databean(double mean2, double stdv) {
	// TODO Auto-generated constructor stub
		super();
		this.mean=mean2;
		this.deviation=stdv;
}
	public Databean() {
		// TODO Auto-generated constructor stub
			this.mean=0;
			this.deviation=0;
	}
	
	

	public double getMean() {
		return mean;
	}
	
	public double getDeviation() {
		return deviation;
	}
	

}
