package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.utils.RunnableCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OrientToLowPeg extends CommandGroup {

	public static final Supplier<Double> LOW_PEG_CAMERA_ID = ConstantHandler.addConstantDouble("OrientToLowPeg-CAMERA_ID",
			1);
	public static final Supplier<Double> TOLERANCE = ConstantHandler.addConstantDouble("OrientToLowPeg-TOLERANCE", 0.05);

	public OrientToLowPeg(Supplier<Double> turningSpeed) {
		addSequential(new RunnableCommand(
				() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera", LOW_PEG_CAMERA_ID.get())));
		addSequential(new OrientToTwoTargets(turningSpeed, TOLERANCE.get()));
	}

}
