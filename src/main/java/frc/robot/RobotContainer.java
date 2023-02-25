// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.commands.ControlArm;
import frc.robot.commands.ControlWrist;
import frc.robot.commands.TeleOpDrive;
import frc.robot.commands.ToggleGrabber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.GrabberArm;
import frc.robot.subsystems.GrabberWrist;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  CommandXboxController driverController = new CommandXboxController(Constants.DRIVER_CONTROLLER_PORT);
  CommandXboxController operatorController = new CommandXboxController(Constants.OPERATOR_CONTROLLER_PORT);
  private final Gyro GYRO = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

  // The robot's subsystems
  private final Drivetrain DRIVETRAIN_SUBSYSTEM = new Drivetrain();
  private final Grabber GRABBER = new Grabber();
  private final GrabberArm GRABBER_ARM = new GrabberArm();
  private final GrabberWrist GRABBER_WRIST = new GrabberWrist();

  // The robot's commands
  private final TeleOpDrive DRIVE_COMMAND = new TeleOpDrive(
    DRIVETRAIN_SUBSYSTEM,
    () -> driverController.getLeftX(),
    () -> driverController.getLeftY(),
    () -> driverController.getRightX()
  );

  private final ToggleGrabber TOGGLE_GRABBER = new ToggleGrabber(GRABBER);

  private final ControlArm CONTROL_ARM = new ControlArm(
    GRABBER_ARM,
    () -> operatorController.getLeftY()
  );

  private final ControlWrist CONTROL_WRIST = new ControlWrist(
    GRABBER_WRIST,
    () -> operatorController.getRightY()
  );


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    DRIVETRAIN_SUBSYSTEM.setDefaultCommand(DRIVE_COMMAND);
    GRABBER_ARM.setDefaultCommand(CONTROL_ARM);
    GRABBER_WRIST.setDefaultCommand(CONTROL_WRIST);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    operatorController.a().onTrue(TOGGLE_GRABBER);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }

  public void resetGyro() {
    GYRO.reset();
  }

  public void calibrateGyro() {
    GYRO.calibrate();
  }
}
