
package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutoExecute;
import frc.robot.commands.RunAutonomous;
import frc.robot.commands.RunJoystickTank;
import frc.robot.sensors.RobotEncoder;
import frc.robot.sensors.RobotGyro;
import frc.robot.sensors.RobotUltrasonicAnalog;
import frc.robot.subsystems.Drive;

/* The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drive drive;
	public static RobotUltrasonicAnalog ultrasonic;
	public static RobotGyro gyro = new RobotGyro();
	public static RobotEncoder encoder = new RobotEncoder();
    public static AutoExecute auto_execute = new AutoExecute();
	
	public static Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */

	@Override
	public void robotInit() {
		RobotMap.init();

		ultrasonic = new RobotUltrasonicAnalog(0);
		gyro.resetGyro();
		oi = new OI();
		drive = new Drive();
		encoder.setNumberOfEncoders(1);
		encoder.invert();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = new RunAutonomous();
		encoder.reset();
		gyro.resetGyro();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Command command = new RunJoystickTank();
		command.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("ENCODER VALUES", encoder.getDistance());
		}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}