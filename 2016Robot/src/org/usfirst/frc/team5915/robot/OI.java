package org.usfirst.frc.team5915.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team5915.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
	static final int A_BUTTON = 1;
	static final int B_BUTTON = 2;
	static final int X_BUTTON = 3;
	static final int Y_BUTTON = 4;
	static final int L_BUMPER = 5;
	static final int R_BUMPER = 6;
	static final int BACK_BUTTON = 7;
	static final int START_BUTTON = 8;
	static final int LEFT_STICK_BUTTON = 9;
	static final int RIGHT_STICK_BUTTON = 10;
	static final int RIGHT_TRIGGER = 11;
	static final int LEFT_TRIGGER = 12;
	
	static final int LEFT_AXIS_X = 1;
	static final int LEFT_AXIS_Y = 2;
	static final int TRIGGER_AXIS = 3;
	static final int RIGHT_AXIS_X = 4;
	static final int RIGHT_AXIS_Y = 5;
	static final int DPAD_AXIS = 6;
	
    Joystick stick = new Joystick(0);
    
    Button Abutton = new JoystickButton(stick, A_BUTTON);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

