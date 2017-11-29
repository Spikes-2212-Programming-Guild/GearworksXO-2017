package org.usfirst.frc.team2212.robot.commands.commandGroups;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGear;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DropGearWithAngle extends CommandGroup {

    public DropGearWithAngle(Supplier<Double> foldSpeed, Supplier<Double> rollSpeed, Supplier<Double> rollWaitTime) {
        addParallel(new MoveLimitedSubsystem(Robot.folder, foldSpeed));
        addParallel(new RollGear(rollSpeed, rollWaitTime.get()));
    }
}
