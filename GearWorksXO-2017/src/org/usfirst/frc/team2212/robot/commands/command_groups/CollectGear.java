package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGearIn;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CollectGear extends CommandGroup {

	public CollectGear() {

		addParallel(new MoveElevator(ElevatorState.LOW_LIMIT));
		addSequential(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_DOWN));
		addSequential(new RollGearIn(RollerGripper.SPEED_IN.get()));
	}
}
