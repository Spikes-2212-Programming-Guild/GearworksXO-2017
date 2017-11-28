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
		public static final int LIFT = 6;
		public static final int DRIVE_LEFT_1 = 0;
		public static final int DRIVE_LEFT_2 = 1;
		public static final int DRIVE_RIGHT_1 = 2;
		public static final int DRIVE_RIGHT_2 = 3;
		public static final int CLIMBER = 4;
	}
	
	//TODO insert correct ports
	public interface PWM{
	}
	
	//TODO insert correct ports
	public interface DIO{
		public static final int LIFT_UP = 5;
		public static final int LIFT_DOWN = 6;
		public static final int LIFT_ENCODER_A = 7;
		public static final int LIFT_ENCODER_B = 4;
		public static final int DRIVE_ENCODER_LEFT_A = 0;
		public static final int DRIVE_ENCODER_LEFT_B = 1;
		public static final int DRIVE_ENCODER_RIGHT_A = 2;
		public static final int DRIVE_ENCODER_RIGHT_B = 3;
	}
	
	//TODO insert correct ports
	public interface AnalogInput{
	}
	
	
}
