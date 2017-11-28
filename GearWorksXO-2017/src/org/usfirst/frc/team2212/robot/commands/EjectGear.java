package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

/**
 *
 */
public class EjectGear extends MoveLimitedSubsystem {

	private double mySpeed;

	public EjectGear(double speed) {
		super(Robot.rollerGripper, speed);
		mySpeed = speed;
	}

	@Override
	protected void execute() {
		Robot.rollerGripper.justMove(mySpeed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
