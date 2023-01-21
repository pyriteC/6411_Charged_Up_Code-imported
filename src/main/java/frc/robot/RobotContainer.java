// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
// import frc.robot.commands.ArcadeDrive;
// import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.DriverControls;
import frc.robot.LimeLight.LimeLight;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

 public static XboxController m_xboxController;
 public static  DriveTrain m_driveTrain;
 public static DriverControls m_driverControls;
 public static LimeLight m_limelight;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    m_xboxController = new XboxController(Constants.XBOX_USB_NUM);
    m_driveTrain = new DriveTrain();
    m_driverControls = new DriverControls(m_driveTrain,m_xboxController);
    m_limelight = new LimeLight();

     m_driveTrain.setDefaultCommand(Commands.run(
      () -> 
        m_driverControls.ModeSwitchMode(null)
        //  m_driverControls.tankMode()
        //  m_driverControls.arcadeMode()
        //  m_driverControls.singleStickMode()
        // m_driverControls.triggerHybridMode()
        //  m_driverControls.gameMode()
      ,m_driveTrain));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_arcadeDrive;
  // }

}
