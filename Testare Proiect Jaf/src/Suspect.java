
public class Suspect {
	
	protected int getIMEI() {
		return IMEI;
	}
	
	protected void setIMEI(int iMEI) {
		IMEI = iMEI;
	}
	
	protected int getTimestamp() {
		return timestamp;
	}
	
	protected void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	protected double getxCoordonate() {
		return xCoordonate;
	}
	
	protected void setxCoordonate(double xCoordonate) {
		this.xCoordonate = xCoordonate;
	}
	
	protected double getyCoordonate() {
		return yCoordonate;
	}
	
	protected void setyCoordonate(double yCoordonate) {
		this.yCoordonate = yCoordonate;
	}
	
	int IMEI;
	int timestamp;
	double xCoordonate;
	double yCoordonate;
	
	
}
