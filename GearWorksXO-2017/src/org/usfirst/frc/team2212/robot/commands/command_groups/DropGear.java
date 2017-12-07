package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {

	private double rollerSpeed, elevatorSpeed;

	public DropGear() {

		// setting the roller gripper speed according to target
		addParallel(new MoveLimitedSubsystem(Robot.rollerGripper, () -> rollerSpeed));

		// moving the elevator to the correct direction

		addSequential(new MoveLimitedSubsystem(Robot.elevator, () -> elevatorSpeed));
	}

	@Override
	protected void initialize() {
		super.initialize();
		if (Robot.elevator.isMax()) {
			this.rollerSpeed = RollerGripper.SPEED_OUT_HIGH_PEG.get();
			this.elevatorSpeed = Elevator.SPEED_DOWN.get();
		} else {
			this.rollerSpeed = RollerGripper.SPEED_OUT_LOW_PEG.get();
			this.elevatorSpeed = Elevator.SPEED_UP.get();
		}
	}

	@Override
	protected boolean isFinished() {
		return super.isFinished() || !Robot.elevator.canMove(elevatorSpeed);
	}
}