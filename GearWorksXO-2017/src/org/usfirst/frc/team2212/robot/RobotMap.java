package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// TODO insert correct ports
	public interface USB {

	}

	// TODO insert correct ports
	public interface CAN {
		public static final int FOLDER= 0;

		public static final int CLIMBER = 5;

		public static final int DRIVE_LEFT_FRONT = 1;
		public static final int DRIVE_LEFT_REAR = 2;
		public static final int DRIVE_RIGHT_FRONT = 3;
		public static final int DRIVE_RIGHT_REAR = 4;
	}

	// TODO insert correct ports
	public interface PWM {
		public static final int ELEVATOR_MOTOR = 0;
		public static final int ROLLER_MOTOR = 1;
	}

	// TODO insert correct ports
	public interface DIO {
		public static final int ELEVATOR_DOWN = 0;
		public static final int ELEVATOR_UP = 1;
		public static final int ELEVATOR_ENCODER_A = 2;
		public static final int ELEVATOR_ENCODER_B = 3;

		public static final int FOLDER_DOWN = 4;
		public static final int FOLDER_UP = 5;
		public static final int FOLDER_ENCODER_A = 6;
		public static final int FOLDER_ENCODER_B = 7;

		public static final int DRIVE_LEFT_ENCODER_A = 8;
		public static final int DRIVE_LEFT_ENCODER_B = 9;
		public static final int DRIVE_RIGHT_ENCODER_A = 10;
		public static final int DRIVE_RIGHT_ENCODER_B = 11;
		
		public static final int ROLLER_SENSOR = 12;
	}

	// TODO insert correct ports
	public interface AnalogInput {
		public static final int FOLDER_POTENTIOMETER = 0;
	}

}
