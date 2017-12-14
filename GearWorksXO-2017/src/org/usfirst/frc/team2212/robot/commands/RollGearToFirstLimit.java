package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class RollGearToFirstLimit extends MoveLimitedSubsystem{

	public RollGearToFirstLimit (double speed) {
		super(Robot.rollerGripper, speed);
	}
	
	public RollGearToFirstLimit (Supplier<Double> speed) {
		super(Robot.rollerGripper, speed);
	}
	
	@Override
	protected boolean isFinished(){
		return Robot.rollerGripper.getHighSensorData();
	}

}
