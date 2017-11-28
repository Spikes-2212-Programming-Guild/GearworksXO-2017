package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Drivetrain extends TankDrivetrain {

	private SpeedController leftGearbox;
	private SpeedController rightGearbox;
	private Encoder encoderLeft;
	private Encoder encoderRight;

	public Drivetrain(SpeedController leftGearbox, SpeedController rightGearbox, Encoder encoderLeft,
			Encoder encoderRight) {
		this.leftGearbox = leftGearbox;
		this.rightGearbox = rightGearbox;
		this.encoderLeft = encoderLeft;
		this.encoderRight = encoderRight;
		//y tho
	}

	public void initDefaultCommand() {
		// TODO bom
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public PIDSource getLeftPIDSource() {
		// TODO Auto-generated method stub
		return encoderLeft;
	}

	@Override
	public PIDSource getRightPIDSource() {
		// TODO Auto-generated method stub
		return encoderRight;
	}

	@Override
	public void setLeft(double speed) {
		leftGearbox.set(speed);
	}

	@Override
	public void setRight(double speed) {
		rightGearbox.set(speed);
	}
}
