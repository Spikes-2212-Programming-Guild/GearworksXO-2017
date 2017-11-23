package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends LimitedSubsystem {

    private SpeedController shooterMotor;
    private Encoder shooterEncoder;
    
    public Shooter(SpeedController shooterMotor, Encoder shooterEncoder){
    	this.shooterEncoder = shooterEncoder;
    	this.shooterMotor = shooterMotor;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return shooterEncoder;
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
		shooterMotor.set(speed);
	}
}

