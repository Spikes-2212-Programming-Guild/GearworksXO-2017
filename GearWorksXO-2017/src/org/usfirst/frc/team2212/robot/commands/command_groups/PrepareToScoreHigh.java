package org.usfirst.frc.team2212.robot.commands.command_groups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearWithLimits;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareToScoreHigh extends CommandGroup {
	public static final Supplier<Double> ROLLER_SPEED_UP_TO_SENSOR_A = ConstantHandler
			.addConstantDouble("Gripper-prepare-to-score-high-speed-A", 0.7);

	public static final Supplier<Double> ROLLER_SPEED_UP_TO_SENSOR_B = ConstantHandler
			.addConstantDouble("Gripper-prepare-to-score-high-speed-B", 0.5);

	public PrepareToScoreHigh() {
		addSequential(new RollGearWithLimits(() -> !Robot.rollerGripper.getLowSensorData()
				? ROLLER_SPEED_UP_TO_SENSOR_A.get() : ROLLER_SPEED_UP_TO_SENSOR_B.get()));
		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP.get()));
	}
}
