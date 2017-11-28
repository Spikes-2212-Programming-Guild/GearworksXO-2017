package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class RollGear extends MoveLimitedSubsystem {

	private double waitTime, lastTimeMin;

	public RollGear(double speed, double waitTime) {
		super(Robot.rollerGripper, speed);
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
