package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.OI;
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
    
    private static Intake instance;
    
    public static Intake GetInstance()
    {
    	if(instance==null)
    		instance = new Intake();
    	return instance;
    }
    
    public void MoveIntake()
    {
    	Joystick stick = OI.GetInstance().GetStick();
    	
    	//trigger value is RightTrigger (0 1) - LeftTrigger (0 -1)
    	double trigger = stick.getRawAxis(Robot.oi.R_TRIGGER_AXIS);
    	intakeMotor.set(trigger);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmIntake());
    }
}

