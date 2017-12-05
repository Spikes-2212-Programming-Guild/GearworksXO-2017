package org.usfirst.frc.team2212.robot.commands.command_groups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearWithTime;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {


	public DropGear(double rollerSpeed, double elevatorSpeed) {

		// setting the roller gripper speed according to target
		addParallel(new RollGearWithTime(rollerSpeed, RollerGripper.WAIT_TIME_DROP.get()));

		// moving the elevator to the correct direction

		addParallel(new MoveLimitedSubsystem(Robot.elevator, elevatorSpeed));
	}
}