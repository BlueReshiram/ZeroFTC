package org.firstinspires.ftc.teamcode.zeroCode.utils;

import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

public class Turret {
    private CRServo turret1;
    private CRServo turret2;

    public Turret(){
        turret1 = Constants.turret.turret1;
        turret2 = Constants.turret.turret2;
    }

    public boolean powerTurret( double power){
        turret1.setPower(power);
        turret2.setPower(power);
        return true;
    }
}
