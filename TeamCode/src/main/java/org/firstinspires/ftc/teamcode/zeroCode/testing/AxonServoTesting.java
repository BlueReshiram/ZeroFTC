package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

@TeleOp(name="TestingAxonServos", group="Testing")
public class AxonServoTesting extends OpMode {
    private CRServo axonServo;

    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        axonServo = hardwareMap.get(CRServo.class, "axon");
    }

    @Override
    public void loop() {
        axonServo.setPower(gamepad2.left_stick_x);

    }
}
