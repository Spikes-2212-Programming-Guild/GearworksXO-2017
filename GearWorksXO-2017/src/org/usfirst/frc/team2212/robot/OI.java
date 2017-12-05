package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.MoveFolder;
import org.usfirst.frc.team2212.robot.commands.RollGearToLightSensor;
import org.usfirst.frc.team2212.robot.commands.RollGearWithTime;
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
	private JoystickButton testRollEithTimeOut;

	public OI() {
		initJoystickNavigator();
	}

	private void initJoystickNavigator() {

		moveElevatorToHigh = new JoystickButton(navigator, 3);
		moveElevatorToLow = new JoystickButton(navigator, 2);
		rollGearIn = new JoystickButton(navigator, 4);
		moveFolderUp = new JoystickButton(navigator, 5);
		moveFolderDown = new JoystickButton(navigator, 6);
		dropGear = new JoystickButton(navigator, 1);
		prepareToPickGear = new JoystickButton(navigator, 8);
		pickGear = new JoystickButton(navigator, 9);
		testRollEithTimeOut = new JoystickButton(navigator, 10);
		

		moveElevatorToHigh.whenPressed(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP));
		moveElevatorToLow.whenPressed(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN));
		rollGearIn.whenPressed(new RollGearToLightSensor(RollerGripper.SPEED_IN.get()));
		moveFolderUp.whenPressed(new MoveFolder(Folder.SPEED_UP, Folder.WAIT_TIME.get()));
		moveFolderDown.whenPressed(
				new MoveFolder(() -> Robot.folder.isMax() ? Folder.SPEED_DOWN_A.get() : Folder.SPEED_DOWN_B.get(),
						Folder.WAIT_TIME.get()));

		dropGear.whenPressed(new DropGear());
		prepareToPickGear.whenPressed(new PrepareToCollectGear());
		pickGear.whenPressed(new PickGear());
		
		testRollEithTimeOut.whenPressed(new RollGearWithTime(0.5, 5));
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