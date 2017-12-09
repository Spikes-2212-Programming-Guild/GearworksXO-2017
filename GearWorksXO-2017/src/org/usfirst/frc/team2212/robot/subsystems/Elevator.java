package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class Elevator extends LimitedSubsystem {

	// initializing subsystem constants

	public static final Supplier<Double> SPEED_UP = ConstantHandler.addConstantDouble("Elevator-SPEED-UP", 0.6);
	public static final Supplier<Double> SPEED_DOWN = ConstantHandler.addConstantDouble("Elevator-SPEED-DOWN", -0.6);

	// TODO: set constants to their real values
	public static final Supplier<Integer> MIDDLE_SET_POINT = ConstantHandler.addConstantInt("Elevator-MIDDLE_SET_POINT",
			0);
	public static final Supplier<Integer> HIGH_SET_POINT = ConstantHandler.addConstantInt("Elevator-HIGH_SET_POINT", 0);

	public static final Supplier<Integer> TOLERANCE = ConstantHandler.addConstantInt("Elevetor - Tolerance", 20);

	// defining subsystem motor
	private SpeedController motor;

	// defining sensors
	private DigitalInput upLimit;
	private DigitalInput downLimit;
	private Encoder encoder;

	public Elevator(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit, Encoder encoder) {
		this.motor = motor;
		this.downLimit = downLimit;
		this.upLimit = upLimit;
		this.encoder = encoder;
		this.motor.setInverted(true);
	}

	// overrides from limited subsystem

	@Override
	protected void move(double speed) {
		motor.set(speed);
	}

	@Override
	public boolean isMin() {
		boolean isMin = downLimit.get();
		if (isMin)
			this.resetEncoder();
		return isMin;
	}

	@Override
	public boolean isMax() {
		return upLimit.get();
	}

	@Override
	public PIDSource getPIDSource() {
		return encoder;
	}

	// encoder functions

	public void resetEncoder() {
		encoder.reset();
	}

	public int getPosition() {
		return this.encoder.get();
	}

	public boolean inTargetRange(int target) {
		return (Math.abs(target - Robot.elevator.getPosition()) <= TOLERANCE.get());
	}

	public void initDefaultCommand() {
	}
}
