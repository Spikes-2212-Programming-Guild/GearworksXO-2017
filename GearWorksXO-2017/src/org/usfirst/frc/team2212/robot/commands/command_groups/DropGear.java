package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {

	private double rollerSpeed, elevatorSpeed;

	public DropGear(double rollerSpeed, double elevatorSpeed) {
		this.rollerSpeed = rollerSpeed;
		this.elevatorSpeed = elevatorSpeed;

		// setting the roller gripper speed according to target
		addParallel(new MoveLimitedSubsystem(Robot.rollerGripper, rollerSpeed));

		// moving the elevator to the correct direction

		addSequential(new MoveLimitedSubsystem(Robot.elevator, elevatorSpeed));
	}

	@Override
	protected boolean isFinished() {
		return super.isFinished() || !Robot.elevator.canMove(elevatorSpeed);
	}
}