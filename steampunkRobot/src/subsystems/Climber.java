package subsystems;

import org.usfirst.frc.team5923.robot.RobotMap;

import commands.IdleClimber;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	SpeedController climberController, climberController2;
	
	public Climber(RobotMap robotmap){
		this.climberController = robotmap.getClimberSpeed();
		//this.climberController2 = robotmap.getClimberSpeed2();
	}
	
	
	@Override
	protected void initDefaultCommand() {	
		setDefaultCommand(new IdleClimber());
	}
	
	public void climb(){
		climberController.set(1.0);

	}
	
	public void climbDown(){
		climberController.set(-1.0);
		
	}
	
	public void idle() {
		climberController.set(0.0);
	
	}
	public void descend(){
		climberController.set(-0.8);
	}

}
