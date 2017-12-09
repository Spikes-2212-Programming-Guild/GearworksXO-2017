package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class RollerGripper extends LimitedSubsystem {

	// defining subsystem constants
	public static final Supplier<Double> SPEED_IN = ConstantHandler.addConstantDouble("Gripper-speed-in", -0.5);
	/*
	 * SPEED_OUT_HIGH_PEG: the speed of the subsystem when it releases the gear up,
	 * to the high peg SPEED_OUT_LOW_PEG: the speed of the subsystem when it
	 * releases the gear down, to the low gear
	 */
	public static final Supplier<Double> SPEED_UP_TO_SENSOR = ConstantHandler
			.addConstantDouble("Gripper-speed-up-to-sensor", 0.5);
	public static final Supplier<Double> SPEED_OUT_HIGH_PEG = ConstantHandler
			.addConstantDouble("Gripper-speed-out-high-peg", 0.7);
	public static final Supplier<Double> SPEED_OUT_LOW_PEG = ConstantHandler
			.addConstantDouble("Gripper-speed-out-low-peg", -0.5);

	// the wait time for roller-gripper drop-gear commands
	public static final Supplier<Double> WAIT_TIME_DROP = ConstantHandler.addConstantDouble("Gripper - wait time drop",
			1);
	public static final Supplier<Double> WAIT_TIME_PICK = ConstantHandler.addConstantDouble("Gripper - wait time pick",
			0.5);

	private SpeedController motor;
	private DigitalInput upLimit;
	private DigitalInput downLimit;

	// TODO - check if sensor inverted
	public RollerGripper(SpeedController motor, DigitalInput upLimit, DigitalInput downLimit) {
		this.motor = motor;
		this.upLimit = upLimit;
		this.downLimit = downLimit;

		// inverting motor
		motor.setInverted(true);
	}

	public void move(double speed) {
		motor.set(speed);
	}

	// TODO rename these methods
	public boolean getHighData() {
		return upLimit.get();
	}

	public boolean getLowData() {
		return downLimit.get();
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
