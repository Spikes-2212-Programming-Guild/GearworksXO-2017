package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.MoveLimitedSubsystemWithTimeSinceReachingLimit;
import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PickGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToCollectGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToScoreHigh;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToScoreLow;
import org.usfirst.frc.team2212.robot.subsystems.Folder;

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
	private JoystickButton dropGear;
	private JoystickButton prepareToPickGear;
	private JoystickButton pickGear;
	private JoystickButton prepareToScoreLowPeg;
	private JoystickButton prepareToScoreHighPeg;
	private JoystickButton moveFolderUp;

	public OI() {
		initJoystickNavigator();
	}

	private void initJoystickNavigator() {

		dropGear = new JoystickButton(navigator, 1);
		prepareToPickGear = new JoystickButton(navigator, 8);
		pickGear = new JoystickButton(navigator, 9);
		prepareToScoreLowPeg = new JoystickButton(navigator, 2);
		prepareToScoreHighPeg = new JoystickButton(navigator, 3);
		moveFolderUp = new JoystickButton(navigator, 6);

		dropGear.whenPressed(new DropGear());
		prepareToPickGear.whenPressed(new PrepareToCollectGear());
		pickGear.toggleWhenPressed(new PickGear());
		prepareToScoreLowPeg.toggleWhenPressed(new PrepareToScoreLow());
		prepareToScoreHighPeg.toggleWhenPressed(new PrepareToScoreHigh());
		moveFolderUp.toggleWhenPressed(new MoveLimitedSubsystemWithTimeSinceReachingLimit(Robot.folder, Folder.SPEED_UP,
				Folder.WAIT_TIME.get()));

	}

	public Double adjustSpeed(double speed) {
		return Math.abs(speed) * speed;
	}

	public double getForward() {
		return adjustSpeed(driverRight.getY());
	}

	public double getRotation() {
		return -adjustSpeed(driverLeft.getX());
	}
}