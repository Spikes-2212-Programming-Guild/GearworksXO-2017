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

	public DropGear() {
		// setting the roller gripper speed according to target
		double rollerSpeed = determineRollerSpeed();
		addSequential(new RollGearOut(rollerSpeed,RollerGripper.WAIT_TIME_DROP.get()));

		//moving the elevator to the correct direction
		int elevatorTarget=determineElevatorTarget();
		addSequential(new MoveElevator(elevatorTarget));
	}

	private double determineRollerSpeed(){
		if (Robot.elevator.inTargetRange(Elevator.HIGH_SET_POINT.get()))
			return RollerGripper.SPEED_OUT_HIGH_PEG.get();
		else if (Robot.elevator.inTargetRange(Elevator.MIDDLE_SET_POINT.get()))
			return RollerGripper.SPEED_OUT_LOW_PEG.get();
		return 0;
	}

	private int determineElevatorTarget(){
		if (Robot.elevator.inTargetRange(Elevator.HIGH_SET_POINT.get()))
			return Elevator.MIDDLE_SET_POINT.get();
		else if (Robot.elevator.inTargetRange(Elevator.MIDDLE_SET_POINT.get()))
			return Elevator.HIGH_SET_POINT.get();
		return 0;


	}
}