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
    public DriveStraight(double time) {
    	this.time = time;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	angle = Drivetrain.instance.robotGyro.getAngle();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drivetrain.drive.drive(-1, angle * Drivetrain.kp);
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