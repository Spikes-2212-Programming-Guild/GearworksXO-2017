package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

/**
 *
 */
public class MoveElevator extends MoveLimitedSubsystem {

	private ElevatorState target;
	public static final Supplier<Integer> TOLERANCE = ConstantHandler.addConstantInt("Elevetor - Tolerance", 10);

	public MoveElevator(ElevatorState target) {
		super(Robot.elevator, (Robot.elevator.getState().getIndex() < target.getIndex()) ? Elevator.SPEED.get()
				: -Elevator.SPEED.get());
		this.target = target;
	}

	protected boolean isFinished() {
		return (Math.abs(target.getIndex() - Robot.elevator.getState().getIndex()) <= TOLERANCE.get())
				|| super.isFinished();
	}

	@Override
	protected void end() {
		if (Robot.elevator.getState().getIndex() == ElevatorState.LOW_LIMIT.getIndex())
			Robot.elevator.resetEncoder();
		super.end();
	}

}
