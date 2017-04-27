package commands;

import org.usfirst.frc.team5923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import subsystems.Climber;

/**
 *
 */
public class Climb extends Command {
	private Climber climber;
    public Climb() {
    	requires(Robot.climber);
    	climber = Robot.climber;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	climber.climb();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	new IdleClimber();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
