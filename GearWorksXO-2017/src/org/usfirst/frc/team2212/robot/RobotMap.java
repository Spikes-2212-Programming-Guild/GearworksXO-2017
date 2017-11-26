package org.usfirst.frc.team2212.robot;

public class RobotMap {
	// TODO insert correct ports
	public interface USB {

	}

	// TODO insert correct ports
	public interface CAN {
		public static final int GEAR_PICKER = 0;
		public static final int CLIMBER = 4;
		public static final int ELEVATOR = 5;
	}

	// TODO insert correct ports
	public interface PWM {
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
	}

	// TODO insert correct ports
	public interface AnalogInput {
		// public static final int GEAR_PICKER_POTENTIOMETER = 0;
	}
}
