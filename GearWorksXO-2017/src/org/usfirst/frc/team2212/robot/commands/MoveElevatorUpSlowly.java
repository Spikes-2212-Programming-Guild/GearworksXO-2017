package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveElevatorUpSlowly extends Command {

	public MoveElevatorUpSlowly() {
		requires(Robot.elevator);
	}

	@Override
	protected void execute() {
		Robot.elevator.moveUpIgnoringLimit();
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.elevator.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
