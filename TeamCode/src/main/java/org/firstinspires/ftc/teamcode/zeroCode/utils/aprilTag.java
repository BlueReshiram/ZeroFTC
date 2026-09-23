package org.firstinspires.ftc.teamcode.zeroCode.utils;

import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.fieldData;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;
import org.firstinspires.ftc.vision.apriltag.AprilTagPoseFtc;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;


import java.util.ArrayList;
import java.util.List;

public class aprilTag {
    //Same as the limelight, just for the webcam.
    private Telemetry telemetry;
    private boolean displayTelemetry = true;
    protected AprilTagProcessor aprilTagProcessor;
    protected VisionPortal visionPortal;

    private boolean fastUpdatePose = false;

    public List<AprilTagDetection> detectedTags = new ArrayList<>();
    public Pose3D robotPose;
    public Position robotPosition;




    public aprilTag(boolean fastUpdatePose){
        aprilTagProcessor = constants.webcam.aprilTagProcessor;
        visionPortal = constants.webcam.visionPortal;
        this.fastUpdatePose = fastUpdatePose;
    }

    public void update(){
        AprilTagLibrary aprilTagLibrary;

        //Update the April Tags that the Robot sees
        detectedTags = aprilTagProcessor.getDetections();

        //Find the Pose3D of the robot
        for (AprilTagDetection CurrentTag : detectedTags) {
            if (fastUpdatePose) {
                robotPose = CurrentTag.robotPose;
                robotPosition = robotPose.getPosition();
            }
            if (CurrentTag instanceof AprilTagClusterDetection) {
                AprilTagClusterDetection clusterDetection = (AprilTagClusterDetection) CurrentTag;
            } else if (CurrentTag instanceof AprilTagSingleDetection){
                AprilTagSingleDetection singleDetection = (AprilTagSingleDetection) CurrentTag;

            }
        }

        constants.telemetry.addLine(robotPose.toString());

    }

    public List<AprilTagDetection> getDetectedTags(){
        return detectedTags;
    }

    public double angleToTag(fieldData.hiveTags tag){
        double angle = 0;
        double x = robotPosition.x;
        double y = robotPosition.y;

        return angle;


    }

}
