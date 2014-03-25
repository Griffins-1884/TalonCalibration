package org.usfirst.frc1884;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends IterativeRobot {
    private Joystick stick;
    private Talon[] talons;
    
    public void robotInit() {
        stick = new Joystick(1);
        for(int i = 1; i <= 10; i++) {
            talons[i] = new Talon(i);
        }
    }
    
    public void teleopPeriodic() {
        double value = stick.getRawAxis(1);
        if(Math.abs(value) < 0.5) {
            value = 0.0;
        } else if(value >= 0.5) {
            value = 1.0;
        } else if(value <= 0.5) {
            value = -1.0;
        }
        
        for(int i = 1; i <= 10; i++) {
            talons[i].set(value);
        }
    }
}