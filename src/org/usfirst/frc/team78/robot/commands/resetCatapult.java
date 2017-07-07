package org.usfirst.frc.team78.robot.commands;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.subsystems.Catapult;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class resetCatapult extends Command {
	
	
    
	public resetCatapult() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.catapult.setChooChoo(100);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.catapult.getLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.catapult.setChooChoo(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
