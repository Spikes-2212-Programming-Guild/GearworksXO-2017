package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * @author Itamar Rivkind
 *
 */

public class Elevator extends LimitedSubsystem {

	private SpeedController motor;
	private DigitalInput upLimit;
	private DigitalInput downLimit;
	private Encoder encoder;
	public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("Lift-SPEED", 0.7);
	public static final Supplier<Integer> MIDDLE_SET_POINT = ConstantHandler.addConstantInt("lift-MIDDLE_SET_POINT", 0);

	public enum ElevatorState {
		LOW_LIMIT(0), LOW_TO_MIDDLE(1), MIDDLE(2), MIDDLE_TO_HIGH(3), HIGH_LIMIT(4);

		private int index;

		ElevatorState(int index) {
			this.index = index;
		}

		public int getIndex() {
			return index;
		}
	}

	public Elevator(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit, Encoder encoder) {
		this.motor = motor;
		this.downLimit = downLimit;
		this.upLimit = upLimit;
		this.encoder = encoder;
		this.motor.setInverted(true);
	}

	public ElevatorState getState() {
		// The subsystem is in its upper limit
		if (upLimit.get())
			return ElevatorState.HIGH_LIMIT;
		// The subsystem is in its lower limit
		if (downLimit.get())
			return ElevatorState.LOW_LIMIT;
		// The subsystem is in the middle ( the height of the lower gear )
		if (Elevator.MIDDLE_SET_POINT.get() == this.encoder.get())
			return ElevatorState.MIDDLE;
		// The subsystem is between the middle and the lower limit
		if (this.encoder.get() < Elevator.MIDDLE_SET_POINT.get())
			return ElevatorState.LOW_TO_MIDDLE;
		// The subsystem is between the middle and higher limit
		return ElevatorState.MIDDLE_TO_HIGH;
	}

	public void resetEncoder() {
		encoder.reset();
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
		motor.set(speed);
	}

	public void initDefaultCommand() {
	}
}