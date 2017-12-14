
package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.MoveLimitedSubsystemWithTimeSinceReachingLimit;
import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PickGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToCollectGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToScoreHigh;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToScoreLow;
import org.usfirst.frc.team2212.robot.commands.command_groups.StopEverything;
import org.usfirst.frc.team2212.robot.commands.orientation.TurnAndMoveToGear;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
import org.usfirst.frc.team2212.robot.subsystems.Folder;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI/* GEVALD */ {

	// initializing joysticks
	private Joystick driver = new Joystick(1);
	private Joystick navigator = new Joystick(0);

	// driver
	private JoystickButton TurnAndMoveToGearAll;

	// navigator joystick
	private JoystickButton dropGear;
	private JoystickButton prepareToPickGear;
	private JoystickButton pickGear;
	private JoystickButton prepareToScoreLowPeg;
	private JoystickButton prepareToScoreHighPeg;
	private JoystickButton moveFolderUp;
	private JoystickButton stopEverything;

	public OI() {
		initJoystickDriver();
		initJoystickNavigator();
	}

	private void initJoystickNavigator() {

		dropGear = new JoystickButton(navigator, 1);
		prepareToPickGear = new JoystickButton(navigator, 8);
		pickGear = new JoystickButton(navigator, 9);
		prepareToScoreLowPeg = new JoystickButton(navigator, 2);
		prepareToScoreHighPeg = new JoystickButton(navigator, 3);
		moveFolderUp = new JoystickButton(navigator, 4);
		stopEverything = new JoystickButton(navigator, 5);

		dropGear.whenPressed(new DropGear());
		prepareToPickGear.whenPressed(new PrepareToCollectGear());
		pickGear.whenPressed(new PickGear());
		prepareToScoreLowPeg.toggleWhenPressed(new PrepareToScoreLow());
		prepareToScoreHighPeg.toggleWhenPressed(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP));
		moveFolderUp.toggleWhenPressed(new MoveLimitedSubsystemWithTimeSinceReachingLimit(Robot.folder, Folder.SPEED_UP,
				Folder.WAIT_TIME.get()));
		stopEverything.whileHeld(new StopEverything());
	}

	private void initJoystickDriver() {
		TurnAndMoveToGearAll = new JoystickButton(driver, 1);

		TurnAndMoveToGearAll.whileHeld(new TurnAndMoveToGear(this::getDriverX, this::getDriverY));

	}

	public double adjustSpeed(double speed) {
		return Math.abs(speed) * speed;
	}

	public double getDriverX() {
		return driver.getX();
	}

	public double getDriverY() {
		return -adjustSpeed(driver.getY());
	}

	public double getRotation() {
		return driver.getX();
	}
}