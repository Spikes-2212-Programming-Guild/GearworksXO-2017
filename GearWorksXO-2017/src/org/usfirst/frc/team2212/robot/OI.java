package org.usfirst.frc.team2212.robot;

import jdk.nashorn.internal.scripts.JO;
import org.usfirst.frc.team2212.robot.commands.MoveElevator;
import org.usfirst.frc.team2212.robot.commands.RollGearIn;
import org.usfirst.frc.team2212.robot.commands.RollGearOut;
import org.usfirst.frc.team2212.robot.commands.command_groups.DropGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PickGear;
import org.usfirst.frc.team2212.robot.commands.command_groups.PrepareToCollectGear;
import org.usfirst.frc.team2212.robot.subsystems.Climber;
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
	private Joystick driverLeft = new Joystick(0);
	private Joystick driverRight = new Joystick(1);
	private Joystick navigator = new Joystick(2);

	//move elevator
	private JoystickButton moveElevatorToMiddle;
	private JoystickButton moveElevatorToHigh;
	// defining roller button
	private JoystickButton rollGearIn;
	//folder buttons
	private JoystickButton moveFolderUp;
	private JoystickButton moveFolderDown;
	//drop gear
	private JoystickButton dropGear;
	// defining prepare to pick gear button
	private JoystickButton prepareToPickGear;
	// defining button to pick the gear
	private JoystickButton pickGear;
	//defining climbing button
	private JoystickButton climb;
	public OI() {
		moveElevatorToHigh = new JoystickButton(navigator,2);
		moveElevatorToMiddle = new JoystickButton(navigator,3);

		rollGearIn=new JoystickButton(navigator,4);

		moveFolderUp=new JoystickButton(navigator,5);
		moveFolderDown=new JoystickButton(navigator,6);

		dropGear=new JoystickButton(navigator,7);

		prepareToPickGear=new JoystickButton(navigator,8);

		pickGear=new JoystickButton(navigator,9);

		climb=new JoystickButton(navigator,1);



		moveElevatorToHigh.whenPressed(new MoveElevator(Elevator.HIGH_SET_POINT.get()));
		moveElevatorToMiddle.whenPressed(new MoveElevator(Elevator.MIDDLE_SET_POINT.get()));

		rollGearIn.whenPressed(new RollGearIn(RollerGripper.SPEED_IN.get()));

		moveFolderUp.whenPressed(new MoveLimitedSubsystem(Robot.folder,Folder.SPEED_UP));
		moveFolderDown.whenPressed(new MoveLimitedSubsystem(Robot.folder,
				Robot.folder.isMax() ? Folder.SPEED_DOWN_A : Folder.SPEED_DOWN_B));

		dropGear.whenPressed(new DropGear());

		prepareToPickGear.whenPressed(new PrepareToCollectGear());

		pickGear.whenPressed(new PickGear());

		climb.whenPressed(new MoveLimitedSubsystem(Robot.climber, Climber.SPEED.get()));




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