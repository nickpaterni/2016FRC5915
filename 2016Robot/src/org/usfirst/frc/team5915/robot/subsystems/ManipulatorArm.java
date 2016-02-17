package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ManipulatorArm extends Subsystem {
    
	public static Talon armUpDownMotorLeft = new Talon(RobotMap.armUpDownLeft);
	public static Talon armUpDownMotorRight = new Talon(RobotMap.armUpDownRight);
	
	public static DigitalInput limitSwitch = new DigitalInput(RobotMap.armLimitSwitch);
	
	public void MoveArm (int direction)
	{
		armUpDownMotorLeft.set(direction);
		armUpDownMotorRight.set(direction);
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

