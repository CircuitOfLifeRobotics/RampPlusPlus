/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Elevator;

public class ElevatorDown extends CommandBase {

  public ElevatorDown() {
  }

  @Override
  public void initialize() {

    Elevator.getInstance().set(-1);
    System.out.println("DOWN");

  }

  @Override
  public void end(boolean interrupted) {

    Elevator.getInstance().set(0);

  }

  @Override
  public boolean isFinished() {

    return Elevator.getInstance().getEncPos() <= (Constants.ELEVATOR_DOWN)
      || Elevator.getInstance().getVoltage() < Constants.ELEVATOR_VOLTAGE_THRESHOLD
      || !OI.elevDown.get();
  
  }
  
}
