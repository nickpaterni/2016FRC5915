package org.usfirst.frc.team5915.robot.commands;

import org.usfirst.frc.team5915.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	double angle;
	Timer driveTimer;
	double driveTime;
	double moveDirection;
	
    public DriveStraight(double time, double direction) {
    	driveTime = time;
    	moveDirection = direction;

    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTimer = new Timer();
    	driveTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.DriveStraight(moveDirection);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return driveTimer.get() > driveTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.StopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
