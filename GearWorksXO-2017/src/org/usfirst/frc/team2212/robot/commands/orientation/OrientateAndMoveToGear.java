package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OrientateAndMoveToGear extends CommandGroup {

	public static final Supplier<Double> TOLERANCE = ConstantHandler.addConstantDouble("orientation-TOLERANCE", 0.05);

	public OrientateAndMoveToGear(Supplier<Double> turningSpeed, Supplier<Double> forwardsSpeed) {
		addSequential(new OrientToTwoTargets(turningSpeed));
		addSequential(new DriveArcade(Robot.drivetrain, forwardsSpeed, () -> 0.0));
	}
}