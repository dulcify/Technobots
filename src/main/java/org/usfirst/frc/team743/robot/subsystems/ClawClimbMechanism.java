package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *  Subsystem that controls the motors to make the claw climb up/down
 */
public class ClawClimbMechanism extends Subsystem {
	
    public static final SpeedControllerGroup speedGroup = new SpeedControllerGroup(
		new Talon(RobotMap.clawMotorClimb1), new Talon(RobotMap.clawMotorClimb2));


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up() {
    	speedGroup.set(RobotMap.clawClimbSpeed);
    }
    public void Down() {
    	speedGroup.set(-RobotMap.clawClimbSpeed);
    }
    public void Stop() {
    	speedGroup.stopMotor();
    }
}
