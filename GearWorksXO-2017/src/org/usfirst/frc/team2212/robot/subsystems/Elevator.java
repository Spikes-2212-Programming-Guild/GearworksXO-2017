package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

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
	public static final Supplier<Integer> MIDDLE_SET_POINT = ConstantHandler.addConstantInt("lift-MIDDLE_SET_POINT",
			50);
	public static final Supplier<Integer> HIGH_SET_POINT = ConstantHandler.addConstantInt("lift-MIDDLE_SET_POINT", 100);

	// public enum ElevatorState {
	// LOW_LIMIT(0), MIDDLE(MIDDLE_SET_POINT.get()),
	// HIGH_LIMIT(HIGH_SET_POINT.get());
	//
	// private int position;
	//
	// ElevatorState(int position) {
	// this.position = position;
	// }
	//
	// public int getPosition() {
	// return position;
	// }
	// }

	public Elevator(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit, Encoder encoder) {
		this.motor = motor;
		this.downLimit = downLimit;
		this.upLimit = upLimit;
		this.encoder = encoder;
		this.motor.setInverted(true);
	}

	// public ElevatorState getState() {
	// // The subsystem is in its upper limit
	// if (upLimit.get())
	// return ElevatorState.HIGH_LIMIT;
	// // The subsystem is in its lower limit
	// if (downLimit.get())
	// return ElevatorState.LOW_LIMIT;
	// // The subsystem is in the middle ( the height of the lower gear )
	//
	// if (Elevator.MIDDLE_SET_POINT.get() == this.encoder.get())
	// return ElevatorState.MIDDLE;
	// // The subsystem is between the middle and the lower limit
	//
	// }

	public void resetEncoder() {
		encoder.reset();
	}

	@Override
	public boolean isMin() {
		if (!downLimit.get())
			Robot.elevator.resetEncoder();
		return !downLimit.get();
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

	public int getPosition() {
		return encoder.get();
	}

	public void initDefaultCommand() {
	}

}
