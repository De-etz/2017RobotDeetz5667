/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5667.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
<<<<<<< HEAD
	//Declare subsystems
	XboxController xbox;
	Drivetrain drive;
	GyroscopeSPI gyro;
//	UltrasonicSensor ultra;
	Autonomous auto;
	char allianceSwitch;
	char scale;
	char opponentSwitch;
			//Game info
	
	
	//Autonomous variables
	private static final String kDefaultAuto = "Default"; //Default auto command
	private static final String kCustomAuto = "My Auto"; //Custom auto command
	private String m_autoSelected; 
	private SendableChooser<String> m_chooser = new SendableChooser<>(); //Options for auto
	private SendableChooser<Integer> position = new SendableChooser<>(); 
=======
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
>>>>>>> parent of d6c9f35... Copied controller class, added comments

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
<<<<<<< HEAD
		//Initialize subsystems
		xbox = new XboxController(0, this);
		drive= new Drivetrain();
		
		gyro = new GyroscopeSPI();
//		ultra = new UltrasonicSensor();
		
		String gameInfo = DriverStation.getInstance().getGameSpecificMessage();
		
		//Add auto commands as options
=======
>>>>>>> parent of d6c9f35... Copied controller class, added comments
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		
		position.addDefault("Far left", 0);
		position.addObject("Left", 1);
		position.addObject("Center", 2);
		position.addObject("Right", 3);
		position.addObject("Far right", 4);
		SmartDashboard.putData("Robot Position", position);
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
<<<<<<< HEAD
		auto = new Autonomous(this, position.getSelected());
		System.out.println("Running position " + position.getSelected());
		
		//Run auto command
=======
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
>>>>>>> parent of d6c9f35... Copied controller class, added comments
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
<<<<<<< HEAD
//		xbox.enableController();
=======
>>>>>>> parent of d6c9f35... Copied controller class, added comments
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
