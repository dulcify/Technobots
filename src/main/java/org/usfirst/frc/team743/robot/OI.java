/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

import java.util.ArrayList;

import org.usfirst.frc.team743.robot.commands.*;

import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
// Initializing the pin buttons (Mapping the controller button)
	public final int X = 3;
	public final int A = 1;
	public final int B = 2;
	public final int Y = 4;

	public final int LB = 5;
	public final int RB = 6;

	// Triggers
	public final int LT = 7;
	public final int RT = 8;
	
	public final int SELECT = 7;
	public final int START = 8;

	public final int stickLeftButton = 9;
	public final int stickRightButton = 10; // not working

	public final int pov = 0;
	
//Construct creating the controller object
	XboxController _xboxController = new XboxController(0);
	
//Construct creating the individual button within the controller object.
	Button buttonA = new JoystickButton(_xboxController, A);
	Button buttonB = new JoystickButton(_xboxController, B);
	Button buttonX = new JoystickButton(_xboxController, X);
	Button buttonY = new JoystickButton(_xboxController, Y);
	Button buttonSTART = new JoystickButton(_xboxController, START);
	Button buttonSELECT = new JoystickButton(_xboxController, SELECT);
	Button buttonLB = new JoystickButton(_xboxController, LB);
	Button buttonRB = new JoystickButton(_xboxController, RB);
	Button buttonLT = new JoystickButton(_xboxController, LT);
	Button buttonRT = new JoystickButton(_xboxController, RT);
	Button buttonStickLeft = new JoystickButton(_xboxController, stickLeftButton);
	Button buttonStickRight = new JoystickButton(_xboxController, stickRightButton);

	Button povUp = new POVButton(_xboxController, 0, pov);
	Button povRight = new POVButton(_xboxController, 90, pov);
	Button povDown = new POVButton(_xboxController, 180, pov);
	Button povleft = new POVButton(_xboxController, 270, pov);

	ArrayList<Button> buttons = new ArrayList<Button>();

	public OI(){

		// Claw Tilt
		povRight.whileHeld(new ClawTiltUp());
		povRight.whenReleased(new ClawTiltStop());
		povleft.whileHeld(new ClawTiltDown());
		povleft.whenReleased(new ClawTiltStop());

		// Claw Climb	
		povUp.whileHeld(new ClawClimbUp());
		povDown.whileHeld(new ClawClimbDown());
		povUp.whenReleased(new ClawClimbStop());
		povDown.whenReleased(new ClawClimbStop());
		
		//  Claw Open and Close
		buttonLB.whenPressed(new ClawOpen());
		buttonRB.whenPressed(new ClawClose());
		
		// Tilt Front Command
		buttonY.whileHeld(new TiltFrontUp());
		buttonX.whileHeld(new TiltFrontDown());
		buttonY.whenReleased(new TiltFrontStop());
		buttonX.whenReleased(new TiltFrontStop());
		
		// Tilt Back commands
		buttonB.whileHeld(new TiltBackUp());
		buttonA.whileHeld(new TiltBackDown());
		buttonB.whenReleased(new TiltBackStop());
		buttonA.whenReleased(new TiltBackStop());
	}
		

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
	
