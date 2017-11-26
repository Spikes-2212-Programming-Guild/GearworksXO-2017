package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class GearPicker extends LimitedSubsystem {

	private SpeedController motor;
	private DigitalInput downLimit;
	private DigitalInput upLimit;
	private Encoder encoder;
	//private AnalogPotentiometer potentiometer;

	public GearPicker(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit, Encoder encoder
					  /*, AnalogPotentiometer potentiometer */) {
		this.motor = motor;
		this.upLimit = downLimit;
		this.downLimit = upLimit;
		this.encoder = encoder;
		/* this.potentiometer = potentiometer; */
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
		/* return potentiometer; */
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
