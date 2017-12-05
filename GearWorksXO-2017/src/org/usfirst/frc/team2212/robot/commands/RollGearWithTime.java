package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollGearWithTime extends MoveLimitedSubsystem {

	public RollGearWithTime(double speed, double waitTime) {
		super(Robot.rollerGripper, speed);
		this.setTimeout(waitTime);
	}
	
	public RollGearWithTime(Supplier<Double> speed, double waitTime) {
		super(Robot.rollerGripper, speed);
		this.setTimeout(waitTime);
	}
}
