package org.usfirst.frc.team78.robot.subsystems;

import org.usfirst.frc.team78.robot.RobotMap;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hopper extends Subsystem {

	Servo upperGate = new Servo(RobotMap.UPPERGATE);
	Servo lowerGate = new Servo(RobotMap.LOWERGATE);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void openGate(String gate){
		if(gate == "upper"){
			upperGate.setAngle(90);
		}else if(gate == "lower"){
			lowerGate.setAngle(90);
		}
	}
	
	public void closeGate(String gate){
		if(gate == "upper"){
			upperGate.setAngle(30);
		}else if(gate == "lower"){
			lowerGate.setAngle(30);
		}
	}
	public void test(){
		upperGate.setAngle(180);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

