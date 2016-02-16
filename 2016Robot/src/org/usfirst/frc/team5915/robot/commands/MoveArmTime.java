package org.usfirst.frc.team5915.robot.commands;

import org.usfirst.frc.team5915.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmTime extends Command {
	Timer timer;
	double time;
	int direction;

    public MoveArmTime(double time, int direction) {
    	requires(Robot.manipulatorArm);
    	this.time = time;
    	this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.manipulatorArm.MoveArm(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return timer.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.manipulatorArm.MoveArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
