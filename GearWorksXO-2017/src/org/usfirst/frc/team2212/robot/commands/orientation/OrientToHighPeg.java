package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;
import org.usfirst.frc.team2212.robot.RobotMap;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.utils.RunnableCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * this {@link CommandGroup} orients to the high peg automatically
 */
public class OrientToHighPeg extends CommandGroup {

	// the tolerance of the orientation to the center of the peg
	public static final Supplier<Double> TOLERANCE = ConstantHandler.addConstantDouble("OrientToHighPeg-TOLERANCE",
			0.025);

	public OrientToHighPeg(Supplier<Double> turningSpeed) {
		
		addSequential(new RunnableCommand(
				() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera", RobotMap.USB.HIGH_CAM)));

		addSequential(new OrientToTwoTargets(turningSpeed, TOLERANCE.get()));
		
		addSequential(new WaitCommand(0.3));
	}
}
