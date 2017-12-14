package org.usfirst.frc.team2212.robot.commands.auto;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveLimitedSubsystemWithTimeSinceReachingLimit;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * initialize the robot's subsystems
 *
 */
public class StartingPreparation extends CommandGroup {

	public StartingPreparation() {
		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN));
	}

}
