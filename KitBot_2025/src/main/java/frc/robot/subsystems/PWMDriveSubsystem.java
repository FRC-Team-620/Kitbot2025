// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// import com.revrobotics.spark.SparkBase.PersistMode;
// import com.revrobotics.spark.SparkBase.ResetMode;
// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

// Class to drive the robot over CAN
public class PWMDriveSubsystem extends SubsystemBase {
  private final Spark leftLeader;
  private final Spark leftFollower;
  private final Spark rightLeader;
  private final Spark rightFollower;

  private final DifferentialDrive drive;

  public PWMDriveSubsystem() {
    // create brushed motors for drive
  
    leftLeader = new Spark(DriveConstants.LEFT_LEADER_ID);
    leftFollower = new Spark(DriveConstants.LEFT_FOLLOWER_ID);
    rightLeader = new Spark(DriveConstants.RIGHT_LEADER_ID);
    rightFollower = new Spark(DriveConstants.RIGHT_FOLLOWER_ID);
    rightLeader.setInverted(true);
    leftLeader.setInverted(true);
    leftLeader.addFollower(leftFollower);
    rightLeader.addFollower(rightFollower);

    


    // set up differential drive class
    drive = new DifferentialDrive(leftLeader, rightLeader);
  }

  @Override
  public void periodic() {
  }

  // sets the speed of the drive motors
  public void driveArcade(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }
}
