package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class Folder extends LimitedSubsystem {

	// defining subsystem constants
	public static final Supplier<Double> SPEED_UP = ConstantHandler.addConstantDouble("Folder - UpSpeed", 0.8);
	/*
	 * SPEED_DOWN_A: the speed with which the folder needs to move just for the first 'pulse'
	 * SPEED_DOWN_B: the stable speed with which the folder needs to move down
	 */
	public static final Supplier<Double> SPEED_DOWN_A = ConstantHandler.addConstantDouble("Folder-DownSpeed-A", -0.4);
	public static final Supplier<Double> SPEED_DOWN_B = ConstantHandler.addConstantDouble("Folder-DownSpeed-B", -0.1);

	// subsystem variables
	private SpeedController motor;

	private DigitalInput downLimit;
	private DigitalInput upLimit;

	public Folder(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit) {
		this.motor = motor;
		this.downLimit = downLimit;
		this.upLimit = upLimit;
		this.motor.setInverted(true);
	}

	@Override
	protected void move(double speed) {
		this.motor.set(speed);
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
		return null;
	}

	public void initDefaultCommand() {
	}
}
