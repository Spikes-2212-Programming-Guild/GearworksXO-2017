package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveLimitedSubsystemWithTimeSinceReachingLimit;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickGear extends CommandGroup {
	// todo - make it take the gear until it hits the physical robot and move
	// folder up
	// only if the gear is in the system
	public PickGear() {
		addSequential(new MoveLimitedSubsystemWithTimeSinceReachingLimit(Robot.rollerGripper, RollerGripper.SPEED_IN,
				RollerGripper.WAIT_TIME_PICK.get()));
		addSequential(new MoveLimitedSubsystemWithTimeSinceReachingLimit(Robot.folder, Folder.SPEED_UP, Folder.WAIT_TIME.get()));
	}
}
