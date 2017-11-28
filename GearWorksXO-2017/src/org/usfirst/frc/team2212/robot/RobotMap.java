package org.usfirst.frc.team2212.robot;

public class RobotMap {
	// TODO insert correct ports
	public interface USB {

	}

	// TODO insert correct ports
	public interface CAN {
		public static final int GEAR_PICKER = 0;
		public static final int CLIMBER = 5;
		public static final int DRIVETRAIN_LEFT_FRONT = 1;
		public static final int DRIVETRAIN_LEFT_REAR = 2;
		public static final int DRIVETRAIN_RIGHT_FRONT = 3;
		public static final int DRIVETRAIN_RIGHT_REAR = 4;
	}

	// TODO insert correct ports
	public interface PWM {
		public static final int ELEVATOR = 0;
	}

	// TODO insert correct ports
	public interface DIO {
		public static final int ELEVATOR_DOWN = 0;
		public static final int ELEVATOR_UP = 1;
		public static final int ELEVATOR_ENCODER_A = 2;
		public static final int ELEVATOR_ENCODER_B = 3;
		public static final int GEAR_PICKER_DOWN = 4;
		public static final int GEAR_PICKER_UP = 5;
		public static final int GEAR_PICKER_ENCODER_A = 6;
		public static final int GEAR_PICKER_ENCODER_B = 7;
		public static final int DRIVETRAIN_LEFT_ENCODER_A = 8;
		public static final int DRIVETRAIN_LEFT_ENCODER_B = 9;
		public static final int DRIVETRAIN_RIGHT_ENCODER_A = 10;
		public static final int DRIVETRAIN_RIGHT_ENCODER_B = 11;
	}

	// TODO insert correct ports
	public interface AnalogInput {
		// public static final int GEAR_PICKER_POTENTIOMETER = 0;
	}
}
