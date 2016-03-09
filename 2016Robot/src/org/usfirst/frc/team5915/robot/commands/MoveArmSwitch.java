package org.usfirst.frc.team5915.robot.commands;

import org.usfirst.frc.team5915.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveArmSwitch extends Command {
	int direction;
	Timer timer;

    public MoveArmSwitch() {
    	requires(Robot.manipulatorArm);
    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.manipulatorArm.MoveArm(-.9);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.manipulatorArm.isArmDown() || timer.get() > 1.5);
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
