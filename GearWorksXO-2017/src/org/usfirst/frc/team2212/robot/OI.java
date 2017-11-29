package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.RollGearIn;
import org.usfirst.frc.team2212.robot.commands.RollGearOut;
import org.usfirst.frc.team2212.robot.commands.command_groups.CollectGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;
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
	private Joystick driverLeft = new Joystick(0);
	private Joystick driverRight = new Joystick(1);
	private Joystick navigator = new Joystick(2);

	// defining folder buttons
	private JoystickButton moveFolderUp;
	// defining roller buttons
	private JoystickButton rollGearIn;
	private JoystickButton rollGearOut;
	// defining command groups buttons
	private JoystickButton collectGear;
	private JoystickButton dropGearHigh;
	private JoystickButton dropGearLow;

	public OI() {
		// initializing folder buttons
		moveFolderUp = new JoystickButton(navigator, 2);
		// initializing roller buttons
		rollGearIn = new JoystickButton(navigator, 5);
		rollGearOut = new JoystickButton(navigator, 6);
		// initializing command groups buttons
		collectGear = new JoystickButton(navigator, 7);
		dropGearHigh = new JoystickButton(navigator, 3);
		dropGearLow = new JoystickButton(navigator, 4);

		// activating folder buttons
		moveFolderUp.whenPressed(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));

		// activating roller buttons
		rollGearIn.whenPressed(new RollGearIn(RollerGripper.SPEED_IN.get()));
		rollGearOut.toggleWhenPressed(
				new RollGearOut(RollerGripper.WAIT_TIME_DROP.get(), RollerGripper.SPEED_OUT_HIGH_PEG.get()));

		// activating command groups buttons
		collectGear.whenPressed(new CollectGear());
		dropGearHigh.whenPressed(new DropGear(ElevatorState.HIGH_LIMIT));
		dropGearLow.whenPressed(new DropGear(ElevatorState.MIDDLE));

	}

	public Double adjustSpeed(double speed) {
		return Math.abs(speed) * speed;
	}

	public double getForwardRight() {
		return adjustSpeed(driverRight.getY());
	}

	public double getForwardLeft() {
		return adjustSpeed(driverLeft.getY());
	}

	public double getRotation() {
		return adjustSpeed(driverLeft.getX());
	}
}
