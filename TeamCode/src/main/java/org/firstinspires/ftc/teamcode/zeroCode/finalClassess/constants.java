package org.firstinspires.ftc.teamcode.zeroCode.finalClassess;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import android.util.Size;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;


public final class constants {
    //Everything in this class is a constant that can be refred to anywhere else in the code.
    public static final class field{

        //Might want to double check these values
        public static final int[] AprilRedHiveDown = {30, 31, 32, 33};
        public static final int[] AprilRedHiveUp = {34, 35, 36, 37};
        public static final int[] AprilBlueHiveUp = {38, 39, 40, 41};
        public static final int[] AprilBlueHiveDown = {42, 43, 44, 45};
    }

    public static final class robot{
        public enum alliance{
            BLUE,
            RED
        }

        public static double weight;

        //Configure what alliance the robot is on here:
        public static final alliance robotAlliance = alliance.RED;
    }

    public static final class webcam{
        public static final String webcamName = "webcam";
        public static AprilTagProcessor aprilTagProcessor;
        public static VisionPortal visionPortal;
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

        public static boolean initializeDrive = false;
        public static boolean initializeIMU = false;
        public static boolean initializeTurrets = false;
        public static boolean initializeIntake = false;
        public static boolean initializeLimelight = false;
        public static boolean initializeWebcam = true;
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

            if (initializeWebcam){
                webcam.aprilTagProcessor = new AprilTagProcessor.Builder()
                        .setDrawTagID(true)
                        .setDrawTagOutline(true)
                        .setDrawAxes(true)
                        .setDrawCubeProjection(true)
                        .setOutputUnits(DistanceUnit.CM, AngleUnit.DEGREES)
                        .build();

                VisionPortal.Builder builder = new VisionPortal.Builder();
                builder.setCamera(hardwareMap.get(WebcamName.class, webcam.webcamName));
                builder.setCameraResolution(new Size(640, 480));
                builder.addProcessor(webcam.aprilTagProcessor);

                webcam.visionPortal = builder.build();

                telemetry.addLine("Webcam and Vision Portal initialized.");
            } else {
                telemetry.addLine("Webcam and Vision Portal NOT initialized.");
            }

            telemetry.update();

        }

    }

}
