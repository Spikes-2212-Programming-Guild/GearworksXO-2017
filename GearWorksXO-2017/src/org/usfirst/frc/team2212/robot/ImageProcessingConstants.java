package org.usfirst.frc.team2212.robot;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * A class which calculates the position of the peg by the values given from the
 * "ImageProcessing" {@link NetworkTable} and puts it into a static
 * {@link Supplier}
 *
 */
public class ImageProcessingConstants {
	public static final int CAMERA_WIDTH = 640;
	public static final int CAMERA_HEIGHT = 360;

	public static final NetworkTable NETWORK_TABLE = NetworkTable.getTable("ImageProcessing");

	// calculates the center of the big reflective on the X axis on a scale
	// between -0.5 and 0.5
	public static final Supplier<Double> BIG_OBJECT_CENTER = () -> ((NETWORK_TABLE.getNumber("x0", 0)
			+ 0.5 * NETWORK_TABLE.getNumber("width0", 0)) / CAMERA_WIDTH - 0.5);
	// calculates the center of the small reflective on the X axis on a scale
	// between -0.5 and 0.5
	public static final Supplier<Double> SMALL_OBJECT_CENTER = () -> ((NETWORK_TABLE.getNumber("x1", 0)
			+ 0.5 * NETWORK_TABLE.getNumber("width1", 0)) / CAMERA_WIDTH - 0.5);
	// calculates the center of the two reflectives on the X axis on a scale
	// between -0.5 and 0.5
	public static Supplier<Double> TWO_OBJECTS_CENTER = () -> (BIG_OBJECT_CENTER.get() + SMALL_OBJECT_CENTER.get()) / 2;

}