package org.usfirst.frc.team2212.robot.commands.command_groups;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.commands.RollGearToLightSensor;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

/**
 * Created by tomer on 30/11/17.
 */
public class PickGear extends CommandGroup{

    public PickGear(){
        addSequential(new RollGearToLightSensor(RollerGripper.SPEED_IN.get()));
        addSequential(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));
    }
}
