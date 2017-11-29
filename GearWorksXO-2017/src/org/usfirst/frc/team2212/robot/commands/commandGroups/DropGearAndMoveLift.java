package org.usfirst.frc.team2212.robot.commands.commandGroups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGear;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;

import com.spikes2212.dashboard.ConstantHandler;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class DropGearAndMoveLift extends CommandGroup {

	public static final Supplier<Integer> TIME_BEFORE_FOLDING = ConstantHandler.addConstantInt("time-before-folding",
			2);

	public DropGearAndMoveLift(Supplier<Double> rollSpeed, double rollWaitTime, ElevatorState elevatorTarget) {
		addParallel(new RollGear(rollSpeed, rollWaitTime));
		addSequential(new WaitCommand(TIME_BEFORE_FOLDING.get()));
		addParallel(new MoveElevator(elevatorTarget));
	}
}
