package org.usfirst.frc.team5923.robot;

import commands.AutoCommand;
import commands.DumbDriveX;
import commands.GearOpen;
import commands.TankDrive;
import commands.TurnNDegrees;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import subsystems.*;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */ 

public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	public static Gearcarrier carrier;
	public static RobotMap robotMap;
	public static Drivetrain drivetrain;
	public static Climber climber;
	public static AHRS navx;
//SerialPort.Port.kMXP
	public static Intake intake;
	public Compressor compressor;
	public static Encoder rightEncoder;
	public static Encoder leftEncoder;
	public Command autoCommand;
	public Command dumbDriveX;
	public static OI oi;
	@Override
	public void robotInit() {
	
		robotMap = new CompetitionRobotMap();
		robotMap.init();
		drivetrain = new Drivetrain(robotMap);
		carrier = new Gearcarrier(robotMap);
		climber = new Climber(robotMap);

		leftEncoder = drivetrain.leftEncoder;
		rightEncoder = drivetrain.rightEncoder;
		navx = new AHRS(SPI.Port.kMXP);
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		dumbDriveX = new DumbDriveX(6);
		NetworkTable.initialize();
		SmartDashboard.putData("Auto choices", chooser);
		CameraServer server = CameraServer.getInstance();
		autoCommand = new AutoCommand();
		
		server.startAutomaticCapture();
		oi = new OI();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		//autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		//System.out.println("Auto selected: " + autoSelected);
	
		
		
		 dumbDriveX.start();
		 
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override 
	public void autonomousPeriodic() {
		
			
		
		Scheduler.getInstance().run();	
		SmartDashboard.putNumber("Distance", drivetrain.getDistance());
	
	//	SmartDashboard.putData("setPoint",drivex.setPoint);
		//SmartDashboard.putData(PID, );
		if (drivetrain.getCurrentCommand()!=null){
			SmartDashboard.putString("name" , drivetrain.getCurrentCommand().getName());
		}//switch (autoSelected) {
		//case customAuto:
			// Put custom auto code here
			//break;
		//case defaultAuto:
		//default:
			// Put default auto code here
			//break;
		
		//}
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	
	public void teleopInit(){
		if (dumbDriveX != null  ) dumbDriveX.cancel();	
		new GearOpen().start();
	}
	
	@Override 
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

