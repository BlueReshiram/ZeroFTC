package org.firstinspires.ftc.teamcode.zeroCode.utils;

import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

public class Turret {
    private CRServo turret;

    public Turret(){
        turret = Constants.turret.turret;
    }

    public boolean powerTurret( double power){
        turret.setPower(power);
        return true;
    }
}
