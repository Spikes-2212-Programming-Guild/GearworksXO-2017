package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//TODO
	public interface USB{
	}
	
	//TODO
	public interface CAN{
		public static final int ELEVATOR = 1;
	}
	
	//TODO
	public interface PWM{
	}
	
	//TODO
	public interface DIO{
		public static final int LIFT_UP = 1;
		public static final int LIFT_DOWN = 2;
		public static final int LIFT_ENCODER_A = 3;
		public static final int LIFT_ENCODER_B = 4;
	}
	
	//TODO
	public interface AnalogInput{
	}
	
}
