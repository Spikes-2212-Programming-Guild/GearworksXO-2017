package org.usfirst.frc.team2212.robot.commands.commandGroups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGear;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearAndMoveLift extends CommandGroup {

	public DropGearAndMoveLift(Supplier<Double> rollSpeed, double rollWaitTime, ElevatorState elevatorTarget) {
		addParallel(new RollGear(rollSpeed, rollWaitTime));
		addParallel(new MoveElevator(elevatorTarget));
	}
}
