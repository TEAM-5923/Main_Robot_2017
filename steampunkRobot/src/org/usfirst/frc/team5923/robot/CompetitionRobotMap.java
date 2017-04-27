package org.usfirst.frc.team5923.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Spark;

public class CompetitionRobotMap implements RobotMap{
	/*http://www.digikey.com/catalog/en/partgroup/63r/11554*/
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	public SpeedController drivetrainRightSpeed;
	public SpeedController drivetrainLeftSpeed;
	public DoubleSolenoid shifter; 
	public DoubleSolenoid gearCarrier;
	public SpeedController climberSpeed;
	private SpeedController collectorSpeed;
	public SpeedController intakeSpeed;
	public SpeedController leftSubSpeed;
	public Compressor compressor;
	public SpeedController rightSubSpeed;
    public void init() {
    	gearCarrier = new DoubleSolenoid(2,3);
    	shifter = new DoubleSolenoid(0,1);
    	climberSpeed = new Victor(3);
     	drivetrainRightSpeed = new Spark(1);
     	rightSubSpeed = new Spark(2);
     	leftSubSpeed = new Spark(4);
    	drivetrainLeftSpeed= new Spark(0);
    	//climberSpeed2 = new Victor(4);
    	leftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    	rightEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
    }
    public Encoder getLeftEncoder(){
    	return leftEncoder;
    
    }
	public Encoder getRightEncoder() {
		return rightEncoder;
	}
	public SpeedController getLeftSpeed() {
		// TODO Auto-generated method stub
		return drivetrainLeftSpeed ;
	}

	public SpeedController getRightSubSpeed(){
		return rightSubSpeed;
		
	}
	
	public SpeedController getLeftSubSpeed(){
		return leftSubSpeed;
	}
	public SpeedController getRightSpeed() {
		// TODO Auto-generated method stub
		return drivetrainRightSpeed;
		
	}
	

	
	

	public DoubleSolenoid getDrivetrainSolenoid(){
		return shifter;
	}
	
	public DoubleSolenoid getCarrierSolenoid(){
		return gearCarrier;
	}
	public SpeedController getClimberSpeed(){
		return climberSpeed;
	}

	
	public SpeedController getCollectorSpeed(){
		return collectorSpeed;
	}
}
