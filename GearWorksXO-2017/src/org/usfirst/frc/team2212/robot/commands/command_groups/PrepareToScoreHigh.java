package org.usfirst.frc.team2212.robot.commands.command_groups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearWithLimits;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareToScoreHigh extends CommandGroup {
	public static final Supplier<Double> ROLLER_MOVE_GEAR_UP_SPEED = ConstantHandler
			.addConstantDouble("Gripper-prepare-to-score-high-speed", 0.7);

	public PrepareToScoreHigh() {
		addSequential(new RollGearWithLimits(ROLLER_MOVE_GEAR_UP_SPEED));
		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP.get()));
	}
}
