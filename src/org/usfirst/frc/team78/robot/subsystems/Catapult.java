package org.usfirst.frc.team78.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.RobotMap;

import com.ctre.CANTalon;
/**
 *
 */
public class Catapult extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public CANTalon choochoo = new CANTalon(1);
	public DigitalInput limit = new DigitalInput(RobotMap.LIMIT);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setChooChoo(int speed){
    	choochoo.set(speed);
    }
    
    public boolean getLimit(){
    	return limit.get();
    }
}

