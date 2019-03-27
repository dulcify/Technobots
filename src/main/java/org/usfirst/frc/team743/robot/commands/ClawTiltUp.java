package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *  This command is for making the claw tilt up
 */
public class ClawTiltUp extends InstantCommand {

    public ClawTiltUp() {
        requires(Robot.clawTiltMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.clawTiltMechanism.Up();
    	System.out.println("Claw tilt up...");
    }
}
