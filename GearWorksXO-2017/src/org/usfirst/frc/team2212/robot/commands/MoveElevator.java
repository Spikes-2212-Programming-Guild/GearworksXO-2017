package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

/**
 *
 */
public class MoveElevator extends MoveLimitedSubsystem {

	private int target;

	public static final Supplier<Integer> TOLERANCE = ConstantHandler.addConstantInt("Elevetor - Tolerance", 20);

	public MoveElevator(int target) {
		super(Robot.elevator, (Robot.elevator.getPosition() < target ? Elevator.SPEED.get() : -Elevator.SPEED.get()));
		this.target = target;
	}

	protected boolean isFinished() {
		return (Math.abs(target - Robot.elevator.getPosition()) <= TOLERANCE.get()) || super.isFinished();
		// return super.isFinished();
	}

}
