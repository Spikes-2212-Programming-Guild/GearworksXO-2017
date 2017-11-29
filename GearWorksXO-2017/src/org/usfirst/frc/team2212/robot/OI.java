package org.usfirst.frc.team2212.robot;

import com.spikes2212.utils.XboXUID;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /*GEVALD*/{

	private Joystick joystick1 = new Joystick(0);
	private Joystick joystick2 = new Joystick(1);
	
	private XboXUID xboxController = new XboXUID(0);
	
	// driverRight buttons TODO maybe there are more buttons
		private Button switchToRearCameraButton;
		private Button switchToFrontCameraButton;

		// joystick navigator buttons
		private Button dropGearByAngleButton;
		private Button dropGearUpButton;
		private Button dropGearDownAngleButton;
		private Button climbRopeButton; 
		private Button foldDownn;
		private Button pickGear;
		private Button foldUp;

	
}
