package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class RollerGripper extends LimitedSubsystem {

	private SpeedController motor;
	private DigitalInput highSensor;
	private DigitalInput lowSensor;

	// TODO - check if sensor inverted
	public RollerGripper(SpeedController motor, DigitalInput upLimit, DigitalInput downLimit) {
		this.motor = motor;
		this.highSensor = upLimit;
		this.lowSensor = downLimit;

		// inverting motor
		motor.setInverted(true);
	}

	public void move(double speed) {
		motor.set(speed);
	}

	public boolean getHighSensorData() {
		return highSensor.get();
	}

	public boolean getLowSensorData() {
		return !lowSensor.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public boolean isMin() {
		return false;
	}

	@Override
	public boolean isMax() {
		return false;
	}

	@Override
	public PIDSource getPIDSource() {
		return null;
	}
}
