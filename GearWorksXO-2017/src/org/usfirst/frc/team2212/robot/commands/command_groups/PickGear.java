package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.commands.MoveFolder;
import org.usfirst.frc.team2212.robot.commands.RollGearToLightSensor;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickGear extends CommandGroup {

	public PickGear() {
		addSequential(new RollGearToLightSensor(RollerGripper.SPEED_IN.get()));
		addSequential(new MoveFolder(Folder.SPEED_UP, Folder.WAIT_TIME.get()));
	}
}
