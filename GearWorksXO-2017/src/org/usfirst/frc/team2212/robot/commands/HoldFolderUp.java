package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class HoldFolderUp extends MoveLimitedSubsystem {

	public HoldFolderUp(LimitedSubsystem subsystem, Supplier<Double> speed) {
		super(subsystem, speed);
	}

	@Override
	protected void execute() {
		if (!(Robot.folder.isMax()||Robot.folder.isMin()))
			super.execute();
		else
			Robot.folder.stop();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
