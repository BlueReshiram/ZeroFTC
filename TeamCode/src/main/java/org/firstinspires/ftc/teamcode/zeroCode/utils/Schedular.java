package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

public class Schedular {
    private SubsystemBase[] subsystems;

    public Schedular() {
        
    }

    public void execute() {
        for (SubsystemBase subsystem : subsystems) {
            subsystem.periodic();
            if (Constants.robot.robotMode == Constants.robot.RobotMode.REAL) {
                subsystem.realPeriodic();
            } else {
                subsystem.simulationPeriodic();
            }
        }
    }
}
