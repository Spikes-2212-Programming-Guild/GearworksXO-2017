package org.usfirst.frc.team2212.robot.commands.command_groups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {

	private double rollerSpeed, elevatorSpeed;

	public static final Supplier<Double> ROLLER_SPEED_OUT_HIGH_PEG = ConstantHandler
			.addConstantDouble("Gripper-speed-out-high-peg", 0.5);
	public static final Supplier<Double> ROLLER_SPEED_OUT_LOW_PEG = ConstantHandler
			.addConstantDouble("Gripper-speed-out-low-peg", -0.7);

	public DropGear() {

		// setting the roller gripper speed according to target
		addParallel(new MoveLimitedSubsystem(Robot.rollerGripper, () -> rollerSpeed));

		// moving the elevator to the correct direction

		addSequential(new MoveLimitedSubsystem(Robot.elevator, () -> elevatorSpeed));
	}

	@Override
	protected void initialize() {
		super.initialize();
		if (Robot.elevator.isMin()) {
			this.rollerSpeed = ROLLER_SPEED_OUT_LOW_PEG.get();
			this.elevatorSpeed = Elevator.SPEED_UP.get();
		} else {
			this.rollerSpeed = ROLLER_SPEED_OUT_HIGH_PEG.get();
			this.elevatorSpeed = Elevator.SPEED_DOWN.get();
		}
	}

	@Override
	protected boolean isFinished() {
		return super.isFinished() || !Robot.elevator.canMove(elevatorSpeed);
	}
}