package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class PickGearToHigh extends MoveLimitedSubsystem{

	public PickGearToHigh(Supplier<Double> speedSupplier) {
		super(Robot.rollerGripper, speedSupplier);
	}

	@Override
	protected boolean isFinished() {
		return Robot.rollerGripper.getHighSensorData();
	}
}
