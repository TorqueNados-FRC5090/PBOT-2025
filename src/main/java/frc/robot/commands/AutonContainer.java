package frc.robot.commands;

import static frc.robot.Constants.SwerveConstants.*;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.config.ModuleConfig;
import com.pathplanner.lib.config.PIDConstants;
import com.pathplanner.lib.config.RobotConfig;
import com.pathplanner.lib.controllers.PPHolonomicDriveController;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.SwerveConstants.ModuleConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CTRESwerveDrivetrain;

/** A container that stores various procedures for the autonomous portion of the game */
public class AutonContainer {
    private CTRESwerveDrivetrain drivetrain;

    /** Constructs an AutonContainer object */ 
    public AutonContainer(RobotContainer robot) {
        this.drivetrain = robot.drivetrain;
        registerNamedCommands();

        RobotConfig config;
        ModuleConfig moduleConfig;
        DCMotor motor = new DCMotor(12.6, 5, 40, 20, 5, 1);
        moduleConfig = new ModuleConfig(ModuleConstants.WHEEL_DIAMETER / 2, MAX_TRANSLATION_SPEED, 1, motor, 20, 1);
        config = new RobotConfig(45, 3.5, moduleConfig, MODULE_TRANSLATIONS);


        AutoBuilder.configure(
            drivetrain::getPose, 
            drivetrain::resetPose,
            drivetrain::getChassisSpeeds,
            (speeds, feedforwards) -> drivetrain.driveRobotRelative(speeds),
            new PPHolonomicDriveController( // HolonomicPathFollowerConfig, this should likely live in your Constants class
                    new PIDConstants(5.0, 0.0, 0.0), // Translation PID constants
                    new PIDConstants(5.0, 0.0, 0.0) // Rotation PID constants
            ),
            config,
            () -> robot.onRedAlliance(),
            drivetrain);
    }

    private void registerNamedCommands() {
        NamedCommands.registerCommand("Do Nothing", doNothing() );
    }

    public SendableChooser<Command> buildAutonChooser() {
        SendableChooser<Command> chooser = new SendableChooser<Command>();
        chooser.setDefaultOption("Do Nothing", doNothing());
        return chooser;
    }

    /** Auton that does nothing */
    public Command doNothing() {
        return new WaitCommand(0);
    }
}