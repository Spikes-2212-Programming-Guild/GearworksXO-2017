package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//TODO insert correct ports
	public interface USB{
	}

	//TODO insert correct ports
	public interface CAN{
		public static final int CLIMBER = 4;
        public static final int ELEVATOR = 5;
	}

	//TODO insert correct ports
	public interface PWM{
	}

	//TODO insert correct ports
	public interface DIO{
		public static final int ELEVATOR_UP = 5;
		public static final int ELEVATOR_DOWN = 6;
		public static final int ELEVATOR_ENCODER_A = 7;
		public static final int ELEVATOR_ENCODER_B = 4;
	}

	//TODO insert correct ports
	public interface AnalogInput{
	}

}
