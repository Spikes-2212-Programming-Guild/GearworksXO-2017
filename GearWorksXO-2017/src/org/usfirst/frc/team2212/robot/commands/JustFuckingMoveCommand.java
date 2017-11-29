package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JustFuckingMoveCommand extends Command {

	public JustFuckingMoveCommand() {
		requires(Robot.rollerGripper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.rollerGripper.justMove(RollerGripper.SPEED_IN.get());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.rollerGripper.justMove(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
