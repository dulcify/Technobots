package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *  This command is for making the claw tilt down
 */
public class ClawTiltDown extends InstantCommand {

    public ClawTiltDown() {
        requires(Robot.clawTiltMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.clawTiltMechanism.Down();
    	System.out.println("Claw tilt down...");
    }
}
