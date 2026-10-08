package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.AprilTag;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;

@TeleOp(name="AprilTagVision", group="Testing")
public class VisionTestingTeleOp extends OpMode {
    private static AprilTag april;
    private static AprilTagLibrary aprilTagLibrary;

    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        april = new AprilTag(true);

        telemetry.addLine("Robot Inlitized");
        telemetry.update();


    }

    @Override
    public void loop() {

        april.update();
    }
}
