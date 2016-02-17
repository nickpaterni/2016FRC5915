package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.RobotMap;
import org.usfirst.frc.team5915.robot.commands.ArmIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
    public static Talon intakeMotor = new Talon(RobotMap.armIntake);
    
    public void MoveIntake(Joystick stick)
    {
    	//trigger value is RightTrigger (0-1) - LeftTrigger (0-1)
    	double trigger = stick.getRawAxis(Robot.oi.TRIGGER_AXIS);
    	intakeMotor.set(trigger);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmIntake());
    }
}

