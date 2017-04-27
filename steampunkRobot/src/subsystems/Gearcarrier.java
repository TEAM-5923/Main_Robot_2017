package subsystems;

import org.usfirst.frc.team5923.robot.RobotMap;

import commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;



public class Gearcarrier extends Subsystem {
	private DoubleSolenoid solenoid;
	
public Gearcarrier(RobotMap robotmap){
	this.solenoid = robotmap.getCarrierSolenoid();
}

public void actuateOpen(){
	solenoid.set(Value.kReverse);
}

public void actuateClose(){
	solenoid.set(Value.kForward);
}

	
	



@Override
protected void initDefaultCommand() {

	// TODO Auto-generated method stub
}
}

