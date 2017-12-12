package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.utils.RunnableCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class OrientToHighPeg extends CommandGroup {
	public static final Supplier<Double> HIGH_PEG_CAMERA_ID = ConstantHandler
			.addConstantDouble("OrientToHighPeg-CAMERA_ID", 0);
	public static final Supplier<Double> TOLERANCE = ConstantHandler.addConstantDouble("OrientToHighPeg-TOLERANCE",
			0.025);

	public OrientToHighPeg(Supplier<Double> turningSpeed) {
		addSequential(new RunnableCommand(
				() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera", HIGH_PEG_CAMERA_ID.get())));
		addSequential(new OrientToTwoTargets(turningSpeed, TOLERANCE.get()));
		addSequential(new WaitCommand(0.3));
	}
}
