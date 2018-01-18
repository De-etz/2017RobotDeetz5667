package org.usfirst.frc.team5667.robot;

import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends Joystick {
	Robot robot; //Robot
	
	//Controller values
	private double inputRSX, inputRSY; //Right joystick axis values
	private double inputLSX, inputLSY; //Left joystick axis values
	private double inputRT, inputLT; //Trigger values
	private boolean inputRB, inputLB; //Bumper states
	private boolean inputA, inputB, inputX, inputY, inputMenu, inputStart; //Button states
	private final double kGHOST = .2; //Threshold for blocking ghost signals
	
	/**
	 * Initializes an Xbox controller.
	 * @param port Just make it zero
	 * @param robot Access to all of the robot's other subsystems
	 */
	public XboxController(int port, Robot robot){
		super(port);
		//Initial states
		inputRSX = 0;
		inputLSY = 0;
		inputLSX = 0;
		inputRT = 0;
		inputLT = 0;
		inputRB = false;
		inputLB = false;
		inputA = false;
		inputB = false;
		inputX = false;
		inputY = false;
		inputMenu = false;
		inputStart = false;
		
		this.robot = robot; //Robot
	}
	
	/**
	 * Reads all the button and joystick values from the controller.
	 */
	private void updateController() {
		inputRSX = super.getRawAxis(4);
		inputRSY = -super.getRawAxis(5);
		inputLSX = super.getRawAxis(0);
		inputLSY = -super.getRawAxis(1);
		inputRT = super.getRawAxis(3);
		inputLT = super.getRawAxis(2);
		inputRB = super.getRawButton(6);
		inputLB = super.getRawButton(5);
		inputA = super.getRawButton(1);
		inputB = super.getRawButton(2);
		inputX = super.getRawButton(3);
		inputY = super.getRawButton(4);
		inputMenu = super.getRawButton(8);
		inputStart = super.getRawButton(7);
	}
	
	/**
	 * Executes robot commands based off the values of the controller.
	 */
	public void enableController() {
		//Check the values of the controller
		updateController(); // Hey Deetz I'm typing this on an Xbox Controller! 
		
		//Check buttons
		if (inputA) {
			
		} else if (inputB) {

		} else if (inputX) {

		} else if (inputY) {

		} else if (inputMenu) {

		} else if (inputStart) {

		} else {
			
		}
		
		//Check joysticks
		if (inputLSY!=0){
			robot.drive.forback(inputLSY);
		} else if (inputRSX!=0){
			robot.drive.rotate(inputRSX);
		} else 
			robot.drive.stop();
		
		
//		if (inputLSY > gDigit && inputRSX > gDigit) {
//			driveTrain.forwardRightTurn(inputLSY, inputRSX);
//		} else if (inputLSY > gDigit && inputRSX < -gDigit) {
//			driveTrain.forwardLeftTurn(inputLSY, inputRSX);
//		} else if (inputLSY < -gDigit && inputRSX > gDigit) {
//			driveTrain.backwardRightTurn(inputLSY, inputRSX);
//		} else if (inputLSY < -gDigit && inputRSX < -gDigit) {
//			driveTrain.backwardLeftTurn(inputLSY, inputRSX);
//		} else if (inputLSY > gDigit) {
//			driveTrain.forward(inputLSY);
//		} else if (inputLSY < -gDigit) {
//			driveTrain.backward(-inputLSY);
//		} else if (inputRSX > gDigit) {
//			driveTrain.clockwise(inputRSX);
//		} else if (inputRSX < -gDigit) {
//			driveTrain.counterClockwise(-inputRSX);
//		} else if (inputRT > gDigit) {
//			driveTrain.strafeRight(.7);
//		} else if (inputLT > gDigit) {
//			driveTrain.strafeLeft(.7);
//		} else if (inputRB) {
//			driveTrain.strafeRight(.35);
//		} else if (inputLB) {
//			driveTrain.strafeLeft(.35);
//		} else {
//			driveTrain.stop();
//		}
	}
}
