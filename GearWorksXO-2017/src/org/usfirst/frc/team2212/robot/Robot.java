
package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.JustFuckingMoveCommand;
import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.MoveFolder;
import org.usfirst.frc.team2212.robot.commands.commandGroups.DropGearAndMoveLift;
import org.usfirst.frc.team2212.robot.subsystems.Climber;
import org.usfirst.frc.team2212.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.ctre.CANTalon;
import com.spikes2212.dashboard.DashBoardController;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.utils.DoubleSpeedcontroller;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Elevator elevator;
	public static Climber climber;
	public static Folder folder;
	public static Drivetrain drivetrain;
	public static RollerGripper rollerGripper;
	public static DashBoardController dbc;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain(
				new DoubleSpeedcontroller(new CANTalon(RobotMap.CAN.DRIVE_LEFT_FRONT),
						new CANTalon(RobotMap.CAN.DRIVE_LEFT_REAR)),
				new DoubleSpeedcontroller(new CANTalon(RobotMap.CAN.DRIVE_RIGHT_FRONT),
						new CANTalon(RobotMap.CAN.DRIVE_RIGHT_REAR)),
				new Encoder(RobotMap.DIO.DRIVE_LEFT_ENCODER_A, RobotMap.DIO.DRIVE_LEFT_ENCODER_B),
				new Encoder(RobotMap.DIO.DRIVE_RIGHT_ENCODER_A, RobotMap.DIO.DRIVE_RIGHT_ENCODER_B));

		rollerGripper = new RollerGripper(new VictorSP(RobotMap.PWM.ROLLER_MOTOR),
				new DigitalInput(RobotMap.DIO.ROLLER_SENSOR));

		elevator = new Elevator(new VictorSP(RobotMap.PWM.ELEVATOR_MOTOR), new DigitalInput(RobotMap.DIO.ELEVATOR_DOWN),
				new DigitalInput(RobotMap.DIO.ELEVATOR_UP),
				new Encoder(RobotMap.DIO.ELEVATOR_ENCODER_A, RobotMap.DIO.ELEVATOR_ENCODER_B));

		climber = new Climber(new CANTalon(RobotMap.CAN.CLIMBER));

		folder = new Folder(new CANTalon(RobotMap.CAN.FOLDER), new DigitalInput(RobotMap.DIO.FOLDER_DOWN),
				new DigitalInput(RobotMap.DIO.FOLDER_UP),
				new AnalogPotentiometer(RobotMap.AnalogInput.FOLDER_POTENTIOMETER, 360, Folder.STARTING_ANGLE.get()));

		oi = new OI();

		dbc = new DashBoardController();
		dbc.addBoolean("Top", () -> elevator.isMax());
		dbc.addBoolean("Top To Mid",
				() -> (0 < elevator.getPosition() && elevator.getPosition() < Elevator.MIDDLE_SET_POINT.get()));
		dbc.addBoolean("Mid", () -> (Math
				.abs(Elevator.MIDDLE_SET_POINT.get() - Robot.elevator.getPosition()) <= MoveElevator.TOLERANCE.get()));
		dbc.addBoolean("Mid To Bottom", () -> (Elevator.MIDDLE_SET_POINT.get() < elevator.getPosition()
				&& elevator.getPosition() < Elevator.HIGH_SET_POINT.get()));
		dbc.addBoolean("Bottom", () -> elevator.isMin());

		dbc.addBoolean("lift-down-limit", () -> elevator.isMin());
		dbc.addBoolean("lift-up-limit", () -> elevator.isMax());
		dbc.addBoolean("folder-down-limit", () -> folder.isMin());
		dbc.addBoolean("folder-up-limit", () -> folder.isMax());
		dbc.addDouble("lift-encoder", () -> (double) elevator.getPosition());
		dbc.addDouble("folder-potentio", () -> (double) folder.getPotentiometer().get());

		SmartDashboard.putData("move folder up", new MoveFolder(folder, 0.8, 1));
		SmartDashboard.putData("move folder down",
				new MoveLimitedSubsystem(folder, () -> (folder.isMax() ? -0.4 : 0.1)));

		SmartDashboard.putData("movLiftDown", new MoveLimitedSubsystem(elevator, -0.8));
		SmartDashboard.putData("movLiftUp", new MoveLimitedSubsystem(elevator, 0.8));

		SmartDashboard.putData("eat gear", new MoveLimitedSubsystem(rollerGripper, RollerGripper.SPEED_IN.get()));
		SmartDashboard.putData("spit gear out", new MoveLimitedSubsystem(rollerGripper, RollerGripper.SPEED_OUT.get()));

		SmartDashboard.putData("take a shit", new JustFuckingMoveCommand());

		SmartDashboard.putData("climbe", new MoveLimitedSubsystem(climber, Climber.SPEED.get()));
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
		dbc.update();
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
		dbc.update();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
