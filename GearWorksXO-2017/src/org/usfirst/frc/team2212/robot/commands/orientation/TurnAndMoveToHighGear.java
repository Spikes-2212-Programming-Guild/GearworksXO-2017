package org.usfirst.frc.team2212.robot.commands.orientation;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.ImageProcessingConstants;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.utils.RunnableCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnAndMoveToHighGear extends CommandGroup {

	public static final Supplier<Double> HIGH_GEAR_CAM_ID = ConstantHandler.addConstantDouble("HighGear-Camera_ID", 0);

	public TurnAndMoveToHighGear() {
		addSequential(new RunnableCommand(
				() -> ImageProcessingConstants.NETWORK_TABLE.putNumber("currentCamera", HIGH_GEAR_CAM_ID.get())));
		addSequential(new OrientAndMoveToGear());
	}
}
