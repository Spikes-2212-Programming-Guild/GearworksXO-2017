package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Timer;

public class MoveLimitedSubsystemWithTimeSinceReachingLimit extends MoveLimitedSubsystem {

	private double lastTimeNotOnTarget;
	private double waitTime;

	public MoveLimitedSubsystemWithTimeSinceReachingLimit(LimitedSubsystem subsystem, Supplier<Double> speed, double waitTime) {
		super(subsystem, speed);
		this.waitTime = waitTime;
	}

	@Override
	protected boolean isFinished() {
		double currentTime = Timer.getFPGATimestamp();
		if (!super.isFinished()) {
			lastTimeNotOnTarget = currentTime;
		}
		if (currentTime - lastTimeNotOnTarget > waitTime) {
			return true;
		}
		return false;
	}

}
