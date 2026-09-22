package org.firstinspires.ftc.teamcode.zeroCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.aprilTag;

@TeleOp(name="Main: VisionTesting", group="OpMode")
public class VisionTestingTeleOp extends OpMode {
    private static aprilTag april;

    @Override
    public void init() {
        constants.hardware.initializeHardwareMaps();

        april = new aprilTag();

        telemetry.addLine("Robot Inlitized");
        telemetry.update();
    }

    @Override
    public void loop() {
        telemetry.update();

        april.update();
    }
}
