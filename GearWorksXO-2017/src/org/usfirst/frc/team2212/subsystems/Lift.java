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
	public static final Supplier<Integer> MIDDLE_SET_POINT = ConstantHandler.addConstantInt("lift-MIDDLE_SET_POINT", 0); // place
																															// in
																															// encoder
																															// for
	// putting lower gear

	public enum LiftState {
		LOW_LIMIT(0), LOW_TO_MIDDLE(1), MIDDLE(2), MIDDLE_TO_HIGH(3), HIGH_LIMIT(4);

		public int index;

		LiftState(int index) {
			this.index = index;
		}
	}

	public Lift(SpeedController motor, DigitalInput upLimit, DigitalInput downLimit, Encoder encoder) {
		this.motor = motor;
		this.upLimit = upLimit;
		this.downLimit = downLimit;
		this.encoder = encoder;
	}

	public LiftState getPosition() {
		// The subsystem is in its upper limit
		if (upLimit.get())
			return LiftState.HIGH_LIMIT;
		// The subsystem is in its lower limit
		if (downLimit.get())
			return LiftState.LOW_LIMIT;
		// The subsystem is in the middle ( the height of the lower gear )
		if (Lift.MIDDLE_SET_POINT.get() == this.encoder.get())
			return LiftState.MIDDLE;
		// The subsystem is between the middle and the lower limit
		if (this.encoder.get() < Lift.MIDDLE_SET_POINT.get())
			return LiftState.LOW_TO_MIDDLE;
		// The subsystem is between the middle and higher limit
		return LiftState.MIDDLE_TO_HIGH;
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
