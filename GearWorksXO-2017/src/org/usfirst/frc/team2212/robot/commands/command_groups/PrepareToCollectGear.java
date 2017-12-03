package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearToLightSensor;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareToCollectGear extends CommandGroup {

	public PrepareToCollectGear() {
		// lift folder
		addSequential(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));
		// lower elevetor
		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN));

		// lower folder

		/*
		 * if the folder is in it's maximum limit, the supplier will return a larger
		 * value to push the subsystem. otherwise, it will use SPEED_DOWN_B- the
		 * smaller, more stable speed
		 */
		addSequential(new MoveLimitedSubsystem(Robot.folder,
				Robot.folder.isMax() ? Folder.SPEED_DOWN_A : Folder.SPEED_DOWN_B));
	}
}
