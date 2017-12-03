package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollerGripper extends LimitedSubsystem {

	// defining subsystem constants
	public static final Supplier<Double> SPEED_IN = ConstantHandler.addConstantDouble("Gripper-speed-in", -0.7);
	/*
	 * SPEED_OUT_HIGH_PEG: the speed of the subsystem when it releases the gear up,
	 * to the high peg
	 * SPEED_OUT_LOW_PEG: the speed of the subsystem when it
	 * releases the gear down, to the low gear
	 */
	public static final Supplier<Double> SPEED_OUT_HIGH_PEG = ConstantHandler
			.addConstantDouble("Gripper-speed-out-high-peg", 0.7);
	public static final Supplier<Double> SPEED_OUT_LOW_PEG = ConstantHandler
			.addConstantDouble("Gripper-speed-out-low-peg", -0.5);

	// the wait time for roller-gripper drop-gear commands
	public static final Supplier<Double> WAIT_TIME_DROP = ConstantHandler.addConstantDouble("Gripper - wait time drop",
			0);

	private SpeedController motor;
	private DigitalInput sensor;

	// TODO - check if sensor inverted
	public RollerGripper(SpeedController motor, DigitalInput sensor) {
		this.motor = motor;
		this.sensor = sensor;

		// inverting motor
		motor.setInverted(true);
	}

	public void move(double speed) {
		motor.set(speed);
	}

	public boolean getSensorData() {
		return sensor.get();
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
