package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *  Differential Drive System -  This is a tank like setup with a left and a right belt drive
 */
public class DifferentialDriveSystem extends Subsystem {

    // Left Talons
    private Talon leftFirstTalon = new Talon(RobotMap.motorLeftFirst);
    private Talon leftSecondTalon  = new Talon(RobotMap.motorLeftSecond);
    // Right Talons
    private Talon rightFirstTalon = new Talon(RobotMap.motorRightFirst);
    private Talon rightSecondTalon = new Talon(RobotMap.motorRightSecond);

    // Speed Control groups so that Right and Left motors move at the same speed
	private SpeedControllerGroup leftTalonGroup = new SpeedControllerGroup(leftFirstTalon, leftSecondTalon);
    private SpeedControllerGroup rightTalonGroup = new SpeedControllerGroup(rightFirstTalon, rightSecondTalon);
    
    // Actual Differential Drive
	public final DifferentialDrive drive = new DifferentialDrive(leftTalonGroup, rightTalonGroup);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * Override the drive in a tank manner
     * @param left Left speed (between 1.0 and -1.0)
     * @param right Right speed (between 1.0 and -1.0)
     */
    public void tankDrive(double left, double right)
    {
        drive.tankDrive(left * RobotMap.driveSpeedAdjust, right * RobotMap.driveSpeedAdjust);
    }

    /**
     * This method stops all the motors and causes the robot to hault
     */
    public void stop()
    {
        drive.stopMotor();
    }
}