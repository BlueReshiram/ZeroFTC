package org.firstinspires.ftc.teamcode.zeroCode.utils;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

public class Shooter {
    private final Servo hood;
    private final Servo lever1;
    private final Servo lever2;

    public enum ShooterPositions {
        POLLEN_POSITION(0.0),
        NECTAR_POSITION(180.0);

        private double pos;

        ShooterPositions(double i) {
            this.pos = i;
        }
    }

    public Shooter() {
        hood = Constants.shooter.hood;
        lever1 = Constants.shooter.leverServo1;
        lever2 = Constants.shooter.leverServo2;
    }

    public void moveHoodToPosition(double position) {
        hood.setPosition(position);
    }

    public double getHoodPosition(){
        return hood.getPosition();
    }

    public void moveShooter(ShooterPositions position) {
        lever1.setPosition(position.pos);
        lever2.setPosition(position.pos);
    }
}
