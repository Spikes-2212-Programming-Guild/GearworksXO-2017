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

	private SpeedController speedController;
	private Encoder encoder;
	private DigitalInput upLimit;
	private DigitalInput downLimit;

	public void gearPicker(Encoder Encoder, SpeedController speedController, DigitalInput upLimit,DigitalInput downLimit) {
		this.encoder = Encoder;
		this.speedController = speedController;
		this.upLimit = upLimit;
		this.downLimit = downLimit;
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
		return upLimit.get();
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return downLimit.get();
	}

	@Override
	protected void move(double speed) {
		this.speedController.set(speed);
	}

}
