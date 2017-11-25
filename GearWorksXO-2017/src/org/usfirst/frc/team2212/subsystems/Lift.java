package org.usfirst.frc.team2212.subsystems;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;


public class Lift extends LimitedSubsystem {

    public SpeedController liftMotor;
    public DigitalInput upLimit;
    public DigitalInput downLimit;
    public Encoder liftEncoder;
    public static final Supplier<Double> SPEED = ConstantHandler.addConstantDouble("Lift-SPEED", 0.7);
    public static /*final*/ Supplier<Integer> MIDDLE; // place in encoder for putting lower gear
    public int position;
    
    public Lift(SpeedController liftMotor, DigitalInput upLimit, DigitalInput downLimit, Encoder liftEncoder){
    	this.liftMotor = liftMotor;
    	this.upLimit = upLimit;
    	this.downLimit = downLimit;
    	this.liftEncoder = liftEncoder;
    }
    
    public int getPosition(){
    	return position;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
		return liftEncoder;
	}

	@Override
	protected void move(double speed) {
		// TODO Auto-generated method stub
		liftMotor.set(speed);
	}
}

