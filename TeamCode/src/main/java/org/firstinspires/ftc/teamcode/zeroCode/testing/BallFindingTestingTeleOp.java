package org.firstinspires.ftc.teamcode.zeroCode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.zeroCode.finalClassess.Constants;
import org.firstinspires.ftc.teamcode.zeroCode.utils.ColorLocator;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;
import org.opencv.core.Point;

import java.util.List;

@TeleOp(name="TestingBallFinding", group="Testing")
public class BallFindingTestingTeleOp extends OpMode {
    private VisionPortal visionPortal;
    private ColorBlobLocatorProcessor colorProcessor;
    private List<ColorBlobLocatorProcessor.Blob> detectedBlobs;
    private ColorLocator colorLocator;

    @Override
    public void init() {
        Constants.hardware.resetHardwareMaps(telemetry);
        Constants.hardware.initializeWebcam = true;
        Constants.hardware.initializeColorBlobLocator = true;
        Constants.hardware.initializeHardwareMaps(telemetry, hardwareMap);

        visionPortal = Constants.webcam.visionPortal;
        colorProcessor = Constants.colorDetection.colorLocator;

        colorLocator = new ColorLocator(colorProcessor);

        telemetry.setMsTransmissionInterval(100);   // Speed up telemetry updates for debugging.
        telemetry.setDisplayFormat(Telemetry.DisplayFormat.MONOSPACE);


    }

    @Override
    public void loop() {
        //Getting all the blobs of color
        detectedBlobs = colorLocator.getBlobs();

        telemetry.addData("Bearing", colorLocator.getBearing());
    }
}
