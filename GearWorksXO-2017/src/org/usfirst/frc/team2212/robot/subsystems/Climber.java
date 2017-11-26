package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.CANTalon;
import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 */
public class Climber extends LimitedSubsystem {
	
	private CANTalon motor;
	public static final Supplier<Double> MAX_CURRENT = ConstantHandler.addConstantDouble("MAX_CURRENT", 0.75);
	public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("SPEED", 0.5);
	
	public Climber(CANTalon climberMotor) {
		this.motor = climberMotor;
		this.motor.setInverted(true);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return (motor.getOutputCurrent() >= MAX_CURRENT.get());
	}

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void move(double speed) {
		motor.set(speed);
	}
}

