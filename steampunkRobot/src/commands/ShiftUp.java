package commands;

import org.usfirst.frc.team5923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

import subsystems.Drivetrain;

public class ShiftUp extends Command {


	private Drivetrain drivetrain;
    public ShiftUp() {
    	requires(Robot.drivetrain);
    	drivetrain = Robot.drivetrain;
}




    protected void initialize() {
    }

    /*
     * execute() - In our execute method we call a tankDrive method we have created in our subsystem. This method takes two speeds as a parameter which we get from methods in the OI class.
     * These methods abstract the joystick objects so that if we want to change how we get the speed later we can do so without modifying our commands
     * (for example, if we want the joysticks to be less sensitive, we can multiply them by .5 in the getLeftSpeed method and leave our command the same).
     */
    protected void execute() {
    	//if(Robot.rightEncoder.getRate() > ) // This will be for automatic Shifting after testing is done
    		drivetrain.shiftUp();
    	//else
    		//drivetrain.shiftDown();
    }
    
	
    /*
     * isFinished - Our isFinished method always returns false meaning this command never completes on it's own. The reason we do this is that this command will be set as the default command for the subsystem. This means that whenever the subsystem is not running another command, it will run this command. If any other command is scheduled it will interrupt this command, then return to this command when the other command completes.
     */
    protected boolean isFinished() {
    	
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
