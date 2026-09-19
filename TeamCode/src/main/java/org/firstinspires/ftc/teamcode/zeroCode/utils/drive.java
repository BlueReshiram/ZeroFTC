package org.firstinspires.ftc.teamcode.zeroCode.utils;


import static org.firstinspires.ftc.teamcode.zeroCode.constants.drive.backRightMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.constants.drive.backLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.constants.drive.frontLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.constants.drive.frontRightMotor;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import org.firstinspires.ftc.teamcode.zeroCode.constants;

public class drive {
    public static double botHeading(){
        return constants.imu.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }
    //double botHeading = ;

    public static double[] caculateDriveMecanumFC(double botHeading, double lx, double rx, double y){
        //lx = left stick x, rx = right stick x, y = left stick y?
        double rotX = lx * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = lx * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;  // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;

        return new double[]{frontLeftPower, frontRightPower, backLeftPower, backRightPower};
    }

    public static double[] caculateDriveMecanumRC(double lx, double rx, double y){
        double denominator = Math.max(Math.abs(y) + Math.abs(lx) + Math.abs(rx), 1);
        double frontLeftPower = (y + lx + rx) / denominator;
        double backLeftPower = (y - lx + rx) / denominator;
        double frontRightPower = (y - lx - rx) / denominator;
        double backRightPower = (y + lx - rx) / denominator;

        return new double[]{frontLeftPower, frontRightPower, backLeftPower, backRightPower};
    }

    public static void powerMotors(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower){
        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }



}