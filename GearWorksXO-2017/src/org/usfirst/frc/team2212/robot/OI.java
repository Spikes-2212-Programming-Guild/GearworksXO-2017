package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.RollGearIn;
import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PickGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToCollectGear;
import org.usfirst.frc.team2212.robot.commands.orientation.TurnAndMoveToGear;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI/* GEVALD */ {

	// initializing joysticks
	private Joystick driverRight = new Joystick(1);
	private Joystick driverLeft = new Joystick(2);
	private Joystick navigator = new Joystick(0);

	// Driver Buttons
	private JoystickButton TurnAndMoveToGearAll;
	private JoystickButton TurnAndMoveToGearHigh;
	private JoystickButton TurnAndMoveToGearLow;

	// Navigator Buttons
	private JoystickButton moveElevatorToMiddle;
	private JoystickButton moveElevatorToHigh;
	private JoystickButton rollGearIn;
	private JoystickButton moveFolderUp;
	private JoystickButton moveFolderDown;
	private JoystickButton dropGear;
	private JoystickButton prepareToPickGear;
	private JoystickButton pickGear;

	public OI() {
		initJoystickDriver();
		initJoystickNavigator();
	}

	private void initJoystickNavigator() {

		moveElevatorToHigh = new JoystickButton(navigator, 2);
		moveElevatorToMiddle = new JoystickButton(navigator, 3);
		rollGearIn = new JoystickButton(navigator, 4);
		moveFolderUp = new JoystickButton(navigator, 5);
		moveFolderDown = new JoystickButton(navigator, 6);
		dropGear = new JoystickButton(navigator, 7);
		prepareToPickGear = new JoystickButton(navigator, 8);
		pickGear = new JoystickButton(navigator, 9);

		moveElevatorToHigh.whenPressed(new MoveLimitedSubsystem(Robot.elevator, -0.5));
		moveElevatorToMiddle.whenPressed(new MoveLimitedSubsystem(Robot.elevator, 0.5));
		rollGearIn.whenPressed(new RollGearIn(RollerGripper.SPEED_IN.get()));
		moveFolderUp.whenPressed(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));
		moveFolderDown.whenPressed(new MoveLimitedSubsystem(Robot.folder,
				Robot.folder.isMax() ? Folder.SPEED_DOWN_A : Folder.SPEED_DOWN_B));
		dropGear.whenPressed(new DropGear());
		prepareToPickGear.whenPressed(new PrepareToCollectGear());
		pickGear.whenPressed(new PickGear());
	}

	private void initJoystickDriver() {
		TurnAndMoveToGearAll = new JoystickButton(driverRight, 1);
		TurnAndMoveToGearLow = new JoystickButton(driverRight, 2);
		TurnAndMoveToGearHigh = new JoystickButton(driverRight, 3);

		TurnAndMoveToGearAll.whileHeld(new TurnAndMoveToGear(this::getRightX, this::getRightY));
	}

	public double adjustSpeed(double speed) {
		return Math.abs(speed) * speed;
	}

	public double getRightX() {
		return -driverRight.getX();
	}

	public double getRightY() {
		return adjustSpeed(driverRight.getY());
	}

	public double getLeftX() {
		return -driverLeft.getX();
	}

	public double getLeftY() {
		return adjustSpeed(driverLeft.getY());
	}

	public double getRotation() {
		return -adjustSpeed(driverLeft.getX());
	}
}