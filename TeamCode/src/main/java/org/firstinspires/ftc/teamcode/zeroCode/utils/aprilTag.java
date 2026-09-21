package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.ArrayList;
import java.util.List;

public class aprilTag {
    //Same as the limelight, just for the webcam.
    protected AprilTagProcessor aprilTagProcessor;
    protected VisionPortal visionPortal;

    protected List<AprilTagDetection> detectedTags = new ArrayList<>();

    public aprilTag(){
        aprilTagProcessor = constants.webcam.aprilTagProcessor;
        visionPortal = constants.webcam.visionPortal;
    }

    public void update(){
        detectedTags = aprilTagProcessor.getDetections();
        if (detectedTags.get(0) instanceof AprilTagClusterDetection){
            AprilTagClusterDetection singleDetection = (AprilTagClusterDetection)detectedTags;
            singleDetection.
        }

    }

    public List<AprilTagDetection> getDetectedTags(){
        return detectedTags;
    }



}
