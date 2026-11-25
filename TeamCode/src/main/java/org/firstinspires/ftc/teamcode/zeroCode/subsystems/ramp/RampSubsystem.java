package org.firstinspires.ftc.teamcode.zeroCode.subsystems.ramp;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Subsystem;

public class RampSubsystem implements Subsystem {
    Servo ramp;
    public RampSubsystem() {
        ramp = Constants.ramp.ramp;
    }

    public void turnToPollen() {
        ramp.setPosition(Constants.ramp.rampPollenAngle);
    }

    public void turnToNectar() {
        ramp.setPosition(Constants.ramp.rampNectarAngle);
    }

}
