package org.usfirst.frc.team5915.robot.subsystems;

import org.usfirst.frc.team5915.robot.OI;
import org.usfirst.frc.team5915.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ManipulatorArm extends Subsystem {
    
	public static Talon armUpDownMotor = new Talon(RobotMap.armUpDown);
	
	public void MoveArm (int direction)
	{
		armUpDownMotor.set(direction);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

