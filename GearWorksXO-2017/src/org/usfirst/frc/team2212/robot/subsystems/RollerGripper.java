package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollerGripper extends Subsystem {

	public static final Supplier<Double> SPEED_IN = ConstantHandler.addConstantDouble("Gripper - speed", 0.5);
	public static final Supplier<Double> SPEED_OUT_HIGH_PEG = ConstantHandler.addConstantDouble("Gripper - speed", -0.5);
	public static final Supplier<Double> SPEED_OUT_LOW_PEG = ConstantHandler.addConstantDouble("Gripper - speed", 0.5);

	public static final Supplier<Double> WAIT_TIME_DROP = ConstantHandler.addConstantDouble("Gripper - wait time drop",
			0);

	private SpeedController motor;
	private DigitalInput sensor;

	// TODO - check if motor inverted
	// TODO - check if sensor inverted
	public RollerGripper(SpeedController motor, DigitalInput sensor) {
		this.motor = motor;
		this.sensor = sensor;
	}

	public void move(double speed) {
		motor.set(speed);
	}

	public void stop() {
		motor.set(0);
	}

	public boolean getSensorData() {
		return sensor.get();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}