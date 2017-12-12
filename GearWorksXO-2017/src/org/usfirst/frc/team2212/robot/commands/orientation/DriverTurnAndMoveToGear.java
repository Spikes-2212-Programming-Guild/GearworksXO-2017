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
		addSequential(new RunnableCommand(() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera",
				Robot.elevator.isMax() ? RobotMap.USB.HIGH_CAM : RobotMap.USB.LOW_CAM)));
		addSequential(new DriverTurnToTwoTargetsCenter(rotateSpeedSupplier));
		addSequential(new DriveArcade(Robot.drivetrain, forwardSpeedSupplier, () -> 0.0));
	}
	
}
