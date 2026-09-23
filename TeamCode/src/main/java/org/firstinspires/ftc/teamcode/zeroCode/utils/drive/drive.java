package org.firstinspires.ftc.teamcode.zeroCode.utils.drive;


import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants.drive.backRightMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants.drive.backLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants.drive.frontLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants.drive.frontRightMotor;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;

public class drive {
    public double botHeading(){
        return constants.imu.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }

    public void powerMotors(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower){
        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }



}