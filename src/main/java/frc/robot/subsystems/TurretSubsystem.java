package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {

    // Motor controller for the turret
    private final CANSparkMax turretMotor;

    // Joystick for controlling the turret
    private final Joystick joystick; // Warning: Might not be used if the joystick input isn't used elsewhere.

    // Constructor
    public TurretSubsystem(int motorCANID, int joystickPort) {
        // Initialize the SPARK MAX with the correct CAN ID and motor type (Brushed for SIM motors)
        turretMotor = new CANSparkMax(motorCANID, MotorType.kBrushed);
        joystick = new Joystick(joystickPort);

        // Restore motor controller to factory defaults
        turretMotor.restoreFactoryDefaults();

        // Optional: Set a ramp rate to avoid abrupt movement
        turretMotor.setOpenLoopRampRate(0.5); // Adjust ramp time as needed
    }

    /**
     * Moves the turret based on joystick input.
     */
    public void controlTurret() {
        // Get joystick axis for turret control (assumes axis 0 for horizontal rotation)
        double turretSpeed = joystick.getRawAxis(0);

        // Apply deadband to prevent unintended small movements
        if (Math.abs(turretSpeed) < 0.05) {
            turretSpeed = 0.0;
        }

        // Set motor speed based on joystick input
        turretMotor.set(turretSpeed);
    }

    @Override
    public void periodic() {
        // Update turret control periodically
        controlTurret();
    }
}
