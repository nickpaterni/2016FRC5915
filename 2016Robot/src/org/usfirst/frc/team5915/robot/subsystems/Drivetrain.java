package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.RobotMap;
import org.usfirst.frc.team5915.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    private static Talon frontRightMotor = new Talon(RobotMap.driveRightFrontMotor);
    private static Talon rearRightMotor = new Talon(RobotMap.driveRightRearMotor);
    private static Talon frontLeftMotor = new Talon(RobotMap.driveLeftFrontMotor);
    private static Talon rearLeftMotor = new Talon(RobotMap.driveLeftRearMotor);
    
    public static RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    
    public Drivetrain() {
    	drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
    	drive.setSafetyEnabled(false);
    }
    
    public void Drive()
    {
    	//double forwardBack = Robot.oi.stick.getRawAxis(1);
    	//double rotation = Robot.oi.stick.getRawAxis(0);
    	//drive.arcadeDrive(forwardBack, rotation);
    	drive.arcadeDrive(Robot.oi.stick, true);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
}

