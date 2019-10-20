package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.commands.Item;
import frc.robot.commands.RunAutonomous;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Autonomous extends Subsystem {

	private RunAutonomous runAuto = (RunAutonomous) Robot.autonomousCommand;

	public enum sensorType {
		encoder, ultrasonic, gyro, time
	};
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void forwardWithEncoders(double speed, int sensorValue) {
		Item item = new Item(Math.abs(speed), 0, sensorType.encoder, Math.abs(sensorValue));
		runAuto.addCommand(item);
	}
	
	public void forwardWithUltrasonic(double speed, int sensorValue) {
		Item item = new Item(Math.abs(speed), 0, sensorType.ultrasonic, Math.abs(sensorValue));
		runAuto.addCommand(item);
	}

	public void turnLeft(double speed, int sensorValue) {
		Item item = new Item(Math.abs(speed), 1, sensorType.gyro, Math.abs(sensorValue), true);
		runAuto.addCommand(item);
	}
	
	public void turnRight(double speed, int sensorValue) {
		Item item = new Item(Math.abs(speed), -1, sensorType.gyro, Math.abs(sensorValue), false);
		runAuto.addCommand(item);
	}

	public void backwardsWithEncoders(double speed, int sensorValue) {
		Item item = new Item(-Math.abs(speed), 0, sensorType.encoder, Math.abs(sensorValue));
		runAuto.addCommand(item);
	}

	public void stop(int time) {
		Item item = new Item(0, 0, sensorType.time, Math.abs(time));
		runAuto.addCommand(item);
	}
}