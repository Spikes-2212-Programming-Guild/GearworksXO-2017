package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Feeder extends LimitedSubsystem {

	private SpeedController feederMotor;
	public SpeedController blenderMotor;
	public static final Supplier<Double> BLENDER_SPEED = ConstantHandler.addConstantDouble("Feeder-BLENDER_SPEED", 0.5);
	public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("Feeder-SPEED", 0.5);
	
	public Feeder(SpeedController feederMotor, SpeedController blenderMotor){
		this.feederMotor = feederMotor;
		this.blenderMotor = blenderMotor;
	}
	
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
	protected void move(double speed) {
		feederMotor.set(speed);
		blenderMotor.set(BLENDER_SPEED.get());
	}
	
	@Override
	public void stop(){
		super.stop();
		blenderMotor.set(0);
	}
}

