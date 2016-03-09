package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.OI;
import org.usfirst.frc.team5915.robot.Robot;
import org.usfirst.frc.team5915.robot.RobotMap;
import org.usfirst.frc.team5915.robot.commands.MoveArmJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManipulatorArm extends Subsystem {
    
	public static Talon armUpDownMotorLeft;
	public static Talon armUpDownMotorRight;
	public static DigitalInput limitSwitch;
	
	private static double reductionAmount = .50;
	
	private static ManipulatorArm instance;
	
	public static ManipulatorArm GetInstance()
	{
		if (instance == null)
			instance = new ManipulatorArm();
		return instance;
	}
	
	private ManipulatorArm()
	{
		armUpDownMotorLeft = new Talon(RobotMap.armUpDownLeft);
		armUpDownMotorRight = new Talon(RobotMap.armUpDownRight);
		limitSwitch = new DigitalInput(RobotMap.armLimitSwitch);
	}
	
	public void MoveArm (double direction)
	{
		armUpDownMotorLeft.set(direction * reductionAmount);
		armUpDownMotorRight.set(-direction * reductionAmount);
	}
	
	public void MoveArmJoystick ()
	{
		Joystick stick = OI.GetInstance().GetStick();
		double velocity = (stick.getRawAxis(Robot.oi.R_TRIGGER_AXIS) - stick.getRawAxis(Robot.oi.L_TRIGGER_AXIS));
		
		SmartDashboard.putBoolean("IsArmDOwn ", isArmDown());
		
		if (isArmDown() && velocity < 0)
		{
			//trying to push past the limit switch
			velocity = 0;
		}
		
		armUpDownMotorLeft.set(velocity * reductionAmount);
		armUpDownMotorRight.set(-velocity * reductionAmount);
	}

	public boolean isArmDown()
	{
		return !limitSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveArmJoystick());
    }
}

