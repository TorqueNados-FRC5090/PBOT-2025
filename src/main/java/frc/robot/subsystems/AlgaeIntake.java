package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.wrappers.GenericPID;
import frc.robot.Constants.AlgaeConstants.AlgaePosition;
public class AlgaeIntake extends SubsystemBase{

    SparkMax Intake;
    SparkMax Rotator;
    GenericPID position;
    AlgaePosition pos;

    public AlgaeIntake ( int rotatorID, int intakeID){
        
    Intake = new SparkMax(intakeID, MotorType.kBrushless);

    Rotator = new SparkMax(rotatorID, MotorType.kBrushless);

    position = new GenericPID(Intake, ControlType.kPosition, 0.027);

}
    //brings the intake down
    public void DownIntake(double speed){
       Intake.set(speed);
    }
    //wheels in the intake spin toward the robot
    public void RotateIn(double speed){
        Rotator.set(speed);
    }
    //wheels spin away from the robot
    public void RotateOut(double speed){
        Rotator.set(speed);
    }
    //stops the intake 
    public void stopIntake(){
        Intake.set(0);
    }
    //stops the wheels from spinning
    public void stopRotator(){
        Rotator.set(0);
    }
    //sets the position of the intake
    public void IntakePosition(AlgaePosition pos){
        this.position.activate(pos.getAngle());
    }
    @Override
    public void periodic() {
        SmartDashboard.putNumber(getName() , 0);
    }
    
}




