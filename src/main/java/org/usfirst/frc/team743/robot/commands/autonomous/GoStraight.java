package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.commands.TimedAutonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GoStraight extends TimedAutonomous {
	
	private final CommandGroup commandGroup3 = new CommandGroup();

	public GoStraight(double timeout) {
		super(timeout);
		commandGroup3.addSequential( new MoveY(1.5,-.75));
	}

	@Override
	protected void stop_autonomous() {
		commandGroup3.cancel();

	}

	@Override
	protected void start_autonomous() {
		commandGroup3.start();
	}

}