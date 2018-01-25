package org.usfirst.frc.team5667.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroscopeSPI {
	private ADXRS450_Gyro gyro;
	
	private double angle;
	private double absAngle;
	private boolean active;
	
	public GyroscopeSPI() {
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		angle = 0;
		active = false;
	}
	
	public void start() {
		active = true;
	}
	
	public void updateGyro() {
		angle = gyro.getAngle();
		angle = (int)(angle *10);
		angle = angle /10.0;
		SmartDashboard.putNumber("Gyro value", angle);
	}
	public double getAngle() {
		updateGyro();
		return angle;
	}

	public void reset() {
		gyro.reset();
		updateGyro();
	}
	
	public void displayAngle() {
		System.out.println("Angle: " + getAngle());
	}
}
