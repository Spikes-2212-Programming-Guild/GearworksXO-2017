package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;
import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;
import com.spikes2212.utils.RunnableCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A {@link CommandGroup} which rotates the drivetrain to the middle of the low
 * peg in a given rotateSpeed and moves it forward in a given forwardSpeed
 *
 */
public class TurnAndMoveToGearLow extends CommandGroup {

	public static final Supplier<Double> LOW_GEAR_CAM_ID = ConstantHandler.addConstantDouble("HighGear-Camera_ID", 1);

	public TurnAndMoveToGearLow(Supplier<Double> rotateSpeedSupplier, Supplier<Double> forwardSpeedSupplier) {
		addSequential(new RunnableCommand(
				() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera", LOW_GEAR_CAM_ID.get())));
		addSequential(new TurnToTwoTargets(rotateSpeedSupplier));
		addSequential(new DriveArcade(Robot.drivetrain, forwardSpeedSupplier, () -> 0.0));
	}
}
