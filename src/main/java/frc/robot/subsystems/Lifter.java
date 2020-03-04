/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Lifter extends SubsystemBase {
  
  private boolean isHigh;

  DoubleSolenoid lifter = new DoubleSolenoid(RobotMap.liftHigh, RobotMap.liftLow);
  private static Lifter instance;
  public static Lifter getInstance(){
    if(instance == null)
      instance = new Lifter();
    return instance;
  }
  private Lifter() {
    lifter.set(Value.kReverse);
    isHigh = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void cycle(){
    if(isHigh){
      lifter.set(Value.kForward);
    }
    else{
      lifter.set(Value.kReverse);
    }
    isHigh = !isHigh;
  }

}
