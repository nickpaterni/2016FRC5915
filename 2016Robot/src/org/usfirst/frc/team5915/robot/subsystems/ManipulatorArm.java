package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ManipulatorArm extends Subsystem {
    
	public static Talon armUpDownMotor;
	public static DigitalInput limitSwitch;
	
	private static ManipulatorArm instance;
	
	public static ManipulatorArm GetInstance()
	{
		if (instance == null)
			instance = new ManipulatorArm();
		return instance;
	}
	
	private ManipulatorArm()
	{
		armUpDownMotor = new Talon(RobotMap.armUpDown);
		limitSwitch = new DigitalInput(RobotMap.armLimitSwitch);
	}
	
	public void MoveArm (double direction)
	{
		armUpDownMotor.set(direction);
	}

	public boolean isArmDown()
	{
		return limitSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

