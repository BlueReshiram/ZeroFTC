package org.firstinspires.ftc.teamcode.zeroCode.utils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.constants;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.ArrayList;
import java.util.List;

public class webcamAprilTag {
    //Same as the limelight, just for the webcam.
    protected AprilTagProcessor aprilTagProcessor;
    protected VisionPortal visionPortal;

    protected List<AprilTagDetection> detectedTags = new ArrayList<>();

    public webcamAprilTag(){
        aprilTagProcessor = constants.webcam.aprilTagProcessor;
        visionPortal = constants.webcam.visionPortal;
    }

    public void update(){
        detectedTags = aprilTagProcessor.getDetections();

    }

    public List<AprilTagDetection> getDetectedTags(){
        return detectedTags;
    }



}
