package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class GearPicker extends LimitedSubsystem {

	private SpeedController motor;
	private DigitalInput downLimit;
	private DigitalInput upLimit;
	private Encoder encoder;


	public GearPicker(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit, Encoder encoder) {
		this.motor = motor;
		this.upLimit = downLimit;
		this.downLimit = upLimit;
		this.encoder = encoder;
	}

	@Override
	public boolean isMin() {
		return downLimit.get();
	}

	@Override
	public boolean isMax() {
		return upLimit.get();
	}

	@Override
	public PIDSource getPIDSource() {
		return encoder;
	}

	@Override
	protected void move(double speed) {
		this.motor.set(speed);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
