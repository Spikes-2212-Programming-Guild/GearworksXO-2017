package org.usfirst.frc.team2212.robot.commands.auto;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.orientation.OrientToLowPeg;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PutGearAuto extends CommandGroup {

	public static final Supplier<Double> DRIVE_SPEED = ConstantHandler.addConstantDouble("putGearAuto- driving speed",
			0.5);
	public static final Supplier<Double> DRIVE_TIME = ConstantHandler.addConstantDouble("putGearAuto- driving time",
			2);
	public static final Supplier<Double> LEFT_ROTATE_SPEED = ConstantHandler
			.addConstantDouble("putGearAuto- left rotate speed", 0.5);
	public static final Supplier<Double> RIGHT_ROTATE_SPEED = ConstantHandler
			.addConstantDouble("putGearAuto- right rotate speed", -0.5);

	public PutGearAuto(Supplier<Double> rotateSpeed) {
		addSequential(new DriveArcade(Robot.drivetrain, DRIVE_SPEED, () -> 0.0), DRIVE_TIME.get());

		addSequential(new OrientToLowPeg(rotateSpeed));

	}
}
