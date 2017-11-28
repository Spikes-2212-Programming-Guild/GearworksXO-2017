package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class RollerGripper extends LimitedSubsystem {

	public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("Gripper - speed", 0.5);
	private SpeedController motor;
	private DigitalInput sensor;

	// TODO - check if motor inverted
	// TODO - check if sensor inverted
	public RollerGripper(SpeedController motor, DigitalInput sensor) {
		this.motor = motor;
		this.sensor = sensor;
	}

	@Override
	public boolean isMax() {
		return false;
	}

	@Override
	public boolean isMin() {
		return sensor.get();
	}

	@Override
	public PIDSource getPIDSource() {
		return null;
	}
	
	public void justMove(double speed) {
		this.move(speed);
	}
	
	@Override
	protected void move(double speed) {
		motor.set(speed);
	}

}
