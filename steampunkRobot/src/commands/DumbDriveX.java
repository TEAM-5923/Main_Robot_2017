package commands;



import org.usfirst.frc.team5923.robot.OI;
import org.usfirst.frc.team5923.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Timer.Interface;
import edu.wpi.first.wpilibj.command.Command;
import subsystems.Drivetrain;

public class DumbDriveX extends Command {
	private Drivetrain drivetrain;
	private double leftSpeed;
	private double rightSpeed;
	Timer time;
	private double endTime;
	public DumbDriveX(double endTime) {
		this.endTime = endTime;
		requires(Robot.drivetrain );
	
		drivetrain = Robot.drivetrain;
	}

	protected void initialize() {
		leftSpeed = 0.3;
		rightSpeed = 0.3;
		time = new Timer();
		time.reset();
		time.start();
		
		
		}
		
	


	/*/*
 * execute() - In our execute method we call a tankDrive method we have
	 * created in our subsystem. This method takes two speeds as a parameter
	 * which we get from methods in the OI class. These methods abstract the
	 * joystick objects so that if we want to change how we get the speed later
	 * we can do so without modifying our commands (for example, if we want the
	 * joysticks to be less sensitive, we can multiply them by .5 in the
	 * getLeftSpeed method and leave our command the same).
	 */
	protected void execute() {
	
		
		
		
		drivetrain.setLeftSpeed(leftSpeed);
		drivetrain.setRightSpeed(rightSpeed);
	
		
	}

	/*
	 * isFinished - Our isFinished method always returns false meaning this
	 * command never completes on it's own. The reason we do this is that this
	 * command will be set as the default command for the subsystem. This means
	 * that whenever the subsystem is not running another command, it will run
	 * this command. If any other command is scheduled it will interrupt this
	 * command, then return to this command when the other command completes.
	 */
	public boolean isFinished() {
		
		if (time.get() >= endTime){
			return true;
		}
		else return false;
	}

	protected void end() {
		time.stop();
		
	}

	protected void interrupted() {
		
		
	}
	
}