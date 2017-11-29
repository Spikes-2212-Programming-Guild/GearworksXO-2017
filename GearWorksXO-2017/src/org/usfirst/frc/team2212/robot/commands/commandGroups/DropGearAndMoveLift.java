package org.usfirst.frc.team2212.robot.commands.commandGroups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGear;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DropGearAndMoveLift extends CommandGroup {

	public DropGearAndMoveLift(Supplier<Double> rollSpeed, double rollWaitTime, double timeBeforeFoling, ElevatorState elevatorTarget) {
		addParallel(new RollGear(rollSpeed,rollWaitTime));
		addSequential(new WaitCommand(timeBeforeFoling));
		addParallel(new MoveElevator(elevatorTarget));
	}
}
