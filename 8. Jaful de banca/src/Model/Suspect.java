package Model;

public class Suspect {
	
	int IMEI;
	int timestamp;
	double xCoordonate;
	double yCoordonate;
	
	public int getIMEI() {
		return IMEI;
	}
	
	public Suspect(int imei, int time, double x, double y){
		this.IMEI = imei;
		this.timestamp = time;
		this.xCoordonate = x;
		this.yCoordonate = y;
	}
	
	public void setIMEI(int iMEI) {
		IMEI = iMEI;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	public double getxCoordonate() {
		return xCoordonate;
	}
	
	public void setxCoordonate(double xCoordonate) {
		this.xCoordonate = xCoordonate;
	}
	
	public double getyCoordonate() {
		return yCoordonate;
	}
	
	public void setyCoordonate(double yCoordonate) {
		this.yCoordonate = yCoordonate;
	}
	
	
	
	
}
