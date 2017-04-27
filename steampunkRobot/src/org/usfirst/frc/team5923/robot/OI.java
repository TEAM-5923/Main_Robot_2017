 package org.usfirst.frc.team5923.robot;



import commands.Climb;
import commands.ClimbDown;
import commands.GearClose;
import commands.GearOpen;
import commands.IdleClimber;
import commands.ShiftDown;
import commands.ShiftUp;
import commands.TankDrive;



public class OI  {
	
	public UberXboxController controller; 
	
	public OI(){
		controller = new UberXboxController(0);
		controller.getButtonB().whenPressed(new TankDrive());
		
		//controller.getButtonA().toggleWhenPressed(new Climb());
		
		controller.getButtonX().toggleWhenPressed(new ClimbDown());
		
		controller.getSelectButton().whenPressed(new GearOpen());
		
		controller.getStartButton().whenPressed(new GearClose());
		
		controller.getRightBumper().whenPressed(new ShiftUp());
		
		controller.getLeftBumper().whenPressed(new ShiftDown());
	
	}
	
}


	

	
	




