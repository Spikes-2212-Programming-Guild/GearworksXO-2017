package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class GearPicker extends LimitedSubsystem {

	private SpeedController motor;
	private Encoder encoder;
	private DigitalInput maxLimit;
	private DigitalInput minLimit;

	public void gearPicker(Encoder pickerEncoder, SpeedController pickerMotor, DigitalInput upLimit,DigitalInput downLimit) {
		this.encoder = pickerEncoder;
		this.motor = pickerMotor;
		this.maxLimit = upLimit;
		this.minLimit = downLimit;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return encoder;
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return maxLimit.get();
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return minLimit.get();
	}

	@Override
	protected void move(double speed) {
		this.motor.set(speed);
	}

}
