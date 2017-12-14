package org.usfirst.frc.team2212.robot.commands.command_groups;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StopEverything extends CommandGroup {

    public StopEverything() {
    	addParallel(new MoveLimitedSubsystem(Robot.elevator, 0));
    	addParallel(new MoveLimitedSubsystem(Robot.folder, 0));
    	addParallel(new MoveLimitedSubsystem(Robot.rollerGripper, 0));
    }
}
