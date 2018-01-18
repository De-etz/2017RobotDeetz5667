package org.usfirst.frc.team5667.robot;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Talon;

public class Drivetrain {
	//Declare subsystems
	private PWMTalonSRX l1;
	private PWMTalonSRX l2;
	private PWMTalonSRX r1;
	private PWMTalonSRX r2;
	
	/**
	 * Initializes a drivetrain
	 */
	public Drivetrain() {
		// initializes subsystems
		l1 = new PWMTalonSRX(0);
		l2 = new PWMTalonSRX(1);
		r1 = new PWMTalonSRX(2);
		r2 = new PWMTalonSRX(3);
	}
	/**
	 * Stops the drivetrain
	 */
	public void stop(){
		l1.set(0);
		l2.set(0);
		r1.set(0);
		r2.set(0);
		
	}
	public void forback(double speed){
		l1.set(speed);
		l2.set(speed);
		r1.set(speed);
		r2.set(speed);
		
	}
	public void rotate(double speed){
		l1.set(speed);
		l2.set(speed);
		r1.set(-speed);
		r2.set(-speed);
	
	}

}


