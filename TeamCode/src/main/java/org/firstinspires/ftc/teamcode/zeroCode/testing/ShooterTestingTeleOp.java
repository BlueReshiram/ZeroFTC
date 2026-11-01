package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Shooter;

public class ShooterTestingTeleOp extends OpMode {
    private Shooter shooter;
    private double maxHoodPos = 180;
    private double minHoodPos = 0;
    private double hoodPos = 0;

    //A higher number is a lower speed, and vice versa
    //Speeds must greater than 0
    private double hoodPosSpeed = 1;

    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        Constants.hardware.initializeWebcam = true;
        Constants.hardware.initializeTurret = true;

        Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        shooter = new Shooter();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            shooter.moveShooter(Shooter.ShooterPositions.NECTAR_POSITION);
        } else if (gamepad1.b) {
            shooter.moveShooter(Shooter.ShooterPositions.POLLEN_POSITION);
        }

        hoodPos += gamepad1.left_stick_y/10 * hoodPosSpeed;

        shooter.moveHoodToPosition(Math.min(Math.max(maxHoodPos, hoodPos),minHoodPos));
    }
}
