package org.usfirst.frc.team2212.robot.commands.auto;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.orientation.OrientToLowPeg;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PutGearAuto extends CommandGroup {

	public static final Supplier<Double> DRIVE_SPEED_START = ConstantHandler
			.addConstantDouble("putGearAuto- start driving speed", 0.3);
	public static final Supplier<Double> DRIVE_TIME = ConstantHandler.addConstantDouble("putGearAuto- driving time",
			0.5);
	public static final Supplier<Double> LEFT_ROTATE_SPEED = ConstantHandler
			.addConstantDouble("putGearAuto- left rotate speed", 0.5);
	public static final Supplier<Double> RIGHT_ROTATE_SPEED = ConstantHandler
			.addConstantDouble("putGearAuto- right rotate speed", -0.5);

	public static final Supplier<Double> DRIVE_TO_GEAR_SPEED = ConstantHandler
			.addConstantDouble("putGearAuto - drive speed to gear", 0.5);
	public static final Supplier<Double> DRIVE_TO_GEAR_TIME = ConstantHandler
			.addConstantDouble("putGearAuto - drive time to gear", 0.5);

	public PutGearAuto(Supplier<Double> rotateSpeed) {
		addSequential(new DriveArcade(Robot.drivetrain, DRIVE_SPEED_START, () -> 0.0), DRIVE_TIME.get());

		addSequential(new OrientToLowPeg(rotateSpeed));

		addSequential(new DriveArcade(Robot.drivetrain, DRIVE_TO_GEAR_SPEED, () -> 0.0), DRIVE_TO_GEAR_TIME.get());
	}
}
