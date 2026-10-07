package org.firstinspires.ftc.teamcode.zeroCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Pid;
import org.firstinspires.ftc.teamcode.zeroCode.utils.AprilTag;
import org.firstinspires.ftc.teamcode.zeroCode.utils.drive.DriveFC;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Turret;

import java.util.concurrent.TimeUnit;

@TeleOp(name="Main: OpModeV1", group="OpMode")
public class MainTeleOp extends OpMode {
    private DriveFC robotDrive;
    private AprilTag webcam;
    private Pid pid;
    private Turret turret;

    private ElapsedTime timerPID = new ElapsedTime();
    private ElapsedTime globalTimer = new ElapsedTime();

    //Delete this varible later and put it into a turret util class.
    private double turretPower;

    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        Constants.hardware.initializeDrive = true;
        Constants.hardware.initializeWebcam = true;
        Constants.hardware.initializeIMU = true;

        if (Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap)) {
            telemetry.addLine("Initialization Successful");
        }
        else {
            telemetry.addLine("Initialization Failed");
        }

        robotDrive = new DriveFC();
        webcam = new AprilTag(true);
        pid = new Pid(0, 0.01, 0, 0);
        turret = new Turret();

    }

    @Override
    public void start() {
        super.start();

        timerPID.reset();
        globalTimer.reset();
    }

    @Override
    public void loop() {
        //Driving
        if (gamepad1.options){
            Constants.imu.resetYaw();}
        double[] power = robotDrive.calculateDriveMecanumFC(
                robotDrive.botHeading(),
                gamepad1.left_stick_x,
                gamepad1.right_stick_x,
                gamepad1.left_stick_y);
        robotDrive.powerMotors(power[0], power[1], power[2], power[3]);

        if (timerPID.time(TimeUnit.MILLISECONDS) >= 10.0){
            if (!Double.isNaN(webcam.bearingScoring)){
                turret.powerTurret(Turret.Turrets.LEFT, pid.getOutput(globalTimer.time(), webcam.bearingScoring));
            } else if (!Double.isNaN(webcam.bearingAudience)) {
                turretPower = pid.getOutput(globalTimer.time(), webcam.bearingAudience);
            }

            timerPID.reset();
        }

        webcam.update();

        telemetry.update();
    }
}
