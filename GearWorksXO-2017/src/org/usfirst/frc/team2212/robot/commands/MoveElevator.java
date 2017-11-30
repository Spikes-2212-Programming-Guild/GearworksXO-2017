package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class MoveElevator extends MoveLimitedSubsystem {

	public static final Supplier<Integer> TOLERANCE = ConstantHandler.addConstantInt("Elevetor - Tolerance", 10);
	private int target;

	public MoveElevator(int target) {
		super(Robot.elevator,
				(Robot.elevator.getPosition() < target) ? Elevator.SPEED_UP.get() : Elevator.SPEED_DOWN.get());
		this.target = target;
	}

	protected boolean isFinished() {
		return (Math.abs(target - Robot.elevator.getPosition()) <= TOLERANCE.get()) || super.isFinished();
	}

	@Override
	protected void end() {
		super.end();
	}

	protected void interrupted() {
		end();
	}

}
