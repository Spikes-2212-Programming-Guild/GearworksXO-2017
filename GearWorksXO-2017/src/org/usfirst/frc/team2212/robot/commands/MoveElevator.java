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
		super(Robot.elevator, (Robot.elevator.getPosition().getIndex() < target.getIndex()) ? Elevator.SPEED.get()
				: -Elevator.SPEED.get());
		this.target = target;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Math.abs(target.getIndex() - Robot.elevator.getPosition().getIndex()) <= tolerance.get())
				|| super.isFinished();
	}

}
