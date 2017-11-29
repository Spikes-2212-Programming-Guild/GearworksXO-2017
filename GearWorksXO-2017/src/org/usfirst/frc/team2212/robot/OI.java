package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.subsystems.Folder;
import org.usfirst.frc.team2212.robot.subsystems.RollerGripper;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystemWithPID;

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
	private JoystickButton moveFolderMid;
	private JoystickButton moveFolderDown;
	// defining roller buttons
	private JoystickButton rollGearIn;
	private JoystickButton rollGearOut;

	public OI() {
		// initializing folder buttons
		moveFolderUp = new JoystickButton(navigator, 2);
		moveFolderMid = new JoystickButton(navigator, 3);
		moveFolderDown = new JoystickButton(navigator, 4);
		// initializing roller buttons
		rollGearIn = new JoystickButton(navigator, 5);
		rollGearOut = new JoystickButton(navigator, 6);

		// activating folder buttons
		moveFolderDown.whenPressed(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_DOWN));
		moveFolderUp.whenPressed(new MoveLimitedSubsystem(Robot.folder, Folder.SPEED_UP));
		moveFolderMid.whenPressed(new MoveLimitedSubsystemWithPID(Robot.folder, Folder.INITIAL_MID_ANGLE,
				Folder.KP.get(), Folder.KI.get(), Folder.KD.get(), Folder.TOLERANCE.get()));

		// activating folder buttons
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
