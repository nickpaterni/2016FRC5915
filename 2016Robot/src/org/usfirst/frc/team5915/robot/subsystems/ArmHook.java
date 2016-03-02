package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.OI;
import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5915.robot.commands.MoveArmHookJoystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class ArmHook extends Subsystem {
    
    public static CANTalon hookMotor;
    
    private static ArmHook instance;
    
    public static ArmHook GetInstance()
    {
    	if (instance == null)
    		instance = new ArmHook();
    	return instance;
    }
    
    private ArmHook()
    {
    	hookMotor = new CANTalon(RobotMap.armHookDeviceID);
    }
    
    public void MoveArmHookJoystick()
    {
    	Joystick stick = OI.GetInstance().GetStick();
		double velocity = (stick.getRawAxis(Robot.oi.RIGHT_AXIS_Y));
		hookMotor.set(velocity);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new MoveArmHookJoystick());
    }
}

