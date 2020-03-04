/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auto_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveTo extends CommandBase {

  double start, position;
  boolean arrived;

  public DriveTo(double inches) {

    position = (inches*Constants.TICKS_PER_INCH);

  }

  @Override
  public void initialize() {

    arrived = false;
    start = Drivetrain.getInstance().getRightPosition();

  }

  @Override
  public void execute() {

    Drivetrain.getInstance().driveForward(Constants.AUTO_DRIVE_SPEED1);
    arrived = Drivetrain.getInstance().getRightPosition() >= position + start;
    
  }

  @Override
  public void end(boolean interrupted) {

    Drivetrain.getInstance().setSpeed(0, 0);

  }

  @Override
  public boolean isFinished() {
    return arrived;
  }
}
