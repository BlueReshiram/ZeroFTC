package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

import java.util.List;

@TeleOp(name="TestingBallFinding", group="Testing")
public class BallFindingTestingTeleOp extends OpMode {
    VisionPortal visionPortal;
    ColorBlobLocatorProcessor colorProcessor;
    List<ColorBlobLocatorProcessor.Blob> detectedBlobs;
    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        Constants.hardware.initializeWebcam = true;
        Constants.hardware.initializeColorBlobLocator = true;
        Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        visionPortal = Constants.webcam.visionPortal;
        colorProcessor = Constants.colorDetection.colorLocator;



        telemetry.setMsTransmissionInterval(100);   // Speed up telemetry updates for debugging.
        telemetry.setDisplayFormat(Telemetry.DisplayFormat.MONOSPACE);


    }

    @Override
    public void loop() {
        //Getting all the blobs of color
        detectedBlobs = colorProcessor.getBlobs();

        for (ColorBlobLocatorProcessor.Blob blob : detectedBlobs) {
            //This is where we check the blobs and create some ball objects later.
        }
    }
}
