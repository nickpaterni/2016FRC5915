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
    
    private static Talon rightMotor = new Talon(RobotMap.rightMotor);
    private static Talon leftMotor = new Talon(RobotMap.leftMotor);
    
    public static RobotDrive drive = new RobotDrive(leftMotor, rightMotor);
    
    public Drivetrain() {
    	drive = new RobotDrive(leftMotor, rightMotor);
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

