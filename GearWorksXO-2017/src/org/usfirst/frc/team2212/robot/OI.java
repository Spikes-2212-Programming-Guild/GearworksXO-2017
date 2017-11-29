package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.commandGroups.DropGearAndMoveLift;
import org.usfirst.frc.team2212.robot.commands.commandGroups.DropGearWithAngle;
import org.usfirst.frc.team2212.robot.commands.commandGroups.PrepareToPickGear;
import org.usfirst.frc.team2212.robot.commands.commandGroups.RollGearAndFold;
import org.usfirst.frc.team2212.robot.subsystems.Climber;
import org.usfirst.frc.team2212.robot.subsystems.Elevator.ElevatorState;
import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.utils.XboXUID;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */ {

	private Joystick rightJoystick = new Joystick(0);
	private Joystick leftjJoystick = new Joystick(1);

	private Joystick navigatorJoystick = new Joystick(2);

	// driverRight buttons TODO maybe there are more buttons
	private Button switchToRearCameraButton;
	private Button switchToFrontCameraButton;

	// joystick navigator buttons
	private Button dropGearByAngleButton;
	private Button dropGearUpButton;
	private Button dropGearDownButton;
	private Button climbRopeButton;
	private Button foldDownButton;
	private Button pickGearButton;
	private Button takeGearButton;

	public OI() {
		// TODO if there are no cameras delete this
		// switchToFrontCameraButton = new JoystickButton(rightJoystick, 3);
		// switchToFrontCameraButton = new JoystickButton(rightJoystick, 2);

		// TODO change numbers for navigator buttons
		dropGearByAngleButton = new JoystickButton(navigatorJoystick, 1);
		dropGearUpButton = new JoystickButton(navigatorJoystick, 3);
		dropGearDownButton = new JoystickButton(navigatorJoystick, 2);
		climbRopeButton = new JoystickButton(navigatorJoystick, 4);
		foldDownButton = new JoystickButton(navigatorJoystick, 7);
		takeGearButton = new JoystickButton(navigatorJoystick, 6);

		dropGearByAngleButton
				.whenPressed(new DropGearWithAngle(Folder.SPEED_DOWN, RollerGripper.SPEED, RollerGripper.WAIT_TIME_DROP));
		dropGearDownButton.whenPressed(
				new DropGearAndMoveLift(RollerGripper.SPEED, RollerGripper.WAIT_TIME_DROP.get(), ElevatorState.MIDDLE));
		dropGearUpButton.whenPressed(new DropGearAndMoveLift(RollerGripper.SPEED, RollerGripper.WAIT_TIME_DROP.get(),
				ElevatorState.HIGH_LIMIT));
		climbRopeButton.toggleWhenPressed(new MoveLimitedSubsystem(Robot.climber, Climber.SPEED));
		foldDownButton.whenPressed(new PrepareToPickGear(Folder.SPEED_UP, Folder.SPEED_DOWN));
		takeGearButton.whenPressed(new RollGearAndFold(RollerGripper.SPEED, RollerGripper.WAIT_TIME_PICK.get(), Folder.SPEED_UP));
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

	// returns the adjusted value of the driving left joystick's y
	public double getForwardLeft() {
		return adjustInput(-rightJoystick.getY());
	}
}
