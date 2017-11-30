package org.usfirst.frc.team2212.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollGearOut extends Command {

	private double speed, waitTime,startTime;
	//TODO - use setTimeout after motorola
	public RollGearOut(double speed, double waitTime) {
		requires(Robot.rollerGripper);
		this.speed = speed;
		this.waitTime = waitTime;
		//this.setTimeout(waitTime);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.startTime= Timer.getFPGATimestamp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.rollerGripper.move(speed);
	}

	@Override
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() - startTime >= waitTime;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.rollerGripper.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
