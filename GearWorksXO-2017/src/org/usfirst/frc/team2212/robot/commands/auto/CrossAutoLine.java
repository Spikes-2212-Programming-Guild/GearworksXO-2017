package org.usfirst.frc.team2212.robot.commands.auto;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossAutoLine extends CommandGroup {

	public static final Supplier<Double> CROSSING_SPEED = ConstantHandler
			.addConstantDouble("crossLineAuto - crossingSpeed", 0.7);
	public static final Supplier<Double> CROSSING_TIME = ConstantHandler
			.addConstantDouble("crossLineAuto - crossingTime", 2.7);

	public CrossAutoLine() {
		addSequential(new DriveArcade(Robot.drivetrain, CROSSING_SPEED, () -> 0.0), CROSSING_TIME.get());
	}

}
