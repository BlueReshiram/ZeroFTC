package org.firstinspires.ftc.teamcode.zeroCode.utils.drive;


import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.backRightMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.backLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.frontLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.frontRightMotor;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;

public class Drive {
    public double botHeading(){
        return Constants.imu.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }

    public void powerMotors(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower){
        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }



}