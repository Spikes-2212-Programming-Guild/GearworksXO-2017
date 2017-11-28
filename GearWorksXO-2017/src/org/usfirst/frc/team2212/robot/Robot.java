
package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.subsystems.Climber;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.GearPicker;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Elevator elevator;
	public static Climber climber;
	public static GearPicker gearPicker;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		elevator = new Elevator(new VictorSP(RobotMap.PWM.ELEVATOR), new DigitalInput(RobotMap.DIO.ELEVATOR_UP),
				new DigitalInput(RobotMap.DIO.ELEVATOR_DOWN),
				new Encoder(RobotMap.DIO.ELEVATOR_ENCODER_A, RobotMap.DIO.ELEVATOR_ENCODER_B));
		climber = new Climber(new CANTalon(RobotMap.CAN.CLIMBER));
		gearPicker = new GearPicker(new CANTalon(RobotMap.CAN.GEAR_PICKER),
				new DigitalInput(RobotMap.DIO.GEAR_PICKER_DOWN), new DigitalInput(RobotMap.DIO.GEAR_PICKER_UP),
				new Encoder(RobotMap.DIO.GEAR_PICKER_ENCODER_A, RobotMap.DIO.GEAR_PICKER_ENCODER_B));
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
