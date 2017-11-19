package org.usfirst.frc.team2212.robot.subsystems;

import javax.naming.LimitExceededException;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPicker extends LimitedSubsystem {
	
	private SpeedController pickerMotor;
	private AnalogPotentiometer potentiometer;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void move(double arg0) {
		// TODO Auto-generated method stub
		
	}
}

