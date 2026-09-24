package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Pid;
import org.firstinspires.ftc.teamcode.zeroCode.utils.AprilTag;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Turret;

import java.util.concurrent.TimeUnit;

public class TurretTestingTeleOp extends OpMode {
    private static ElapsedTime timerPID = new ElapsedTime();
    private static ElapsedTime globalTimer = new ElapsedTime();
    private static AprilTag webcam;
    private static Pid pid;
    private Turret turret;
    private boolean turretConnected;
    private static double turretPower;

    @Override
    public void init() {
        Constants.hardware.initializeWebcam = true;
        Constants.hardware.initializeTurrets = true;

        if (Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap)) {
            telemetry.addLine("Initialization Successful");
        }
        else {
            telemetry.addLine("Initialization Failed");
        }

        webcam = new AprilTag(true);
        pid = new Pid(0, 0.01, 0, 0);
        turret = new Turret();
    }

    @Override
    public void start(){
        super.start();

        timerPID.reset();
        globalTimer.reset();
    }

    @Override
    public void loop() {
        webcam.update();

        if (timerPID.time(TimeUnit.MILLISECONDS) >= 10.0){
            if (!Double.isNaN(webcam.bearingScoring)){
                turretPower = pid.getOutput(globalTimer.time(), webcam.bearingScoring);
                telemetry.addData("Aiming for: ", "Scoring");
                telemetry.addData("Bearing: ", webcam.bearingScoring);
                telemetry.addData("Turret Power: ", turretPower);
            } else if (!Double.isNaN(webcam.bearingAudience)) {
                turretPower = pid.getOutput(globalTimer.time(), webcam.bearingAudience);
                telemetry.addData("Aiming for: ", "Audience");
                telemetry.addData("Bearing: ", webcam.bearingAudience);
                telemetry.addData("Turret Power: ", turretPower);
            } else {
                telemetry.addData("Aiming for: ", "Nothing");
                telemetry.addData("Bearing: ", webcam.bearingAudience);
                telemetry.addData("Turret Power: ", turretPower);
                turretPower = 0;
                globalTimer.reset();
            }

            timerPID.reset();
        }

        turretConnected = turret.powerTurret(Turret.Turrets.LEFT, turretPower);
        if (!turretConnected){
            telemetry.addData("Turret is: ", "Not Connected");
        }
    }
}
