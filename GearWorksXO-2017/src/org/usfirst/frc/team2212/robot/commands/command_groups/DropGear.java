package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGearOut;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {

	public DropGear(ElevatorState target) {
		addParallel(new MoveElevator(target));
		addSequential(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));
		// setting the roller gripper speed according to target
		double rollerSpeed = 0;
		switch (target) {
		case HIGH_LIMIT:
			rollerSpeed = RollerGripper.SPEED_OUT_HIGH_PEG.get();
			break;
		case MIDDLE:
			rollerSpeed = RollerGripper.SPEED_OUT_LOW_PEG.get();
			break;
		default:
			// well, you really want to get rid of your god damn gear, don't you?
			rollerSpeed = 0;
			break;
		}
		addSequential(new RollGearOut(RollerGripper.WAIT_TIME_DROP.get(), rollerSpeed));

	}

}
