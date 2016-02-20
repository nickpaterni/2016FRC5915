package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ManipulatorArm extends Subsystem {
    
	public static Talon armUpDownMotor = new Talon(RobotMap.armUpDown);
	
	public static DigitalInput limitSwitch = new DigitalInput(RobotMap.armLimitSwitch);
	
	public void MoveArm (double direction)
	{
<<<<<<< HEAD
		armUpDownMotorLeft.set(direction);
		//armUpDownMotorRight.set(direction);
=======
		armUpDownMotor.set(direction);
>>>>>>> parent of bb3dd7b... Fixes for Precisiondrive, 2 motors for lift arm
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

