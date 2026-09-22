package org.firstinspires.ftc.teamcode.zeroCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.aprilTag;

@TeleOp(name="Main: VisionTesting", group="OpMode")
public class VisionTestingTeleOp extends OpMode {
    private static aprilTag april;

    @Override
    public void init() {
        constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        april = new aprilTag();

        telemetry.addLine("Robot Inlitized");
        telemetry.update();
    }

    @Override
    public void loop() {

        april.update();
    }
}
