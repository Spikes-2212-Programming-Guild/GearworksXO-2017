package org.usfirst.frc.team2212.robot.commands.command_groups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveLimitedSubsystemWithTimeSinceReachingLimit;
import org.usfirst.frc.team2212.robot.commands.PickGearToHigh;
import org.usfirst.frc.team2212.robot.commands.RollGearWithLimits;
import org.usfirst.frc.team2212.robot.subsystems.Folder;

import com.spikes2212.dashboard.ConstantHandler;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickGear extends CommandGroup {
	public static final Supplier<Double> ROLLER_SPEED_IN = ConstantHandler.addConstantDouble("Gripper-pick-speed", -1);

	public PickGear() {
		addSequential(new PickGearToHigh(ROLLER_SPEED_IN));
		addSequential(new MoveLimitedSubsystemWithTimeSinceReachingLimit(Robot.folder, Folder.SPEED_UP,
				Folder.WAIT_TIME.get()));
	}
}
