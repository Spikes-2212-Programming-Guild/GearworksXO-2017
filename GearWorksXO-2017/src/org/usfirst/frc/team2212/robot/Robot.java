
package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.MoveElevatorUpSlowly;
import org.usfirst.frc.team2212.robot.commands.MoveLimitedSubsystemWithTimeSinceReachingLimit;
import org.usfirst.frc.team2212.robot.commands.auto.CrossAutoLine;
import org.usfirst.frc.team2212.robot.commands.auto.CrossAutoLineAndControlSquare;
import org.usfirst.frc.team2212.robot.commands.auto.StartingPreparation;
import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PickGear;
import org.usfirst.frc.team2212.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.ctre.CANTalon;
import com.spikes2212.dashboard.DashBoardController;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.utils.CamerasHandler;
import com.spikes2212.utils.DoubleSpeedcontroller;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Elevator elevator;
	public static Folder folder;
	public static Drivetrain drivetrain;
	public static RollerGripper rollerGripper;
	public static DashBoardController dbc;
	public static CamerasHandler camerasHandler;
	public static SendableChooser<Command> chooser;

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

		rollerGripper = new RollerGripper(new CANTalon(RobotMap.CAN.ROLLER),
				new DigitalInput(RobotMap.DIO.ROLLER_HIGH_SENSOR), new DigitalInput(RobotMap.DIO.ROLLER_LOW_SENSOR));

		elevator = new Elevator(new VictorSP(RobotMap.PWM.ELEVATOR_MOTOR), new DigitalInput(RobotMap.DIO.ELEVATOR_DOWN),
				new DigitalInput(RobotMap.DIO.ELEVATOR_UP),
				new Encoder(RobotMap.DIO.ELEVATOR_ENCODER_A, RobotMap.DIO.ELEVATOR_ENCODER_B));

		folder = new Folder(new CANTalon(RobotMap.CAN.FOLDER), new DigitalInput(RobotMap.DIO.FOLDER_DOWN),
				new DigitalInput(RobotMap.DIO.FOLDER_UP));

		camerasHandler = new CamerasHandler(160 * 2, 120 * 2, 0);
		camerasHandler.setExposure(47);

		chooser = new SendableChooser<>();
		chooser.addObject("pass line", new CrossAutoLine());
		chooser.addObject("pass line and controll square", new CrossAutoLineAndControlSquare());
		oi = new OI();

		initDashboard();
	}

	private void initDashboard() {
		dbc = new DashBoardController();

		// adding 5 boolean boxes which present the position of the elevator
		dbc.addBoolean("Top", () -> elevator.isMax());
		dbc.addBoolean("Mid", () -> (elevator.inTargetRange(Elevator.MIDDLE_SET_POINT.get())));
		dbc.addBoolean("Bottom", () -> elevator.isMin());

		dbc.addBoolean("Roller high sensor blocked", rollerGripper::getHighSensorData);
		dbc.addBoolean("Roller low sensor blocked", rollerGripper::getLowSensorData);

		SmartDashboard.putData("Gripper - RollGearIn",
				new MoveLimitedSubsystem(Robot.rollerGripper, PickGear.ROLLER_SPEED_IN));

		SmartDashboard.putData("Folder - MoveUp", new MoveLimitedSubsystemWithTimeSinceReachingLimit(Robot.folder,
				Folder.SPEED_UP, Folder.WAIT_TIME.get()));
		SmartDashboard.putData("Folder - MoveDown",
				new MoveLimitedSubsystemWithTimeSinceReachingLimit(Robot.folder,
						() -> Robot.folder.isMax() ? Folder.SPEED_DOWN_A.get() : Folder.SPEED_DOWN_B.get(),
						Folder.WAIT_TIME.get()));

		SmartDashboard.putData("Elevator - moveUp", new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP.get()));
		SmartDashboard.putData("Elevator - moveDown",
				new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN.get()));

		SmartDashboard.putData("Roll-Gear-Down",
				new MoveLimitedSubsystem(rollerGripper, DropGear.ROLLER_SPEED_OUT_LOW_PEG));
		SmartDashboard.putData("Roll-Gear-Up",
				new MoveLimitedSubsystem(rollerGripper, DropGear.ROLLER_SPEED_OUT_HIGH_PEG));

		SmartDashboard.putData("Move ele up while ignoring the limit", new MoveElevatorUpSlowly());

		SmartDashboard.putData(new StartingPreparation());

		SmartDashboard.putData("auto chooser", chooser);
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
		new StartingPreparation().start();
		chooser.getSelected().start();
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
		chooser.getSelected().cancel();
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
