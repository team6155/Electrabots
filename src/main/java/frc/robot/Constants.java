// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Computer USB ports
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;


    public static final class InputConstants {
        public static final double DEADBAND = 0.05;
        public static final double ACCELERATION_RATE_LIMIT = .9;
    }

    public static final class DriveConstants {
        public static final int FRONT_LEFT_DRIVING_MOTOR_PORT = 7;
        public static final int FRONT_RIGHT_DRIVING_MOTOR_PORT = 3;
        public static final int REAR_LEFT_DRIVING_MOTOR_PORT = 6;
        public static final int REAR_RIGHT_DRIVING_MOTOR_PORT = 2;

        public static final int FRONT_LEFT_TURNING_MOTOR_PORT = 8;
        public static final int FRONT_RIGHT_TURNING_MOTOR_PORT = 4;
        public static final int REAR_LEFT_TURNING_MOTOR_PORT = 5;
        public static final int REAR_RIGHT_TURNING_MOTOR_PORT = 1;
        
        public static final boolean FRONT_LEFT_DRIVING_MOTOR_REVERSED = false;
        public static final boolean FRONT_RIGHT_DRIVING_MOTOR_REVERSED = false;
        public static final boolean REAR_LEFT_DRIVING_MOTOR_REVERSED = false;
        public static final boolean REAR_RIGHT_DRIVING_MOTOR_REVERSED = false;
        
        public static final boolean FRONT_LEFT_TURNING_MOTOR_REVERSED = false;
        public static final boolean FRONT_RIGHT_TURNING_MOTOR_REVERSED = false;
        public static final boolean REAR_LEFT_TURNING_MOTOR_REVERSED = false;
        public static final boolean REAR_RIGHT_TURNING_MOTOR_REVERSED = false;

        public static final int[] FRONT_LEFT_TURNING_ENCODER_PORTS = new int[] {6, 7};
        public static final int[] FRONT_RIGHT_TURNING_ENCODER_PORTS = new int[] {8, 9};
        public static final int[] REAR_LEFT_TURNING_ENCODER_PORTS = new int[] {2, 3};
        public static final int[] REAR_RIGHT_TURNING_ENCODER_PORTS = new int[] {0, 1};

        /** Distance between left and right wheels. */
        public static final double TRACK_WIDTH_METERS = .387;
        /** Distance between front and back wheels. */
        public static final double WHEEL_BASE_METERS = .711;
        public static final SwerveDriveKinematics DRIVE_KINEMATICS =
            new SwerveDriveKinematics(
                new Translation2d(WHEEL_BASE_METERS / 2, TRACK_WIDTH_METERS / 2),
                new Translation2d(WHEEL_BASE_METERS / 2, -TRACK_WIDTH_METERS / 2),
                new Translation2d(-WHEEL_BASE_METERS / 2, TRACK_WIDTH_METERS / 2),
                new Translation2d(-WHEEL_BASE_METERS / 2, -TRACK_WIDTH_METERS / 2)   
            );
        
        public static boolean GYRO_REVERSED = false;

        public static final double MAX_SPEED_METERS_PER_SECOND = 1;
        public static final double MAX_ANGULAR_SPEED_RADIANS_PER_SECOND = 2 * Math.PI;
        public static final double SPEED_RATIO = .75;
        public static final Rotation2d STARTING_ROTATION = new Rotation2d(Math.PI);
    }

    public static final class SwerveModuleConstants {
        public static final double TURNING_CONTROLLER_P_VALUE = 4;

        public static final Constraints ROTATION_CONSTRAINTS = new Constraints(2 * Math.PI, 2 * Math.PI);

        public static final double ENCODER_CYCLES_PER_REVOLUTION = 420;
        public static final double WHEEL_DIAMETER_METERS = .102;

        public static final double TURNING_ENCODER_DISTANCE_PER_PULSE =
            (2 * Math.PI) / ENCODER_CYCLES_PER_REVOLUTION;
        
    }

    public static final class CameraConstants {
        public static final int MAIN_CAMERA_CHANNEL = 0;
    }
}
