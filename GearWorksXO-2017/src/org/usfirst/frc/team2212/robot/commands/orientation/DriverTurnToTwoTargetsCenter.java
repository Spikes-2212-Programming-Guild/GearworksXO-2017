package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;
import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.Timer;

/**
 * A {@link DriveArcade} command which rotates the drivetrain in a given
 * rotateSpeed until both of the reflectives are in the center of the camera
 * within the TOLERANCE and WAIT_TIME specified
 *
 */
public class DriverTurnToTwoTargetsCenter extends DriveArcade {
	
	// the last time the drivetrain faced the center of the peg
	private double lastTimeNotOnTarget = Timer.getFPGATimestamp();
	
	// the time the drivetrain should be centered to the peg before ending this command
	public static final Supplier<Double> WAIT_TIME = ConstantHandler.addConstantDouble("DriverTurnToTwoTargetsCenter-WAIT_TIME",
			0.25);
	
	// the tolerance of the orientation to the center of the peg
	public static final Supplier<Double> TOLERANCE = ConstantHandler.addConstantDouble("DriverTurnToTwoTargetsCenter-TOLERANCE",
			0.05);

	public DriverTurnToTwoTargetsCenter(Supplier<Double> rotateSpeedSupplier) {
		super(Robot.drivetrain, () -> 0.0, rotateSpeedSupplier);
	}
	
	/**
	 * end this command when the drivetain was centered for the given waitTime
	 */
	@Override
	protected boolean isFinished() {
		// center supposed to be 0
		boolean isCentered = Math.abs(ImageProcessingConstants.TWO_OBJECTS_CENTER.get()) <= TOLERANCE.get();
		if (!isCentered) {
			lastTimeNotOnTarget = Timer.getFPGATimestamp();
		}
		return Timer.getFPGATimestamp() - lastTimeNotOnTarget >= WAIT_TIME.get();
	}
}