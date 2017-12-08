package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearWithTime;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareToScoreLow extends CommandGroup {
	public PrepareToScoreLow() {
		addSequential(new RollGearWithTime(-0.5, 1));
		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN.get()));
	}
}
