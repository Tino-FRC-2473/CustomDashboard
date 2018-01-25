/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2473.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	PWMTalonSRX leftTalon1 = new PWMTalonSRX(0); 
	PWMTalonSRX leftTalon2 = new PWMTalonSRX(1);
	PWMTalonSRX rightTalon1 = new PWMTalonSRX(2);
	PWMTalonSRX rightTalon2 = new PWMTalonSRX(3);
	
	SpeedControllerGroup leftTalons = new SpeedControllerGroup(leftTalon1, leftTalon2);
	SpeedControllerGroup rightTalons = new SpeedControllerGroup(rightTalon1, rightTalon2);
	public DifferentialDrive drive = new DifferentialDrive(leftTalons, rightTalons);
	
	public DriveSubsystem() {
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public double returnSensorOutput() {
		return drive.getExpiration();
	}
}
