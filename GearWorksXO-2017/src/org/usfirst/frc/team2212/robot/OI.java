package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.commandGroups.DropGearAndMoveLift;
import org.usfirst.frc.team2212.robot.commands.commandGroups.DropGearWithAngle;
import org.usfirst.frc.team2212.robot.commands.commandGroups.PickUpGearAndFold;
import org.usfirst.frc.team2212.robot.commands.commandGroups.PrepareToPickGear;
import org.usfirst.frc.team2212.robot.subsystems.Climber;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */ {

	private Joystick rightJoystick = new Joystick(0);
	private Joystick leftJoystick = new Joystick(1);

	private Joystick navigatorJoystick = new Joystick(2);

	// joystick navigator buttons
	private Button dropGearByAngleButton;
	private Button dropGearToLowPegButton;
	private Button dropGearToHighPegButton;
	private Button climbRopeButton;
	private Button prepareToTakeGearButton;
	private Button pickUpGearButton;
	private Button moveLiftUp;
	private Button moveLiftToMiddle;

	public OI() {
		// TODO change numbers for navigator buttons
		dropGearByAngleButton = new JoystickButton(navigatorJoystick, 1);
		dropGearToLowPegButton = new JoystickButton(navigatorJoystick, 3);
		dropGearToHighPegButton = new JoystickButton(navigatorJoystick, 2);
		climbRopeButton = new JoystickButton(navigatorJoystick, 4);
		prepareToTakeGearButton = new JoystickButton(navigatorJoystick, 7);
		pickUpGearButton = new JoystickButton(navigatorJoystick, 6);
		moveLiftUp = new JoystickButton(navigatorJoystick, 11);
		moveLiftToMiddle = new JoystickButton(navigatorJoystick, 10);

		dropGearByAngleButton.whenPressed(
				new DropGearWithAngle(Folder.SPEED_DOWN, RollerGripper.SPEED, RollerGripper.WAIT_TIME_DROP));
		dropGearToHighPegButton.whenPressed(
				new DropGearAndMoveLift(RollerGripper.SPEED, RollerGripper.WAIT_TIME_DROP.get(), ElevatorState.MIDDLE));

		dropGearToLowPegButton.whenPressed(new DropGearAndMoveLift(RollerGripper.SPEED,
				RollerGripper.WAIT_TIME_DROP.get(), ElevatorState.HIGH_LIMIT));
		climbRopeButton.toggleWhenPressed(new MoveLimitedSubsystem(Robot.climber, Climber.SPEED));
		prepareToTakeGearButton.whenPressed(new PrepareToPickGear(Folder.SPEED_UP, Folder.SPEED_DOWN));

		pickUpGearButton.whenPressed(
				new PickUpGearAndFold(RollerGripper.SPEED, RollerGripper.WAIT_TIME_PICK.get(), Folder.SPEED_UP));
		moveLiftUp.whenPressed(new MoveElevator(ElevatorState.HIGH_LIMIT));
		moveLiftToMiddle.whenPressed(new MoveElevator(ElevatorState.MIDDLE));
	}

	// receives input, returns the adjusted input for better sensitivity
	private double adjustInput(double input) {
		return input * Math.abs(input);
	}

	// returns the adjusted value of the Rotate
	// switch this to switch between the 2 drive arcade methods
	public double getRotation() {
		return adjustInput(-rightJoystick.getX());
	}

	// returns the adjusted value of the driving right joystick's y
	public double getForwardRight() {
		return adjustInput(rightJoystick.getY());
	}
}
