package org.firstinspires.ftc.teamcode.zeroCode.utils;

import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

public class Turret {
    private CRServo leftTurret;
    private CRServo rightTurret;
    public enum Turrets{
        LEFT,
        RIGHT
    }

    public Turret(){
        leftTurret = Constants.turrets.turretLeft;
        rightTurret = Constants.turrets.turretRight;
    }

    public boolean powerTurret(Turrets turret, double power){
        if (turret == Turrets.LEFT){
            leftTurret.setPower(power);
        } else if (turret == Turrets.RIGHT) {
            rightTurret.setPower(power);
        } else {
            return false;
        }
        return true;
    }
}
