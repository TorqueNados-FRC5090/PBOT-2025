package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.wrappers.GenericPID;


public class Elevator {
     // Declare variables
    public SparkMax leadMotor;
    public SparkMax followerMotor; 
    public GenericPID elevatorPID;
    


    // Constructor 
    public Elevator(int leadMotorID, int followerMotorID, double p) {
        leadMotor = new SparkMax(leadMotorID, MotorType.kBrushless);
        followerMotor = new SparkMax(followerMotorID, MotorType.kBrushless);
       
        elevatorPID = new GenericPID(leadMotor, ControlType.kPosition, p);
        
           // configuration for follower motor
        SparkMaxConfig followConfig = new SparkMaxConfig();
        followConfig.follow(leadMotorID, false);
        
        followerMotor.configure(followConfig, ResetMode.kResetSafeParameters , PersistMode.kPersistParameters);



    }

    public void elevate(){
        
    }

    

  
}
