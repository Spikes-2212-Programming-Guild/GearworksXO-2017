package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public interface PWM {
		public static final int GRIPPER_MOTOR_PORT = 0;
	}

	public interface DIO {
		public static final int GRIPPER_LIGHT_SENSOR_PORT = 1;
	}
}
