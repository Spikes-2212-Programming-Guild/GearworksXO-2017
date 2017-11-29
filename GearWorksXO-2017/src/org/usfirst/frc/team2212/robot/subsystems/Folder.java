package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Folder extends LimitedSubsystem {

	// subsystem constants
	// TODO - Change constant values to actual potentiometer values
	public static final Supplier<Double> INITIAL_MID_ANGLE = ConstantHandler.addConstantDouble("Folder - Mid", 45);
	public static final Supplier<Double> STARTING_ANGLE = ConstantHandler.addConstantDouble("Folder - starting angle",
			0);
	public static final Supplier<Double> SPEED_UP = ConstantHandler.addConstantDouble("Folder - speed", 0.5);
	public static final Supplier<Double> SPEED_DOWN = ConstantHandler.addConstantDouble("Folder - speed", -0.1);

	private double actualMidAngle;

	// subsystem variables
	private SpeedController motor;
	private DigitalInput downLimit;
	private DigitalInput upLimit;
	private AnalogPotentiometer potentiometer;

	// folder PID constants
	public static final Supplier<Double> KP = ConstantHandler.addConstantDouble("Folder KP", 1.2);
	public static final Supplier<Double> KI = ConstantHandler.addConstantDouble("Folder KI", 5);
	public static final Supplier<Double> KD = ConstantHandler.addConstantDouble("Folder KD", 0.05);
	public static final Supplier<Double> TOLERANCE = ConstantHandler.addConstantDouble("Folder Tolerance", 0.05);

	// TODO - check if motor is inverted
	public Folder(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit,
			AnalogPotentiometer potentiometer) {
		this.motor = motor;
		this.downLimit = downLimit;
		this.upLimit = upLimit;
		this.potentiometer = potentiometer;
		this.motor.setInverted(true);
		actualMidAngle = INITIAL_MID_ANGLE.get();
	}

	@Override
	public boolean isMin() {
		if (downLimit.get()) {
			actualMidAngle = INITIAL_MID_ANGLE.get() + (potentiometer.get() - STARTING_ANGLE.get());
			return true;
		}
		return false;
	}

	@Override
	public boolean isMax() {
		return upLimit.get();
	}

	@Override
	public PIDSource getPIDSource() {
		return potentiometer;
	}

	@Override
	protected void move(double speed) {
		this.motor.set(speed);
	}

	public void initDefaultCommand() {
	}

	public double getMidAngle() {
		return actualMidAngle;
	}
}