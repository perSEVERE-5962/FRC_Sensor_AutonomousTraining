package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.JoystickThrottle;

import edu.wpi.first.wpilibj.command.Command;

public class RunJoystickTank extends Command {

	public void RunGameTank() {
		requires(Robot.drive);
	}

	protected void initialize() {

	}

	protected void execute() {
		Robot.drive.joystickTank();
		JoystickThrottle.Speed();
	}

	protected boolean isFinished() {
		return Robot.oi.joystickTankMode.get();
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}