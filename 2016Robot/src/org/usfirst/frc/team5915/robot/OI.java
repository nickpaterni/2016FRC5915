package org.usfirst.frc.team5915.robot;

import org.usfirst.frc.team5915.robot.commands.MoveArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final int A_BUTTON = 1;
	public final int B_BUTTON = 2;
	public final int X_BUTTON = 3;
	public final int Y_BUTTON = 4;
	public final int L_BUMPER = 5;
	public final int R_BUMPER = 6;
	public final int BACK_BUTTON = 7;
	public final int START_BUTTON = 8;
	public final int LEFT_STICK_BUTTON = 9;
	public final int RIGHT_STICK_BUTTON = 10;
	public final int RIGHT_TRIGGER = 11;
	public final int LEFT_TRIGGER = 12;
	
	public final int LEFT_AXIS_X = 1;
	public final int LEFT_AXIS_Y = 2;
	public final int TRIGGER_AXIS = 3;
	public final int RIGHT_AXIS_X = 4;
	public final int RIGHT_AXIS_Y = 5;
	public final int DPAD_AXIS = 6;
	
    public Joystick stick = new Joystick(0);
    
    public OI()
    {
	    Button aButton = new JoystickButton(stick, A_BUTTON);
	    aButton.whileHeld(new MoveArm(1));;
	    aButton.whenReleased(new MoveArm(0));
	    
	    Button yButton = new JoystickButton(stick, Y_BUTTON);
	    yButton.whileHeld(new MoveArm(-1));
	    yButton.whenReleased(new MoveArm(0));
    
    }
}

