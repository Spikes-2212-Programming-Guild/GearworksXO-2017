package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;

import com.ctre.CANTalon;
import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 */
public class Climber extends LimitedSubsystem {

	private CANTalon motor;
	public static final Supplier<Double> MAX_CURRENT = ConstantHandler.addConstantDouble("MAX_CURRENT", 35);
	public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("climber-SPEED", 1);

	public Climber(CANTalon climberMotor) {
		this.motor = climberMotor;
		this.motor.setInverted(true);
	}

	@Override
	public boolean isMin() {
		return false;
	}

	@Override
	public boolean isMax() {
		return (motor.getOutputCurrent() >= MAX_CURRENT.get());
	}

	@Override
	public PIDSource getPIDSource() {
		return null;
	}

	@Override
	protected void move(double speed) {
		motor.set(speed);
	}

	public void initDefaultCommand() {
	}
}
