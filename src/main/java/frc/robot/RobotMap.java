package frc.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static RobotDrive myRobot;

	public static WPI_VictorSPX robotLeftVictor;
	public static WPI_VictorSPX robotRightVictor;


	public static WPI_TalonSRX robotRightTalon;
	public static WPI_TalonSRX robotLeftTalon;

	public static SpeedController leftDrive;
	public static SpeedController rightDrive;
	
	private static boolean has_left_side = false;
	private static boolean has_right_side = false;
	private static boolean is_left_inverted = false;
	private static boolean is_right_inverted = false;
	
	// public static void set_left_drive(int channel_1, int channel_2) {
	// 	robotLeftVictor1 = new Victor(channel_1);
	// 	robotLeftVictor2 = new Victor(channel_2);
	// 	has_left_side = true;
	// }
	
	// public static void set_right_drive(int channel_1, int channel_2) {
	// 	robotRightVictor1 = new Victor(channel_1);
	// 	robotRightVictor2 = new Victor(channel_2);
	// 	has_right_side = true;
	// }
	
	// public static void invert_left_drive(boolean is_inverted) {
	// 	is_left_inverted = is_inverted;
	// }
	// public static void invert_right_drive(boolean is_inverted) {
	// 	is_right_inverted = is_inverted;
	//}

	public static void init() {
		// Robot.auto_execute.init();
		
		// SpeedController leftDrive;
		// SpeedController rightDrive;

		robotLeftTalon = new WPI_TalonSRX(23);
		robotRightTalon = new WPI_TalonSRX(22);
		robotLeftVictor = new WPI_VictorSPX(20);
		robotRightVictor = new WPI_VictorSPX(21);
		
		robotLeftTalon.set(0.375);
		robotLeftVictor.follow(robotLeftTalon);
		robotLeftTalon.setInverted(true);
		robotLeftVictor.setInverted(true);
		robotRightTalon.set(0.375);
		robotRightVictor.follow(robotRightTalon);
	
		
		// leftDrive = new MultiSpeedController(robotLeftVictor1, robotLeftVictor2);
		// rightDrive = new MultiSpeedController(robotRightVictor1, robotRightVictor2);

		// leftDrive.setInverted(is_left_inverted);
		// rightDrive.setInverted(is_right_inverted);
		// myRobot = new RobotDrive(leftDrive, rightDrive);
	}
}