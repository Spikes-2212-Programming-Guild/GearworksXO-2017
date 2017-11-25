package org.usfirst.frc.team2212.commands;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.subsystems.Lift;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

/**
 *
 */
public class MoveLift extends MoveLimitedSubsystem {

	int target;

	public MoveLift(int target) {
		super(Robot.lift, (target > Robot.lift.getPosition()) ? Lift.SPEED.get() : -Lift.SPEED.get());
		this.target = target;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return super.isFinished() || (target == 1 && Robot.lift.liftEncoder.get() == Lift.MIDDLE.get());
	}

	// Called once after isFinished returns true
	protected void end() {
		super.end();
		Robot.lift.position = this.target;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
