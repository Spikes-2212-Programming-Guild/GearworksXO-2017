package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;
import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.RobotMap;

import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;
import com.spikes2212.utils.RunnableCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A {link {@link CommandGroup} which supposed to TurnAndMoveToGear, both the
 * high and the low
 *
 */
public class DriverTurnAndMoveToGear extends CommandGroup {

	public DriverTurnAndMoveToGear(Supplier<Double> rotateSpeedSupplier, Supplier<Double> forwardSpeedSupplier) {

		// choose the correct camera according to the elevator's position
		addSequential(new RunnableCommand(
				() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera", RobotMap.USB.LOW_CAM)));

		// turn until the peg is in the center of the robot's view range
		addSequential(new DriverTurnToTwoTargetsCenter(rotateSpeedSupplier));
		// drive forward towards the peg
		addSequential(new DriveArcade(Robot.drivetrain, forwardSpeedSupplier, () -> 0.0));
	}

}
