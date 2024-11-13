package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.TurretSubsystem;

public class Robot extends TimedRobot {

    // Declare the turret subsystem
    private TurretSubsystem turretSubsystem;

    @Override
    public void robotInit() {
        // Initialize the turret subsystem with SPARK MAX CAN ID 1 and joystick port 0
        turretSubsystem = new TurretSubsystem(1, 0);
    }

    @Override
    public void teleopPeriodic() {
        // Call periodic updates for the turret
        turretSubsystem.periodic();
    }
}
