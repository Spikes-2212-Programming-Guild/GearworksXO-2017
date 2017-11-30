package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGearOut;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {

	public DropGear(int target) {
		addParallel(new MoveElevator(target));
		addSequential(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));
		// setting the roller gripper speed according to target
		double rollerSpeed = 0;

		if (target == Elevator.HIGH_SET_POINT.get())
			rollerSpeed = RollerGripper.SPEED_OUT_HIGH_PEG.get();
		else if (target == Elevator.MIDDLE_SET_POINT.get())
			rollerSpeed = RollerGripper.SPEED_OUT_LOW_PEG.get();

		addSequential(new RollGearOut(RollerGripper.WAIT_TIME_DROP.get(), rollerSpeed));
	}
}