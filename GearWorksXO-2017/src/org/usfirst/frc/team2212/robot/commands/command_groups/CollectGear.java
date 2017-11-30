package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearIn;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CollectGear extends CommandGroup {

	public CollectGear() {
		// lifting folder
		addSequential(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));

		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN));

		// collecting the gear

		/*
		 * if the folder is still in it's maximum, the supplier will return a larger
		 * value to push the subsystem. otherwise, it will use SPEED_DOWN_B- the
		 * smaller, more stable speed
		 */
		addSequential(new MoveLimitedSubsystem(Robot.folder,
				Robot.folder.isMax() ? Folder.SPEED_DOWN_A : Folder.SPEED_DOWN_B));

		addSequential(new RollGearIn(RollerGripper.SPEED_IN.get()));

	}
}