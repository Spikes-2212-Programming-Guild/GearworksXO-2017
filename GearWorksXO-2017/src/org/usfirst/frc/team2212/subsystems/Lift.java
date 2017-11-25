package org.usfirst.frc.team2212.subsystems;

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

public class Lift extends LimitedSubsystem {

	private SpeedController motor;
	private DigitalInput upLimit;
	private DigitalInput downLimit;
	private Encoder encoder;
	public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("Lift-SPEED", 0.7);
	public static /* final */ Supplier<Integer> MIDDLE; // place in encoder for
														// putting lower gear

	public Lift(SpeedController motor, DigitalInput upLimit, DigitalInput downLimit, Encoder encoder) {
		this.motor = motor;
		this.upLimit = upLimit;
		this.downLimit = downLimit;
		this.encoder = encoder;
	}

	public LiftPosition getPosition() {
		if (upLimit.get()) // The subsystem is in its upper limit
			return LiftPosition.HIGH_LIMIT;
		if (downLimit.get()) // The subsystem is in its lower limit
			return LiftPosition.LOW_LIMIT;
		if (Lift.MIDDLE.get() == this.encoder.get()) // The subsystem is in the
														// middle ( the height of
														// the lower gear )
			return LiftPosition.MIDDLE;
		if (this.encoder.get() < Lift.MIDDLE.get()) // The subsystem is between the middle and the lower limit
			return LiftPosition.LOW;
		return LiftPosition.HIGH; // The subsystem is between the middle and higher limit
	}

	public enum LiftPosition {
		LOW_LIMIT(0), LOW(1), MIDDLE(2), HIGH(3), HIGH_LIMIT(4);

		public int index;

		LiftPosition(int index) {
			this.index = index;
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
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
		// TODO Auto-generated method stub
		motor.set(speed);
	}
}
