package org.usfirst.frc.team743.robot.subsystems;

import org.usfirst.frc.team743.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *  Mecanum Drive System - This configurations has 4 independent wheels
 */
public class MecanumDriveSystem extends Subsystem {

    private Talon frontLeftMotor = new Talon(RobotMap.mecanumFrontLeft);
    private Talon frontRightMotor  = new Talon(RobotMap.mecanumFrontRight);
    
    private Talon backLeftMotor = new Talon(RobotMap.mecanumBackLeft);
    private Talon backRightMotor = new Talon(RobotMap.mecanumBackRight);
    
    public final MecanumDrive drive = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * This method stops all the motors and causes the robot to hault
     */
    public void stop()
    {
        drive.stopMotor();
    }

    public void driveCartesian(double x, double y, double z)
    {
        drive.driveCartesian(
            y * RobotMap.driveSpeedAdjust, 
            x * RobotMap.driveSpeedAdjust, 
            z * RobotMap.driveSpeedAdjust);
    }
}