package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Timer;

public class LiftUpFolder extends MoveLimitedSubsystem {
	
	private double lastTimeNotOnTarget;
	private double waitTime;

	public LiftUpFolder(double speed, double waitTime) {
		super(Robot.folder, speed);
		this.waitTime = waitTime;
	}
	
	@Override
	public boolean isFinished(){
		if(!Robot.folder.isMax())
			lastTimeNotOnTarget = Timer.getFPGATimestamp();
		return super.isFinished() && (Timer.getFPGATimestamp() - lastTimeNotOnTarget >= waitTime);
	}
}