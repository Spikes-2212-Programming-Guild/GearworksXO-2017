package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Timer;

public class MoveFolder extends MoveLimitedSubsystem {
	
	private double lastTimeNotOnTarget;
	private double waitTime;
	private boolean up;

	public MoveFolder(Supplier<Double> speed, double waitTime) {
		super(Robot.folder, speed);
		up = speed.get()>0;
		this.waitTime = waitTime;
	}
	
	@Override
	public boolean isFinished(){
		if((!Robot.folder.isMax() && up) || (!Robot.folder.isMin()&& !up))
			lastTimeNotOnTarget = Timer.getFPGATimestamp();
		return super.isFinished() && (Timer.getFPGATimestamp() - lastTimeNotOnTarget >= waitTime);
	}
}