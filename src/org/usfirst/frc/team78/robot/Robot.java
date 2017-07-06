
package org.usfirst.frc.team78.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team78.robot.subsystems.Catapult;
import org.usfirst.frc.team78.robot.subsystems.Chassis;


import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Catapult catapult = new Catapult(); 
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;
    public static NetworkTable table;



	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {//read about ahrs reset, fix slow mode
		oi = new OI();
  
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	

        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    	
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
//    	//SENSOR DATA
//    	SmartDashboard.putNumber("Left Enc", Robot.chassis.getLeftEnc());
//    	SmartDashboard.putNumber("Right Enc", Robot.chassis.getRightEnc());
//    	SmartDashboard.putNumber("Right Stick", Robot.oi.getDriverRightStick());
//    	SmartDashboard.putNumber("Left Stick", Robot.oi.getDriverLeftStick());
//    	SmartDashboard.putNumber("Get Angle", Robot.chassis.getAngle());
//    	SmartDashboard.putNumber("Get Pitch", Robot.chassis.getPitch());
//    	SmartDashboard.putNumber("Get Roll", Robot.chassis.getRoll());
//    	
//    	//VISION
//    	SmartDashboard.putNumber("Jetson X", Robot.vision.getVisionX());
//    	SmartDashboard.putNumber("Jetson Y", Robot.vision.getVisionY());
//    	
//    	//PROGRAM TESTS
//    	SmartDashboard.putNumber("Shooter Speed", Robot.shooter.shooterSpeed);
//    	SmartDashboard.putBoolean("Timer", Robot.chassis.timerStart);
//    	SmartDashboard.putNumber("Rate Error", Robot.shooter.rateError);
//    	SmartDashboard.putNumber("I Component", Robot.shooter.iComponent);
//    	SmartDashboard.putNumber("P Component", Robot.shooter.pComponent);
//    	SmartDashboard.putBoolean("Intake", Robot.intake.intakePnState);
//    	SmartDashboard.putBoolean("Shooter", Robot.shooter.shooterPnState);
//    	SmartDashboard.putBoolean("Pancake", Robot.shooter.pancakePnState);
//    	SmartDashboard.putBoolean("timer", Robot.chassis.timerStart);
//    	SmartDashboard.putNumber("Vision Gyro", Robot.chassis.testAngle);
//    	SmartDashboard.putBoolean("Is at Vision Turn", Robot.chassis.isAtVisionHeading());
//
//    
        	
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
