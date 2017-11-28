package org.usfirst.team2212.robot.commands;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class TakeGear extends MoveLimitedSubsystem {

	private double waitTime, lastTimeMin;

	public TakeGear(LimitedSubsystem limitedSubsystem, double speed, double waitTime) {
		super(limitedSubsystem, speed);
		this.waitTime = waitTime;
	}

	@Override
	protected boolean isFinished() {
		if (!super.isFinished()) {
			lastTimeMin = Timer.getFPGATimestamp();
		}
		return Timer.getFPGATimestamp() - lastTimeMin >= waitTime || isTimedOut();
	}

}