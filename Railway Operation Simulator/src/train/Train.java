package train;

import application.Timetable;

public class Train {
	
	private String serviceRef;
	private String description;
	private int startingSpeed;
	private int maxSpeed;
	private int mass;
	private int maxBreakingForce;
	private double maxDeceleration;
	private double normalDeceleration;
	private int power;
	private double normalAcceleration;
	private double maxAcceleration;
	private int maxSignallerSpeed;
	private Timetable timetable;
	
	public Train() {
		// TODO Auto-generated constructor stub
	}

	public String getServiceRef() {
		return serviceRef;
	}

	public void setServiceRef(String serviceRef) {
		this.serviceRef = serviceRef;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStartingSpeed() {
		return startingSpeed;
	}

	public void setStartingSpeed(int startingSpeed) {
		this.startingSpeed = startingSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public int getMaxBreakingForce() {
		return maxBreakingForce;
	}

	public void setMaxBreakingForce(int maxBreakingForce) {
		this.maxBreakingForce = maxBreakingForce;
	}

	public double getMaxDeceleration() {
		return maxDeceleration;
	}

	public void setMaxDeceleration(double maxDeceleration) {
		this.maxDeceleration = maxDeceleration;
	}

	public double getNormalDeceleration() {
		return normalDeceleration;
	}

	public void setNormalDeceleration(double normalDeceleration) {
		this.normalDeceleration = normalDeceleration;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public double getNormalAcceleration() {
		return normalAcceleration;
	}

	public void setNormalAcceleration(double normalAcceleration) {
		this.normalAcceleration = normalAcceleration;
	}

	public double getMaxAcceleration() {
		return maxAcceleration;
	}

	public void setMaxAcceleration(double maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
	}

	public int getMaxSignallerSpeed() {
		return maxSignallerSpeed;
	}

	public void setMaxSignallerSpeed(int maxSignallerSpeed) {
		this.maxSignallerSpeed = maxSignallerSpeed;
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	

}
