package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;
import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;
import com.spikes2212.utils.RunnableCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A {link {@link CommandGroup} which supposed to TurnAndMoveToGear, both the
 * high and the low
 *
 */
public class TurnAndMoveToGear extends CommandGroup {

	// TODO - if it works, remove specific classes for high and low gears, and
	// move the cameras values to here
	public TurnAndMoveToGear(Supplier<Double> rotateSpeedSupplier, Supplier<Double> forwardSpeedSupplier) {
		addSequential(new RunnableCommand(
				() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera", Robot.elevator.isMax()
						? TurnAndMoveToGearHigh.HIGH_GEAR_CAM_ID.get() : TurnAndMoveToGearLow.LOW_GEAR_CAM_ID.get())));
		addSequential(new TurnToTwoTargets(rotateSpeedSupplier));
		addSequential(new DriveArcade(Robot.drivetrain, forwardSpeedSupplier, () -> 0.0));
	}
}
