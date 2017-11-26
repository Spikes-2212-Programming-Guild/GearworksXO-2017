package org.usfirst.frc.team2212.commands;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.subsystems.Lift;
import org.usfirst.frc.team2212.subsystems.Lift.LiftState;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

/**
 *
 */
public class MoveLift extends MoveLimitedSubsystem {

	private LiftState target;

	public MoveLift(LiftState target) {
		super(Robot.lift, (Robot.lift.getPosition().index < target.index) ? Lift.SPEED.get() : -Lift.SPEED.get());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (target.index == Robot.lift.getPosition().index);
	}

}
