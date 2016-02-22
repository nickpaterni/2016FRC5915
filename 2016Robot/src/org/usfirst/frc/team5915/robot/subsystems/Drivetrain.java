package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.OI;
import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.RobotMap;
import org.usfirst.frc.team5915.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
    protected final VictorSP frontRightMotor;
    protected final VictorSP rearRightMotor;
    protected final VictorSP frontLeftMotor;
    protected final VictorSP rearLeftMotor;
    
    private final PowerDistributionPanel panel;
    
    public Gyro robotGyro = new AnalogGyro(RobotMap.gyroAnalogPort);
    private static double kp = .03;
    
    private static double precisionDriveAmount = .50;
    
    public static RobotDrive drive;
    
    private static Drivetrain instance;
    
    public static Drivetrain GetInstance()
    {
    	if (instance==null)
    		instance = new Drivetrain();
    	return instance;
    }
    
    public Drivetrain() {
    	frontRightMotor = new VictorSP(RobotMap.driveRightFrontMotor);
    	rearRightMotor  = new VictorSP(RobotMap.driveRightRearMotor);
    	frontLeftMotor = new VictorSP(RobotMap.driveLeftFrontMotor);
    	rearLeftMotor = new VictorSP(RobotMap.driveLeftRearMotor);
    	
    	panel = new PowerDistributionPanel();

    	drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    	drive.setInvertedMotor(MotorType.kFrontRight, true);
    	drive.setInvertedMotor(MotorType.kFrontLeft, true);
    	drive.setInvertedMotor(MotorType.kRearLeft, true);
    	drive.setInvertedMotor(MotorType.kRearRight, true);
    	drive.setSafetyEnabled(false);
    }
    
    public void LogPower()
    {
    	SmartDashboard.putNumber("FrontLeft Power: ", panel.getCurrent(RobotMap.powerFrontLeft));
    	SmartDashboard.putNumber("FrontRight Power: ", panel.getCurrent(RobotMap.powerFrontRight));
    	SmartDashboard.putNumber("BackLeft Power: ", panel.getCurrent(RobotMap.powerBackLeft));
    	SmartDashboard.putNumber("BackRight Power: ", panel.getCurrent(RobotMap.powerBackRight));
    	
    }
    
    public void Drive()
    {
    	Joystick stick = OI.GetInstance().GetStick();
    	
//    	drive.setInvertedMotor(MotorType.kFrontRight, true);
//    	drive.setInvertedMotor(MotorType.kFrontLeft, true);
//    	drive.setInvertedMotor(MotorType.kRearLeft, true);
//    	drive.setInvertedMotor(MotorType.kRearRight, true);
    	
    	//set up dead zone
    	
    	if (stick.getRawButton(Robot.oi.L_BUMPER))
    	{
    		double move = stick.getRawAxis(Robot.oi.LEFT_AXIS_Y);
    		double rotate = stick.getRawAxis(Robot.oi.LEFT_AXIS_X);
        	drive.arcadeDrive(move * precisionDriveAmount, rotate * precisionDriveAmount, false);
    	}
    	else
    	{
        	drive.arcadeDrive(stick, true);
    	}
    }
    
    public void StopDrive()
    {    	
    	drive.arcadeDrive(0,0);
    }
    
    public void DriveStraight(double velocity)
    {
    	double angle = robotGyro.getAngle();
    	drive.drive(velocity, angle * kp);
    }

    //public void initDefaultCommand() {
    	//setDefaultCommand(new JoystickDrive(this));
    //}
    @Override
    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickDrive());
    }
}

