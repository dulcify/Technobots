package org.usfirst.frc.team743.robot.commands.autonomous;

import org.usfirst.frc.team743.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class LeftSwitch extends TimedAutonomous {

	private final CommandGroup groupCommand1 = new CommandGroup();
	
	public LeftSwitch(double timeout) {
		super(timeout);
//		groupCommand1.addSequential(new MoveClaw(.25, false));
//		groupCommand1.addSequential(new MoveY(1, -.25));
//		groupCommand1.addSequential(new MoveClaw(0, true));
//		groupCommand1.addSequential(new MoveBigActuator(2, -.25));
//		groupCommand1.addSequential(new MoveY(1, -.2));
//		groupCommand1.addSequential(new SmallPneumatic(1, true));
//		groupCommand1.addSequential(new MoveClaw(1, true));
//		groupCommand1.addSequential(new MoveClaw(1, false));
//		groupCommand1.addSequential(new MoveBigActuator(2, 1));
//		groupCommand1.addSequential(new MoveBigActuator(2, -1));
		
	}

	@Override
	protected void stop_autonomous() {
		groupCommand1.cancel();
		
	}

	@Override
	protected void start_autonomous() {
		groupCommand1.start();
	}

}
