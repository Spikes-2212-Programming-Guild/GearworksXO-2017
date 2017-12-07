package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PickGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToCollectGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToScore;
import org.usfirst.frc.team2212.robot.subsystems.Elevator;
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
	private JoystickButton dropGear;
	private JoystickButton prepareToPickGear;
	private JoystickButton pickGear;
	private JoystickButton prepareToScoreLowPeg;
	private JoystickButton prepareToScoreHighPeg;

	public OI() {
		initJoystickNavigator();
	}

	private void initJoystickNavigator() {

		moveElevatorToHigh = new JoystickButton(navigator, 3);
		moveElevatorToLow = new JoystickButton(navigator, 2);
		dropGear = new JoystickButton(navigator, 1);
		prepareToPickGear = new JoystickButton(navigator, 8);
		pickGear = new JoystickButton(navigator, 9);
		prepareToScoreLowPeg = new JoystickButton(navigator, 6);
		prepareToScoreHighPeg = new JoystickButton(navigator, 7);

		moveElevatorToHigh.whenPressed(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_UP));
		moveElevatorToLow.whenPressed(new MoveLimitedSubsystem(Robot.elevator, Elevator.SPEED_DOWN));

		dropGear.whenPressed(new DropGear(
				Robot.elevator.isMax() ? RollerGripper.SPEED_OUT_HIGH_PEG.get() : RollerGripper.SPEED_OUT_LOW_PEG.get(),
				Robot.elevator.isMax() ? Elevator.SPEED_DOWN.get() : Elevator.SPEED_UP.get()));
		prepareToPickGear.whenPressed(new PrepareToCollectGear());
		pickGear.toggleWhenPressed(new PickGear());
		prepareToScoreLowPeg.whenPressed(new PrepareToScore(Elevator.SPEED_DOWN.get()));
		prepareToScoreHighPeg.whenPressed(new PrepareToScore(Elevator.SPEED_UP.get()));

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