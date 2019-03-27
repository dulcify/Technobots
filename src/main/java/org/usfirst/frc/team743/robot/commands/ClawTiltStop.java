package org.usfirst.frc.team743.robot.commands;

import org.usfirst.frc.team743.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *  This command is for stopping the Claw Tilt
 */
public class ClawTiltStop extends InstantCommand {

    public ClawTiltStop() {
        requires(Robot.clawTiltMechanism);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.clawTiltMechanism.Stop();
    	System.out.println("Claw tilt stop...");
    }
}
