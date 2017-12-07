package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearUsingLightSensor;
import org.usfirst.frc.team2212.robot.commands.RollGearWithTime;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PrepareToScore extends CommandGroup {

	public PrepareToScore(double elevatorSpeed) {
		Command moveGripper = new WaitCommand(0);

		// score to high peg
		if (elevatorSpeed > 0 && Robot.rollerGripper.getSensorData())
			moveGripper = new RollGearUsingLightSensor(false, RollerGripper.SPEED_UP_TO_SENSOR.get());

		// score to low peg
		else if (elevatorSpeed < 0 && !Robot.elevator.isMin())
			moveGripper = new RollGearWithTime(-0.5, 1);

		addSequential(moveGripper);
		addSequential(new MoveLimitedSubsystem(Robot.elevator, elevatorSpeed));
	}
}
