package org.usfirst.frc.team2212.robot.commands.commandGroups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGear;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickUpGearAndFold extends CommandGroup {

	public PickUpGearAndFold(Supplier<Double> rollSpeed, double rollWaitTime, Supplier<Double> foldSpeed) {
		addSequential(new RollGear(rollSpeed, rollWaitTime));
		addSequential(new MoveLimitedSubsystem(Robot.folder, foldSpeed));
	}
}
