package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Drivetrain extends TankDrivetrain {

	private SpeedController leftSpeedController;
	private SpeedController rightSpeedController;
	private Encoder encoderLeft;
	private Encoder encoderRight;

	// TODO - check inverted motors 
	public Drivetrain(SpeedController leftGearbox, SpeedController rightGearbox, Encoder encoderLeft,
			Encoder encoderRight) {
		this.leftSpeedController = leftGearbox;
		this.rightSpeedController = rightGearbox;
		this.encoderLeft = encoderLeft;
		this.encoderRight = encoderRight;
	}

	// TODO - add default command
	public void initDefaultCommand() {
	}

	@Override
	public PIDSource getLeftPIDSource() {
		return encoderLeft;
	}

	@Override
	public PIDSource getRightPIDSource() {
		return encoderRight;
	}

	@Override
	public void setLeft(double speed) {
		leftSpeedController.set(speed);
	}

	@Override
	public void setRight(double speed) {
		rightSpeedController.set(speed);
	}
}
