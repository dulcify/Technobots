package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PushPneumatic extends Subsystem {

	Solenoid pushPneumatic = new Solenoid(RobotMap.pneumaticClawPush);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pushClaw() {
    	pushPneumatic.set(true);
    }
    
    public void retractClaw() {
    	pushPneumatic.set(false);
    }
    
}