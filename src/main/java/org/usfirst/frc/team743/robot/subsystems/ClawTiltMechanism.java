package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *  Subsystem that controls the claw angle motor
 */
public class ClawTiltMechanism extends Subsystem {
	
	public final double speed = 0.3;
	
    private final Talon clawTiltMotor = new Talon(RobotMap.clawTiltMotor);


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up() {
    	clawTiltMotor.set(speed * RobotMap.clawTiltSpeedAdjust);
    }
    public void Down() {
    	clawTiltMotor.set(-speed * RobotMap.clawTiltSpeedAdjust);
    }
    public void Stop() {
    	clawTiltMotor.stopMotor();
    }
}
