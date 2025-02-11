package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.AlgaeConstants.AlgaePosition;
import frc.robot.subsystems.AlgaeIntake;

public class RotateTime extends Command{
    AlgaeIntake Rotator;
   

    public RotateTime(AlgaeIntake Rotator){
        this.Rotator = Rotator;
        addRequirements(Rotator);
    }
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        this.Rotator.RotateOut(0.4);
    }

    @Override
    public void end(boolean interrupted) {
        Rotator.stopRotator();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
   
} 
    

