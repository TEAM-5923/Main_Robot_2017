package subsystems;


import org.usfirst.frc.team5923.robot.OI;
import org.usfirst.frc.team5923.robot.RobotMap;

import commands.TankDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Drivetrain extends Subsystem {
	private  SpeedController rightSpeedCon;
    private  SpeedController leftSpeedCon;
    private DoubleSolenoid shifter;
    public RobotDrive drivetrainRobotDrive6;
    public SpeedController leftSubSpeed;
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	
	public SpeedController rightSubSpeed;
    
	
	 
	public Drivetrain(RobotMap robotMap){
		this.leftEncoder = robotMap.getLeftEncoder();
		this.rightEncoder = robotMap.getRightEncoder();
		this.rightSpeedCon = robotMap.getRightSpeed();
		this.leftSpeedCon = robotMap.getLeftSpeed();
		this.shifter = robotMap.getDrivetrainSolenoid();
		this.rightSubSpeed = robotMap.getRightSubSpeed();
		this.leftSubSpeed = robotMap.getLeftSubSpeed();
		drivetrainRobotDrive6 = new RobotDrive(rightSpeedCon,leftSpeedCon,rightSubSpeed,leftSubSpeed);
    	drivetrainRobotDrive6.setSafetyEnabled(false);
    	drivetrainRobotDrive6.setExpiration(0.1);
    	drivetrainRobotDrive6.setSensitivity(0.5);
    	drivetrainRobotDrive6.setMaxOutput(1.0);
    	leftEncoder.setDistancePerPulse(1);
    	
    	
		
	}
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

	public void resetEncoders(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	public double getDistance(){
		return leftEncoder.getDistance();
	}
	

	
	public void setLeftSpeed( double speed){
		leftSpeedCon.set(speed);
		leftSubSpeed.set(speed);
	}
	public void setRightSpeed(double speed){
		rightSpeedCon.set(-speed);
		rightSubSpeed.set(-speed);
	}
	public void shiftUp(){
		shifter.set(DoubleSolenoid.Value.kForward);
	}
	public void shiftDown(){
		shifter.set(DoubleSolenoid.Value.kReverse);
	}
}
	
