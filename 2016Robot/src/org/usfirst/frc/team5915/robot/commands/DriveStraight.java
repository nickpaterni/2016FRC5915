package org.usfirst.frc.team5915.robot.commands;

import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	double angle;
	Timer timer;
	double time;
	int direction;
	
    public DriveStraight(double time, int direction) {
    	this.time = time;
    	this.direction = direction;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//angle = Drivetrain.instance.robotGyro.getAngle();
    	angle = Drivetrain.robotGyro.getAngle();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drivetrain.drive.drive(direction, angle * Drivetrain.kp);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Drivetrain.drive.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
