package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;


import java.util.ArrayList;
import java.util.List;

public class AprilTag {
    //Same as the limelight, just for the webcam.
    private Telemetry telemetry;
    private boolean displayTelemetry = true;
    protected AprilTagProcessor aprilTagProcessor;
    protected VisionPortal visionPortal;

    private boolean fastUpdatePose = false;

    public List<AprilTagDetection> detectedTags = new ArrayList<>();
    public Pose3D robotPose;
    public Position robotPosition;
    public double bearingScoring;
    public double bearingAudience;




    public AprilTag(boolean fastUpdatePose){
        aprilTagProcessor = Constants.webcam.aprilTagProcessor;
        visionPortal = Constants.webcam.visionPortal;
        this.fastUpdatePose = fastUpdatePose;
    }

    public void update(){
        AprilTagLibrary aprilTagLibrary;

        //Update the April Tags that the Robot sees
        detectedTags = aprilTagProcessor.getDetections();

        for (AprilTagDetection CurrentTag : detectedTags) {
            if (fastUpdatePose) {
                robotPose = CurrentTag.robotPose;
                robotPosition = robotPose.getPosition();}
            if (CurrentTag instanceof AprilTagClusterDetection) {
                AprilTagClusterDetection clusterDetection = (AprilTagClusterDetection) CurrentTag;

                if (Constants.robot.robotAlliance == Constants.robot.alliance.RED) {
                    //If we are on Red Team
                    if (clusterDetection.metadata.name.equals("RED AUDIENCE")) {
                        bearingAudience = clusterDetection.ftcPose.bearing;
                    } else {
                        bearingAudience = Double.NaN;
                    }

                    if (clusterDetection.metadata.name.equals("RED SCORING")) {
                        bearingScoring = clusterDetection.ftcPose.bearing;
                    } else {
                        bearingScoring = Double.NaN;
                    }
                } else {
                    //If we are on Blue Team
                    if (clusterDetection.metadata.name.equals("BLUE AUDIENCE")) {
                        bearingAudience = clusterDetection.ftcPose.bearing;
                    }  else {
                        bearingAudience = Double.NaN;
                    }

                    if (clusterDetection.metadata.name.equals("BLUE SCORING")) {
                        bearingAudience = clusterDetection.ftcPose.bearing;
                    } else {
                        bearingScoring = Double.NaN;
                    }
                }

            } else if (CurrentTag instanceof AprilTagSingleDetection){
                AprilTagSingleDetection singleDetection = (AprilTagSingleDetection) CurrentTag;

            }
        }


    }

    public List<AprilTagDetection> getDetectedTags(){
        return detectedTags;
    }

}
