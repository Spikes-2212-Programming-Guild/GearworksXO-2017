package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGearWithTime;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {
	
	private double rollerSpeed;
	private double elevatorSpeed;

	public DropGear() {
		determineSpeeds();
		
		// setting the roller gripper speed according to target
		
		addParallel(new RollGearWithTime(rollerSpeed,RollerGripper.WAIT_TIME_DROP.get()));

		//moving the elevator to the correct direction
		
		addParallel(new MoveLimitedSubsystem(Robot.elevator, elevatorSpeed));
	}

	private void determineSpeeds(){
		if (Robot.elevator.isMax()){
			rollerSpeed = RollerGripper.SPEED_OUT_HIGH_PEG.get();
			elevatorSpeed = Elevator.SPEED_DOWN.get();
		}
		else if (Robot.elevator.inTargetRange(Elevator.MIDDLE_SET_POINT.get())){
			rollerSpeed = RollerGripper.SPEED_OUT_LOW_PEG.get();
			elevatorSpeed = Elevator.SPEED_UP.get();
		}
	}

	

}