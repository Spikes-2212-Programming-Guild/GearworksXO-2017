package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.RollGearToLightSensor;
import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PickGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToCollectGear;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
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
	private Joystick driverLeft = new Joystick(2);
	private Joystick driverRight = new Joystick(1);
	private Joystick navigator = new Joystick(0);

	// navigator
	private JoystickButton moveElevatorToLow;
	private JoystickButton moveElevatorToHigh;
	private JoystickButton rollGearIn;
	private JoystickButton moveFolderUp;
	private JoystickButton moveFolderDown;
	private JoystickButton dropGear;
	private JoystickButton prepareToPickGear;
	private JoystickButton pickGear;

	public OI() {
		initJoystickNavigator();
	}

	private void initJoystickNavigator() {

		moveElevatorToHigh = new JoystickButton(navigator, 3);
		moveElevatorToLow = new JoystickButton(navigator, 2);
		rollGearIn = new JoystickButton(navigator, 4);
		moveFolderUp = new JoystickButton(navigator, 5);
		moveFolderDown = new JoystickButton(navigator, 6);
		dropGear = new JoystickButton(navigator, 7);
		prepareToPickGear = new JoystickButton(navigator, 8);
		pickGear = new JoystickButton(navigator, 9);

		moveElevatorToHigh.whileHeld(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP));
		moveElevatorToLow.whenPressed(new MoveLimitedSubsystem(Robot.elevator, -0.8));
		rollGearIn.whenPressed(new RollGearToLightSensor(RollerGripper.SPEED_IN.get()));
		moveFolderUp.whenPressed(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));
		moveFolderDown.whenPressed(new MoveLimitedSubsystem(Robot.folder,
				() -> Robot.folder.isMax() ? Folder.SPEED_DOWN_A.get() : Folder.SPEED_DOWN_B.get()));

		dropGear.whenPressed(new DropGear());
		prepareToPickGear.whenPressed(new PrepareToCollectGear());
		pickGear.whenPressed(new PickGear());
	}

	public Double adjustSpeed(double speed) {
		return Math.abs(speed) * speed;
	}

	public double getForward() {
		return adjustSpeed(driverRight.getY());
	}

	public double getRotation() {
		return adjustSpeed(driverLeft.getX());
	}
}