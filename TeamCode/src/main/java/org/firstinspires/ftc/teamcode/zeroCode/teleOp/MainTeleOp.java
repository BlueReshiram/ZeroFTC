package org.firstinspires.ftc.teamcode.zeroCode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.drive;

@TeleOp(name="Main: OpModeV1", group="OpMode")
public class MainTeleOp extends OpMode {

    @Override
    public void init() {
        constants.hardware.initializeHardwareMaps();
    }

    @Override
    public void loop() {
        //Driving
        if (gamepad1.options){constants.imu.resetYaw();}
        double[] power = drive.calculateDriveMecanumFC(
                drive.botHeading(),
                gamepad1.left_stick_x,
                gamepad1.right_stick_x,
                gamepad1.left_stick_y);
        drive.powerMotors(power[0], power[1], power[2], power[3]);


    }
}
