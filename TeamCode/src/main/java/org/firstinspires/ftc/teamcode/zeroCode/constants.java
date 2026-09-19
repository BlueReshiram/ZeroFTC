package org.firstinspires.ftc.teamcode.zeroCode;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

public final class constants {
    //Everything in this class is a constant that can be refred to anywhere else in the code.

    public static class robot{
        public static double weight;
    }
    public static class drive{
        //Where the robot is facing foward
        public static String frontLeftMotorName = "frontLeftMotor";
        public static String frontRightMotorName = "frontRightMotor";
        public static String backLeftMotorName = "backLeftMotor";
        public static String backRightMotorName = "backRightMotor";
        public static DcMotor frontLeftMotor;
        public static DcMotor frontRightMotor;
        public static DcMotor backLeftMotor;
        public static DcMotor backRightMotor;
    }

    public static class imu{
        public static String imuName = "imu";
        public static IMU imu;

        public static void resetYaw(){
            imu.resetYaw();
            telemetry.addLine("IMU Yaw has been reset.");
        }
    }

    public static void initializeHardwareMaps(){
        drive.frontLeftMotor = hardwareMap.get(DcMotor.class, drive.frontLeftMotorName);
        drive.frontRightMotor = hardwareMap.get(DcMotor.class, drive.frontRightMotorName);
        drive.backLeftMotor = hardwareMap.get(DcMotor.class, drive.backLeftMotorName);
        drive.backRightMotor = hardwareMap.get(DcMotor.class, drive.backRightMotorName);

        imu.imu = hardwareMap.get(IMU.class, imu.imuName);

        telemetry.addLine("Hardware Maps Initialized.");

    }

}
