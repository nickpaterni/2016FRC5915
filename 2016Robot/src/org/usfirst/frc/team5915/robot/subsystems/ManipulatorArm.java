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
	
	public void MoveArmJoystick(Joystick js) {
			
		double movement = js.getRawAxis(OI.RIGHT_AXIS_Y);
		
		//create a small deadzone so that the motor will turn off
		if (movement <= -.90 || movement >=.90)
			movement = 0;
		
		armUpDownMotor.set(movement);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

