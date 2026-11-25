package org.firstinspires.ftc.teamcode.zeroCode.subsystems.drive;


import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.backRightMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.backLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.frontLeftMotor;
import static org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants.drive.frontRightMotor;

import org.firstinspires.ftc.robotcore.external.Supplier;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.IO;
import org.firstinspires.ftc.teamcode.zeroCode.utils.Subsystem;

public class DriveSubsystem implements Subsystem {
    private Supplier<Pose2D> poseSupplier;

    private IO driveIO;
    private Pose2D pose;
    public DriveSubsystem(Supplier<Pose2D> poseSupplier){
        this.poseSupplier = poseSupplier;

        driveIO = Constants.robot.robotMode == Constants.robot.RobotMode.REAL
                ? new DriveIO(Constants.telemetry, Constants.hardwareMap)
                : new DriveIOSim(Constants.telemetry);
    }

    public void driveToCoordinates() {}

    public void driveWithControls() {}

    @Override
    public void periodic() {
        Subsystem.super.periodic();

    }
}