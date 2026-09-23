package org.firstinspires.ftc.teamcode.zeroCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.aprilTag;
import org.firstinspires.ftc.teamcode.zeroCode.utils.drive.driveFC;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;

@TeleOp(name="Main: OpModeV1", group="OpMode")
public class MainTeleOp extends OpMode {
    private driveFC robotDrive;
    private aprilTag webcam;

    @Override
    public void init() {
        constants.hardware.initializeDrive = true;
        constants.hardware.initializeWebcam = true;
        constants.hardware.initializeIMU = true;

        if (constants.hardware.initializeHardwareMaps(telemetry, hardwareMap)) {
            telemetry.addLine("Initialization Successful");
        }
        else {
            telemetry.addLine("Initialization Failed");
        }

        robotDrive = new driveFC();
        webcam = new aprilTag(true);
    }

    @Override
    public void loop() {
        //Driving
        if (gamepad1.options){constants.imu.resetYaw();}
        double[] power = robotDrive.calculateDriveMecanumFC(
                robotDrive.botHeading(),
                gamepad1.left_stick_x,
                gamepad1.right_stick_x,
                gamepad1.left_stick_y);
        robotDrive.powerMotors(power[0], power[1], power[2], power[3]);

        webcam.update();



        telemetry.update();
    }
}
