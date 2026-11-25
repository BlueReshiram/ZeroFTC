package org.firstinspires.ftc.teamcode.zeroCode.subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Subsystem;

public class IntakesSubsystem implements Subsystem {
    DcMotor pollenIntake;
    DcMotor nectarIntake;


    public IntakesSubsystem(){
        pollenIntake = Constants.intakes.intakePollen;
        nectarIntake = Constants.intakes.intakeNectar;
    }
    public void powerPollenIntake(double power) {
        pollenIntake.setPower(power);
    }

    public void powerNectarIntake(double power) {
        nectarIntake.setPower(power);
    }
}
