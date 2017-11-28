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

	// TODO - Change constant values to actual potentiometer values
	public static final Supplier<Double> MID = ConstantHandler.addConstantDouble("Folder - Mid", 45);
	private SpeedController motor;
	private DigitalInput downLimit;
	private DigitalInput upLimit;
	private AnalogPotentiometer potentiometer;

	//TODO - check if motor is inverted
	public Folder(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit,
					   AnalogPotentiometer potentiometer) {
		this.motor = motor;
		this.downLimit = downLimit;
		this.upLimit = upLimit;
		this.potentiometer = potentiometer;
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
		return potentiometer;
	}

	@Override
	protected void move(double speed) {
		this.motor.set(speed);
	}

	public void initDefaultCommand() {
	}
}
