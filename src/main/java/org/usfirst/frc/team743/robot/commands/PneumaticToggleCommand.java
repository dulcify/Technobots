package org.usfirst.frc.team743.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class PneumaticToggleCommand extends ConditionalCommand {

	private boolean isExtended = false;
	
	@Override
	public synchronized void start() {
		if (!isRunning()) {
			isExtended = !isExtended;
			System.out.println("Start called...");
		}
		super.start();		
	}
	
	public PneumaticToggleCommand(Command onTrue) {
		super(onTrue);
	}

	public PneumaticToggleCommand(Command onTrue, Command onFalse) {
		super(onTrue, onFalse);
	}

	public PneumaticToggleCommand(String name, Command onTrue) {
		super(name, onTrue);
	}

	public PneumaticToggleCommand(String name, Command onTrue, Command onFalse) {
		super(name, onTrue, onFalse);
	}

	@Override
	protected boolean condition() {
		return isExtended;
	}

}
