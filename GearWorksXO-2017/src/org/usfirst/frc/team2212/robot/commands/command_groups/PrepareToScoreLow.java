package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearWithLimits;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareToScoreLow extends CommandGroup {
	public PrepareToScoreLow() {
		addSequential(new RollGearWithLimits(RollerGripper.SPEED_OUT_LOW_PEG));
		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN.get()));
	}
}
