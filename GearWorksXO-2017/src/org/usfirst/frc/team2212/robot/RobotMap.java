package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public interface USB{
	}
	
	public interface CAN{
		public static final int LIFT = 1;
	}
	
	public interface PWM{
	}
	
	public interface DIO{
		public static final int LIFT_UP = 1;
		public static final int LIFT_DOWN = 2;
		public static final int LIFT_ENCODER_A = 3;
		public static final int LIFT_ENCODER_B = 4;
	}
	
	public interface AnalogInterface{
	}
	
}
