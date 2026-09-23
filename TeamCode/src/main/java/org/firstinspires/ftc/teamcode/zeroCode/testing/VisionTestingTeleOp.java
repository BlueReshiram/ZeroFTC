package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.aprilTag;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;

@TeleOp(name="Testing: VisionTesting", group="OpMode")
public class VisionTestingTeleOp extends OpMode {
    private static aprilTag april;
    private static AprilTagLibrary aprilTagLibrary;

    @Override
    public void init() {
        constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        april = new aprilTag(true);




        telemetry.addLine("Robot Inlitized");
        telemetry.update();


    }

    @Override
    public void loop() {

        april.update();
    }
}
