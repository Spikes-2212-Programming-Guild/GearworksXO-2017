package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearUsingLightSensor;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepareToScoreHigh extends CommandGroup {
	public PrepareToScoreHigh() {
		addSequential(new RollGearUsingLightSensor(false, RollerGripper.SPEED_UP_TO_SENSOR.get()));
		addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP.get()));
	}
}
