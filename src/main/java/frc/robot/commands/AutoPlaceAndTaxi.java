// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutoPlaceAndTaxi extends CommandBase {
  /** Creates a new autoPlaceAndTaxi. */
    // Use addRequirements() here to declare subsystem dependencies.
      public Timer moveTime;
  public Timer fallTimer;
  public Timer dropTimer;
  public AutoPlaceAndTaxi() {
    // Use addRequirements() here to declare subsystem dependencies.
    moveTime = new Timer();
    fallTimer = new Timer();
    dropTimer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
 {
   System.out.println("autoStart");
    RobotContainer.m_intake.set(Constants.IDLE_SPEED);

    boolean positionCondition = false;
    while (!positionCondition){
      positionCondition = RobotContainer.m_arm.setPosition(-120);
    }

    dropTimer.reset();
    dropTimer.start();
    //!Does not set direction of idle mode; only sets the direction of the on() method
    RobotContainer.m_intake.setDirection("Outward");
    while (dropTimer.get()< Constants.DROP_TIME)
    {}
    RobotContainer.m_intake.set(0);


positionCondition = false;
    while (!positionCondition){
      positionCondition = RobotContainer.m_arm.setPosition(-20);
    }
    moveTime.reset();
    moveTime.start();
    while (moveTime.get() <Constants.MOVE_FORWARD_TIME + .5)
    {
          RobotContainer.m_driveTrain.driveForward(Constants.AUTO_DRIVE_TRAIN_SPEED);
          System.out.println(moveTime.get());
        }
     
    
    
 }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    RobotContainer.m_driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
