package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

/**
 *
 */
public class RollGearToLightSensor extends MoveLimitedSubsystem {

	public RollGearToLightSensor(double speed) {
		super(Robot.rollerGripper, speed);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.rollerGripper.getSensorData();
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