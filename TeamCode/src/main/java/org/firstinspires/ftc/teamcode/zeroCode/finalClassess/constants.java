package org.firstinspires.ftc.teamcode.zeroCode.finalClassess;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;



public final class constants {
    //Everything in this class is a constant that can be refred to anywhere else in the code.

    public static final class robot{
        public enum alliance{
            BLUE,
            RED
        }

        public static double weight;

        //Configure what alliance the robot is on here:
        public static final alliance robotAlliance = alliance.RED;
    }
    public static final class drive{
        public static final String frontLeftMotorName = "frontLeftMotor";
        public static final String frontRightMotorName = "frontRightMotor";
        public static final String backLeftMotorName = "backLeftMotor";
        public static final String backRightMotorName = "backRightMotor";
        public static DcMotor frontLeftMotor;
        public static DcMotor frontRightMotor;
        public static DcMotor backLeftMotor;
        public static DcMotor backRightMotor;
    }

    public static final class imu{
        public static final String imuName = "imu";
        public static IMU imu;

        public static void resetYaw(){
            imu.resetYaw();
            telemetry.addLine("IMU Yaw has been reset.");
        }
    }

    public static final class hardware {

        public static boolean initializeDrive = true;
        public static boolean initializeIMU = true;
        public static boolean initializeTurrets = false;
        public static boolean initializeIntake = false;
        public static boolean initializeLimelight = false;
        public static boolean initializeWebcam = false;
        public static void initializeHardwareMaps() {
            if (initializeDrive) {
                drive.frontLeftMotor = hardwareMap.get(DcMotor.class, drive.frontLeftMotorName);
                drive.frontRightMotor = hardwareMap.get(DcMotor.class, drive.frontRightMotorName);
                drive.backLeftMotor = hardwareMap.get(DcMotor.class, drive.backLeftMotorName);
                drive.backRightMotor = hardwareMap.get(DcMotor.class, drive.backRightMotorName);
                telemetry.addLine("Drive hardware maps initialized.");
            } else {
                telemetry.addLine("Drive hardware maps NOT initialized.");
            }

            if (initializeIMU) {
                imu.imu = hardwareMap.get(IMU.class, imu.imuName);
                IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
                // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
                imu.imu.initialize(parameters);

                telemetry.addLine("IMU hardware map initialized.");
            } else {
                telemetry.addLine("IMU hardware map NOT initialized.");
            }



        }

    }

}
