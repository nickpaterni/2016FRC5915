package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.RobotMap;
import org.usfirst.frc.team5915.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    private static Talon frontRightMotor = new Talon(RobotMap.driveRightFrontMotor);
    private static Talon rearRightMotor = new Talon(RobotMap.driveRightRearMotor);
    private static Talon frontLeftMotor = new Talon(RobotMap.driveLeftFrontMotor);
    private static Talon rearLeftMotor = new Talon(RobotMap.driveLeftRearMotor);
    
    public static Gyro robotGyro = new AnalogGyro(RobotMap.gyroAnalogPort);
    public static double kp = .03;
    
    public static RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
    public static Drivetrain instance = new Drivetrain();
    
    public Drivetrain() {
    	robotGyro.reset();
    	drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    	drive.setSafetyEnabled(false);
    }
    
    public void Drive(Joystick stick)
    {
    	drive.setInvertedMotor(MotorType.kFrontRight, true);
    	drive.setInvertedMotor(MotorType.kFrontLeft, true);
    	drive.setInvertedMotor(MotorType.kRearLeft, true);
    	drive.setInvertedMotor(MotorType.kRearRight, true);
    	
    	if (stick.getRawButton(Robot.oi.L_BUMPER))
    	{
    		double move = stick.getRawAxis(Robot.oi.LEFT_AXIS_Y);
    		double rotate = stick.getRawAxis(Robot.oi.LEFT_AXIS_X);
        	drive.arcadeDrive(move * .5, rotate * .5);
    	}
    	else
    	{
        	drive.arcadeDrive(stick, true);
    	}
    }
    
    public void DriveStraight()
    {
    	double angle = robotGyro.getAngle();
    	drive.drive(1, angle * kp);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickDrive(this));
    }
}

