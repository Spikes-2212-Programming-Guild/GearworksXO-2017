package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveFolder;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickGear extends CommandGroup {
	// todo - make it take the gear until it hits the physical robot and move folder up
	// only if the gear is in the system
	public PickGear() {
		addSequential(new MoveLimitedSubsystem(Robot.rollerGripper, RollerGripper.SPEED_IN));
		addSequential(new MoveFolder(Folder.SPEED_UP, Folder.WAIT_TIME.get()));
	}
}
