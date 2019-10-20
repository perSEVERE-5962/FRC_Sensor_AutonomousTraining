package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class JoystickThrottle extends Subsystem {

	public static void Speed() {
		double throttle = (((Robot.oi.joystickRight.getThrottle() * -1) + 2) / 3);
		SmartDashboard.putString("Throttle", "" + throttle);
		RobotMap.myRobot.setMaxOutput(throttle);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}