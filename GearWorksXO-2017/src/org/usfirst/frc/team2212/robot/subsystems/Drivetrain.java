package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

public class Drivetrain extends TankDrivetrain {

	// defining subsystem fields
	private SpeedController leftSpeedController;
	private SpeedController rightSpeedController;

	private Encoder encoderLeft;
	private Encoder encoderRight;

	public Drivetrain(SpeedController leftGearbox, SpeedController rightGearbox, Encoder encoderLeft,
			Encoder encoderRight) {
		this.leftSpeedController = leftGearbox;
		this.rightSpeedController = rightGearbox;
		this.encoderLeft = encoderLeft;
		this.encoderRight = encoderRight;

		// inverting the left speed controller
		leftSpeedController.setInverted(true);

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

	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade(Robot.drivetrain, Robot.oi::getDriverY, Robot.oi::getRotation));
	}
}