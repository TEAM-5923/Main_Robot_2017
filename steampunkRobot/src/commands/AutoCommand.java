package commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommand extends CommandGroup {
	double degrees = 10;
	int time = 240;
	public AutoCommand(){
		addSequential( new DumbDriveX(time));
		//addSequential(new TurnNDegrees(degrees));
	}
	
	
	
}
