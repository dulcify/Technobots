/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team743.robot;

import org.usfirst.frc.team743.robot.commands.autonomous.DoNothing;
import org.usfirst.frc.team743.robot.commands.autonomous.GoStraight;
import org.usfirst.frc.team743.robot.subsystems.ClawClimbMechanism;
import org.usfirst.frc.team743.robot.subsystems.ClawMechanism;
import org.usfirst.frc.team743.robot.subsystems.ClawTiltMechanism;
import org.usfirst.frc.team743.robot.subsystems.DifferentialDriveSystem;
import org.usfirst.frc.team743.robot.subsystems.MecanumDriveSystem;
import org.usfirst.frc.team743.robot.subsystems.TiltBack;
import org.usfirst.frc.team743.robot.subsystems.TiltFront;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	
	// the time the command will run.
	private static final int AUTONOMOUS_MODE_LENGTH = 15;
	
	// Pneumatics
	public static final ClawMechanism clawMechanism = new ClawMechanism();
	public static final TiltFront tiltFront = new TiltFront(); 		
	public static final TiltBack tiltBack = new TiltBack(); 

	// Motors
	public static final ClawTiltMechanism clawTiltMechanism = new ClawTiltMechanism();
	public static final ClawClimbMechanism clawClimbMechanism = new ClawClimbMechanism();

	// Differential Drive System
	//public static final DifferentialDriveSystem differential = new DifferentialDriveSystem();

	// Mecanum Drive system
	public static final MecanumDriveSystem mecanum = new MecanumDriveSystem();

	public static OI m_oi;

	private static final Compressor compressor = new Compressor(RobotMap.compressorPort);
	
	//Instantiating the variable containing the autonomous command.
	Command m_autonomousCommand;
	
	//Instantiating the chooser for the SmartDashboard
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	private void initCameras()
	{
		UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture("Claw", 0);
		camera1.setResolution(320, 240);
		camera1.setFPS(15);
		
		UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture("Motion",1);             
		camera2.setResolution(320, 240);
		camera2.setFPS(10);
	}


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		
		//initCameras();

		// AUTONOMOUS MODE STUFF - NOT NEEDED IN 2019 FRC
		// m_chooser.addDefault("Straight", new GoStraight(AUTONOMOUS_MODE_LENGTH));
		// m_chooser.addObject("Nothing", new DoNothing(AUTONOMOUS_MODE_LENGTH));
		
		// SmartDashboard.putData("Auto mode", m_chooser);
	}
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		compressor.setClosedLoopControl(false);
	}

	/**
	 * 
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	
		//compressor.setClosedLoopControl(true);
	
		m_autonomousCommand = m_chooser.getSelected();
/*
		  boolean db_station1 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_1, false);
		  boolean db_station2 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_2, false);
		  boolean db_station3 = SmartDashboard.getBoolean(RobotMap.DB_BUTTON_3, false);

		  System.out.println("Dashboard values: " + 
				  " Station1: " + db_station1 +
				  " Station2: " + db_station2 +
				  " Station3: " + db_station3);
		  
		  if (db_station1) {
			  m_autonomousCommand = new Station1Command(Robot.AUTONOMOUS_MODE_LENGTH);
		  }
		  else if (db_station2) {
			  m_autonomousCommand = new Station2Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
		  }
		  else if (db_station3) {
			  m_autonomousCommand = new Station3Command(Robot.AUTONOMOUS_MODE_LENGTH);			  
		  }		 
*/
		// schedule the autonomous command (example)
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		compressor.setClosedLoopControl(true);
		System.out.println("teleopInit... Initializing Operator Mode");
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		// use this value as a scale to speed up or slow down the robot
		double leftX = -m_oi._xboxController.getX(Hand.kLeft);
		double leftY = -m_oi._xboxController.getY(Hand.kLeft);

		double rightY = -m_oi._xboxController.getY(Hand.kRight);
		double rightX = -m_oi._xboxController.getX(Hand.kRight);

		mecanum.driveCartesian(leftY, leftX, 0.0);
		
		// differential.tankDrive(leftY, rightY);

		// mecanum.driveCartesian(
		// 		m_oi._xboxController.getX(Hand.kLeft)*.90,
		//  		m_oi._xboxController.getY(Hand.kLeft)*.90, 
		//  		m_oi._xboxController.getRawAxis(2)*.90
		// ); 
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}


	
}
