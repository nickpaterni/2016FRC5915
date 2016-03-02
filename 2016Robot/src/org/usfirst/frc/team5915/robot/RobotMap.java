package org.usfirst.frc.team5915.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//*************Drivetrain*****************//
	public static int driveRightFrontMotor = 0;
	public static int driveRightRearMotor = 1;
	public static int driveLeftFrontMotor = 2;
	public static int driveLeftRearMotor = 3;
	//***************************************//
	
	//*************PDP Ports*****************//
	public static int powerFrontRight = 0;
	public static int powerFrontLeft = 1;
	public static int powerBackRight = 2;
	public static int powerBackLeft = 3;
	
	
	//*************Analog Sensors******************//
	public static int gyroAnalogPort = 1;
	//**************************************//
	
	//*************Digital Sensors************//
	public static int armLimitSwitch = 1;
	//****************************************//
	
	
	//*********Manipulator Arm***************//
	public static int armUpDownLeft = 5;
	public static int armUpDownRight = 6;
	public static int armIntake = 7;
	//***************************************//
	
	//**********Talon SRX Device IDs*********//
	public static int armHookDeviceID = 0;
	//***************************************//

}
