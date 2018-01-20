package org.usfirst.frc.team5667.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class GyroscopeSPI {
	private ADXRS450_Gyro gyro;
	
	private int angle;
	private boolean active;
	
	public GyroscopeSPI() {
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		angle = 0;
		setActive(false);
	}
	
	public void updateGyro() {
		angle = (int)gyro.getAngle();
	}
	public int getAngle() {
		updateGyro();
		return angle;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public void reset() {
		gyro.reset();
		updateGyro();
	}
	
	public void displayAngle() {
		System.out.println("Angle: " + getAngle());
	}
}
