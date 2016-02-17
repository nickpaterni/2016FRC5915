package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.RobotMap;
import org.usfirst.frc.team5915.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Drivetrain extends Subsystem {
    private static VictorSP frontRightMotor = new VictorSP(RobotMap.driveRightFrontMotor);
    private static VictorSP rearRightMotor = new VictorSP(RobotMap.driveRightRearMotor);
    private static VictorSP frontLeftMotor = new VictorSP(RobotMap.driveLeftFrontMotor);
    private static VictorSP rearLeftMotor = new VictorSP(RobotMap.driveLeftRearMotor);
    
    public static Gyro robotGyro = new AnalogGyro(RobotMap.gyroAnalogPort);
    public static double kp = .03;
    
    public static double speedReduction = .50;
    
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
        	drive.arcadeDrive(move * speedReduction, rotate * speedReduction, false);
    	}
    	else
    	{
        	drive.arcadeDrive(stick, true);
    	}
    }

    //public void initDefaultCommand() {
    	//setDefaultCommand(new JoystickDrive(this));
    //}
    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickDrive());
    }
}

