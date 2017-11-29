package org.usfirst.frc.team2212.robot.commands.commandGroups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrepareToPickGear extends CommandGroup {

    public PrepareToPickGear(Supplier<Double> foldSpeed, Supplier<Double> unfoldSpeed) {
        addSequential(new MoveLimitedSubsystem(Robot.folder, foldSpeed));
        addSequential(new MoveElevator(ElevatorState.LOW_LIMIT));
        addSequential(new MoveLimitedSubsystem(Robot.folder, unfoldSpeed));
    }
}
