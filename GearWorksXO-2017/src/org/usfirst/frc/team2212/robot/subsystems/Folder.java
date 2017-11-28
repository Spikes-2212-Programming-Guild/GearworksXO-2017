package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 *
 */
public class Folder extends LimitedSubsystem {

	// TODO - Change name to Folder
	
	// TODO - Change constants values to actual potentiometer values
	public static final Supplier<Double> LOW = ConstantHandler.addConstantDouble("Folder - Low", 0);
	public static final Supplier<Double> MID = ConstantHandler.addConstantDouble("Folder - Mid", 45);
	public static final Supplier<Double> HIGH = ConstantHandler.addConstantDouble("Folder - High", 90);
	private SpeedController motor;
	private DigitalInput downLimit;
	private DigitalInput upLimit;
	private Encoder encoder;
	//private AnalogPotentiometer potentiometer;
	
	//TODO - check if motor is inverted
	//TODO - check if potentiometer is needed
	public Folder(SpeedController motor, DigitalInput downLimit, DigitalInput upLimit, Encoder encoder
					  /*, AnalogPotentiometer potentiometer */) {
		this.motor = motor;
		this.upLimit = downLimit;
		this.downLimit = upLimit;
		this.encoder = encoder;
		/* this.potentiometer = potentiometer; */
	}

	@Override
	public boolean isMin() {
		return downLimit.get();
	}

	@Override
	public boolean isMax() {
		return upLimit.get();
	}

	@Override
	public PIDSource getPIDSource() {
		return encoder;
		/* return potentiometer; */
	}

	@Override
	protected void move(double speed) {
		this.motor.set(speed);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
