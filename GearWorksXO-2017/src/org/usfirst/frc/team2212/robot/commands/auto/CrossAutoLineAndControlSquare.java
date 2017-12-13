package org.usfirst.frc.team2212.robot.commands.auto;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossAutoLineAndControlSquare extends CommandGroup {

	public static final Supplier<Double> BACKING_SPEED = ConstantHandler
			.addConstantDouble("crossLineAutoAndControlSquare - backingSpeed", 0.4);
	public static final Supplier<Double> BACKING_TIME = ConstantHandler
			.addConstantDouble("crossLineAutoAndControlSquare - backingTime", 3);

	public CrossAutoLineAndControlSquare() {
		addSequential(new CrossAutoLine());
		addSequential(new DriveArcade(Robot.drivetrain, BACKING_SPEED, () -> 0.0), BACKING_TIME.get());
	}
}