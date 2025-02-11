package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Constants.AlgaeConstants.AlgaePosition;
import frc.robot.Constants.ClimberConstants.ClimberPosition;
import frc.robot.subsystems.AlgaeIntake;
import frc.robot.subsystems.Climber;

public class IntakeTime extends Command{
    AlgaeIntake rotate;
    AlgaePosition pos;

    public IntakeTime(AlgaeIntake rotate, AlgaePosition pos){
        this.rotate = rotate;
        this.pos = pos;
        addRequirements(rotate);
    }
    @Override
    public void initialize() {

    }

    @Override
    //makes the motor move
    public void execute() {
        rotate.RotateIn(.2);
    }

    @Override
    //stops the motor
    public void end(boolean interrupted) {
        rotate.stopRotator();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
   
}