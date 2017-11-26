package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

public class MoveGearPicker extends MoveLimitedSubsystem{

	public MoveGearPicker(LimitedSubsystem GearPicker, double speed) {
		super(GearPicker, speed);
		requires(Robot.gearPicker);
		// TODO Auto-generated constructor stub
	}

}
