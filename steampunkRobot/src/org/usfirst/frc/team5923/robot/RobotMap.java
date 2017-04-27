package org.usfirst.frc.team5923.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public interface RobotMap {
	public SpeedController getLeftSpeed();
	public SpeedController getRightSpeed();
	public DoubleSolenoid getCarrierSolenoid();
	public void init();
	public SpeedController getCollectorSpeed();
	public DoubleSolenoid getDrivetrainSolenoid();
	public SpeedController getClimberSpeed();
	public SpeedController getRightSubSpeed();
	public SpeedController getLeftSubSpeed();
	public Encoder getLeftEncoder();
	public Encoder getRightEncoder();
	
}
