package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	public void joystickTank() {
		RobotMap.myRobot.tankDrive(Robot.oi.joystickLeft, Robot.oi.joystickRight);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}