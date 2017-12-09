package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public interface USB {
		public static final int LOW_CAM = 0;
		public static final int HIGH_CAM = 1;
	}

	public interface CAN {
		public static final int FOLDER = 0;

		public static final int DRIVE_LEFT_FRONT = 1;
		public static final int DRIVE_LEFT_REAR = 2;
		public static final int DRIVE_RIGHT_FRONT = 3;
		public static final int DRIVE_RIGHT_REAR = 4;

		public static final int ROLLER = 5;
	}

	public interface PWM {
		public static final int ELEVATOR_MOTOR = 0;
	}

	public interface DIO {
		public static final int ELEVATOR_DOWN = 9;
		public static final int ELEVATOR_UP = 8;
		public static final int ELEVATOR_ENCODER_A = 3;
		public static final int ELEVATOR_ENCODER_B = 4;

		public static final int FOLDER_DOWN = 7;
		public static final int FOLDER_UP = 5;

		public static final int DRIVE_LEFT_ENCODER_A = 0;
		public static final int DRIVE_LEFT_ENCODER_B = 1;
		public static final int DRIVE_RIGHT_ENCODER_A = 11;
		public static final int DRIVE_RIGHT_ENCODER_B = 10;

		public static final int ROLLER_HIGH_SENSOR = 6;
		public static final int ROLLER_LOW_SENSOR = 2;
	}

	public interface AnalogInput {
		public static final int FOLDER_POTENTIOMETER = 0;
	}

}