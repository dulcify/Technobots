package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.commands.TimedAutonomous;

public class DoNothing extends TimedAutonomous {

	public DoNothing(double timeout) {
		super(timeout);
	}

	@Override
	protected void stop_autonomous() {
	}

	@Override
	protected void start_autonomous() {
	}

}
