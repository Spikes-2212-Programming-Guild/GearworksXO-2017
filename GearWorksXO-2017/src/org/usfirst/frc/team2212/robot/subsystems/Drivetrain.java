package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.utils.DoubleSpeedcontroller;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends TankDrivetrain {
	
	private DoubleSpeedcontroller leftGearbox;
	private DoubleSpeedcontroller rightGearbox;

	public Drivetrain(DoubleSpeedcontroller leftGearbox, DoubleSpeedcontroller rightGearbox) {
		this.leftGearbox = leftGearbox;
		this.rightGearbox = rightGearbox;
	}
	
	public Drivetrain(SpeedController leftFrontMotor, SpeedController leftBackMotor, SpeedController rightFrontMotor, SpeedController rightBackMotor) {
		
	}
    public void initDefaultCommand() {
    	//TODO bom
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public PIDSource getLeftPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PIDSource getRightPIDSource() {
		// TODO Auto-generated method stub
		return null;
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

