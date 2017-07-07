package org.usfirst.frc.team78.robot;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import org.usfirst.frc.team78.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team78.robot.commands.fireCatapult;
import org.usfirst.frc.team78.robot.commands.readySetShoot;
import org.usfirst.frc.team78.robot.commands.resetCatapult;




/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//JOYSTICKS
	public static Joystick driverStick;
	public static Joystick manipulatorStick;
	public static Joystick tStick;
	public Joystick weekZeroMStick;
	
	
	//DRIVER BUTTONS
	public Button btn1;
	public Button btn2;
	public Button btn3;
	public Button btn4;
	public Button btn5;
	public Button btn6;
	public Button btn7;
	public Button btn8;
		
	
	//CONSTANTS
	final static double STICK_DEADZONE = 0.05;
	
	public OI(){
		driverStick = new Joystick(0);
		
	// DRIVER BUTTONS
		
	btn6 = new JoystickButton(driverStick, 6);
	btn6.whenPressed(new fireCatapult());
		
//	btn5 = new JoystickButton(driverStick, 5);
//	btn5.whenPressed(new readySetShoot());
				

		
		
	}
	
	///DRIVER STICK
	public double getDriverLeftStick() {
		double stick = driverStick.getY();
		if (Math.abs(stick) < STICK_DEADZONE){
			return 0;
		}
		else
			return -stick;
	}
	
	public double getDriverRightStick() {
		double stick = driverStick.getThrottle();
		if (Math.abs(stick) < STICK_DEADZONE){
			return 0;
		}
		else
			return -stick;
	}
	
	public double getManipulatorStick() {
		double stick = manipulatorStick.getRawAxis(2);
		if (Math.abs(stick) < STICK_DEADZONE) return 0;
		else return -stick;
	}
	
	public boolean isStickPushed(){
		boolean state;
		if(getManipulatorStick() > STICK_DEADZONE || getManipulatorStick() < STICK_DEADZONE){
			state = true;
		}
		else{
			state = false;
		}
		return state;
	}
	
	public boolean isTriggerPushed(){
		boolean state;
		if(Math.abs(manipulatorStick.getRawAxis(3)) > STICK_DEADZONE) return true;
		else return false;
	}
	
}

