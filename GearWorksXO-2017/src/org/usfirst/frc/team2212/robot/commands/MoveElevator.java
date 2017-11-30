package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class MoveElevator extends MoveLimitedSubsystem {

	//TODO - find correct tolerance
	private int target;

	public MoveElevator(int target) {
		super(Robot.elevator,
				(Robot.elevator.getPosition() < target) ? Elevator.SPEED_UP.get() : Elevator.SPEED_DOWN.get());
		this.target = target;
	}

	protected boolean isFinished() {
		return Robot.elevator.inTargetRange(target)|| super.isFinished();
	}
}
