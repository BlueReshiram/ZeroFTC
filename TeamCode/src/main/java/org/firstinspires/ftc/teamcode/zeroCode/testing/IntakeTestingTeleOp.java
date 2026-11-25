package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

@TeleOp(name="IntakeTesting", group="Testing")
public class IntakeTestingTeleOp extends OpMode {
    private DcMotor intakePollen;
    private DcMotor intakeNectar;
    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        Constants.hardware.initializeIntakes = true;
        Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        intakePollen = Constants.intakes.intakePollen;
        intakeNectar = Constants.intakes.intakeNectar;

        telemetry.update();
    }

    @Override
    public void loop() {
        double pollenPower = gamepad1.left_stick_y;
        double nectarPower = gamepad1.right_stick_y;


        if (gamepad1.a) {
            pollenPower = 1;
        } else if (gamepad1.b) {
            pollenPower = 0.1;
        }

        if (gamepad1.x) {
            nectarPower = 1;
        } else if (gamepad1.y) {
            nectarPower = 0.1;
        }

        intakePollen.setPower(pollenPower);
        intakeNectar.setPower(nectarPower);

        telemetry.addData("Intake Pollen Power: ", intakePollen.getPower());
        telemetry.addData("Intake Nectar Power: ", intakeNectar.getPower());
    }
}
