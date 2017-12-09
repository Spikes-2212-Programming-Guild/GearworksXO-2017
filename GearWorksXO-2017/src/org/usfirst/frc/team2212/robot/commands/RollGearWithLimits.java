package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class RollGearWithLimits extends MoveLimitedSubsystem {

	private boolean goingUp;

	// positive speed moves the gear up
	public RollGearWithLimits(Supplier<Double> speed) {
		super(Robot.rollerGripper, speed);
		this.goingUp = speed.get() > 0;
	}

	protected boolean isFinished() {
		return super.isFinished() || (goingUp && !Robot.rollerGripper.getHighSensorData())
				|| (!goingUp && Robot.rollerGripper.getLowSensorData());
	}
}
