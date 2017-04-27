package commands;



import org.usfirst.frc.team5923.robot.Robot;

import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import subsystems.Drivetrain;


public class DriveX extends PIDCommand{
	Drivetrain drivetrain;
	private double xDistance;
	private double speed;
	private double minSpeed;
	private double tolerance;
	public double setPoint;
	public int count;
	public int time;
	public DriveX (double distance){
	super (.01,.0001,0);
		requires(Robot.drivetrain);
		drivetrain = Robot.drivetrain;
		this.xDistance = distance;
		
		
		
	}


	
	
    protected void initialize() {
    	drivetrain.resetEncoders();
    	speed =0.3;
    	tolerance = 8;
    	super.setSetpoint(xDistance);
    	count = 0;
    	minSpeed = .3;
    	time = 0;
    }

    /*
     * execute() - In our execute method we call a tankDrive method we have created in our subsystem. This method takes two speeds as a parameter which we get from methods in the OI class.
     * These methods abstract the joystick objects so that if we want to change how we get the speed later we can do so without modifying our commands
     * (for example, if we want the joysticks to be less sensitive, we can multiply them by .5 in the getLeftSpeed method and leave our command the same).
     */
    protected void execute() {
    	drivetrain.setLeftSpeed(speed);
    	drivetrain.setRightSpeed(speed);
    		
    	
    	
    	
    }

	
    /*
     * isFinished - Our isFinished method always returns false meaning this command never completes on it's own. The reason we do this is that this command will be set as the default command for the subsystem. This means that whenever the subsystem is not running another command, it will run this command. If any other command is scheduled it will interrupt this command, then return to this command when the other command completes.
     */
    public boolean isFinished() {
    	if(Robot.drivetrain.getDistance() >= xDistance-tolerance&&Robot.drivetrain.getDistance() <= xDistance+tolerance  ){
    		if(count > 5){
    			return true;
    		}else{
    			count ++;
    			return false;
    		}
    		
    		
    		
    	}
    	count = 0;
    	// noot == noot + noot; // = true
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    }




	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return drivetrain.getDistance() ;
	}




	@Override
	protected void usePIDOutput(double output) {
		
			if(Math.abs(output)<minSpeed){
				if(output < 0){
					speed = -.4;
				}else{
					speed = .4;
				}
			}else{
				speed = output;
			}
			
			
			}
		}
		
		
	





	


